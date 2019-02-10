/**
 * Project Name: mms-provider-face
 * File Name: FaceServiceImpl.java
 * Package Name: com.why.dev.mms.face.service.impl
 * Date: 2018/12/23 8:42 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.service.impl;

import com.arcsoft.face.*;
import com.arcsoft.face.enums.ImageFormat;
import com.google.common.collect.Lists;
import com.why.dev.mms.face.common.StatusCode;
import com.why.dev.mms.face.dao.FaceMapper;
import com.why.dev.mms.face.dto.*;
import com.why.dev.mms.face.feign.SMFeign;
import com.why.dev.mms.face.pojo.Face;
import com.why.dev.mms.face.service.FaceService;
import com.why.dev.mms.face.util.FaceEngineFactory;
import com.why.dev.mms.face.util.ImageUtil;
import com.why.dev.mms.face.vo.FaceInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ClassName: FaceServiceImpl
 * Description: 面部信息业务逻辑实现
 * Date: 2018/12/23 8:42 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
@Service
public class FaceServiceImpl implements FaceService {

    @Resource
    private FaceMapper faceMapper;

    @Autowired
    private SMFeign smFeign;

    @Value("${arcsoft.sdk.face.app-id}")
    public String appId;

    @Value("${arcsoft.sdk.face.sdk-key}")
    public String sdkKey;

    @Value("${arcsoft.sdk.face.thread-pool-size}")
    public Integer threadPoolSize;

    private ExecutorService executorService;
    private GenericObjectPool<FaceEngine> extractFaceFeatureObjectPool;
    private GenericObjectPool<FaceEngine> compareFaceFeatureObjectPool;

    @PostConstruct
    public void init() {
        executorService = Executors.newFixedThreadPool(threadPoolSize);
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(threadPoolSize);
        poolConfig.setMaxTotal(threadPoolSize);
        poolConfig.setMinIdle(threadPoolSize);
        poolConfig.setLifo(false);
        extractFaceFeatureObjectPool = new GenericObjectPool(new FaceEngineFactory(appId, sdkKey, FunctionConfiguration.builder().supportFaceDetect(true).supportFaceRecognition(true).supportAge(true).supportGender(true).build()), poolConfig);//底层库算法对象池
        compareFaceFeatureObjectPool = new GenericObjectPool(new FaceEngineFactory(appId, sdkKey, FunctionConfiguration.builder().supportFaceRecognition(true).build()), poolConfig);//底层库算法对象池
    }

    /**
     * addFace: 添加新的面部信息
     *
     * @param faceDto
     * @return  成功: {true, "添加面部信息成功", 201}
     *          失败: {false, "参数为空", 400}, {false, "没有捕捉到人脸", 500}, {false, "识别到多个人脸，请重试", 500}, {false, "添加面部信息失败", 500}
     */
    @Override
    public ResponseResult addFace(FaceDto faceDto) {
        log.info("[FaceServiceImpl] addFace() 进入添加面部信息方法");
        if (!StringUtils.isBlank(faceDto.getFaceFeature())) {
            FaceFeatureDto faceFeatureDto = extractFaceFeature(Base64.getDecoder().decode(faceDto.getFaceFeature()));
            if (faceFeatureDto != null) {
                log.info("[FaceServiceImpl] addFace() 成功提取到面部特征");
                if (faceFeatureDto.getFaceNumber() != 1) {
                    log.info("[FaceServiceImpl] addFace() 识别到多个人脸，请重试");
                    return new ResponseResult(false, "识别到多个人脸，请重试", StatusCode.OPERATIONERROR);
                }
                Face face = new Face();
                face.setFaceId(faceDto.getFaceId());
                face.setFaceUserId(faceDto.getFaceUserId());
                face.setFaceAge(faceFeatureDto.getFaceAge());
                face.setFaceGender(faceFeatureDto.getFaceGender());
                face.setFaceFeature(faceFeatureDto.getFeaceFeature());
                face.setFaceCreatedId(faceDto.getFaceCreatedId());
                if (faceDto.getFaceUpdatedId() != null) {
                    face.setFaceUpdatedId(faceDto.getFaceUpdatedId());
                }
                if (faceDto.getFaceRemarks() != null) {
                    face.setFaceRemarks(faceDto.getFaceRemarks());
                }
                try {
                    if (faceMapper.insertSelective(face) == 0) {
                        log.info("[FaceServiceImpl] addFace() 添加面部信息执行失败");
                        return new ResponseResult(false, "添加面部信息失败", StatusCode.OPERATIONERROR);
                    }
                    log.info("[FaceServiceImpl] addFace() 添加面部信息成功: " + face.toString());
                    return new ResponseResult(true, "添加面部信息成功", StatusCode.SUCCESS_POST_PUT_PATCH);
                } catch (DuplicateKeyException e) {
                    log.info("[FaceServiceImpl] addFace() 添加面部信息出错，违反唯一约束");
                    return new ResponseResult(false, "用户已存在面部信息", StatusCode.ERROR_INTERNAL_SERVER_ERROR);
                }
            }
            log.info("[FaceServiceImpl] addFace() 面部特征提取失败");
            return new ResponseResult(false, "没有捕捉到人脸", StatusCode.OPERATIONERROR);
        }
        log.info("[FaceServiceImpl] addFace() 面部图片Base64字符串为空");
        return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
    }

    /**
     * compareFace: 比对面部信息
     *
     * @param faceBase64Dto
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @Override
    public ResponseResult compareFace(FaceBase64Dto faceBase64Dto) throws InterruptedException, ExecutionException {
        log.info("[FaceServiceImpl] compareFace() 进入比对面部特征方法");
        if (!StringUtils.isBlank(faceBase64Dto.getFaceImageBase64())) {
            FaceFeatureDto faceFeatureDto = extractFaceFeature(Base64.getDecoder().decode(faceBase64Dto.getFaceImageBase64()));
            if (faceFeatureDto != null) {
                log.info("[FaceServiceImpl] compareFace() 成功提取到面部特征");
                if (faceFeatureDto.getFaceNumber() != 1) {
                    log.info("[FaceServiceImpl] addFace() 识别到多个人脸，请重试");
                    return new ResponseResult(false, "识别到多个人脸，请重试", StatusCode.OPERATIONERROR);
                }
                List<FaceCompareDto> allFaceCompareDtoList = new LinkedList<>();
                FaceFeature faceFeature = new FaceFeature();
                faceFeature.setFeatureData(faceFeatureDto.getFeaceFeature());
                List<Face> allFaceList = faceMapper.findAllFace();
                if (CollectionUtils.isEmpty(allFaceList)) {
                    log.info("[FaceServiceImpl] compareFace() 没有查到面部信息");
                    return new ResponseResult(false, "没有查到面部信息", StatusCode.OPERATIONERROR);
                }
                log.info("[FaceServiceImpl] compareFace() 查询所有面部信息成功，共有" + allFaceList.size() + "条面部信息");
                List<List<Face>> AllFacePartList = Lists.partition(allFaceList, 1000);
                CompletionService<List<FaceCompareDto>> completionService = new ExecutorCompletionService<>(executorService);
                for (List<Face> list : AllFacePartList) {
                    log.info("[FaceServiceImpl] compareFace() 1000个为一组进行并发比对");
                    completionService.submit(new CompareFaceTask(list, faceFeature));
                }
                for (int i = 0; i < AllFacePartList.size(); i++) {
                    List<FaceCompareDto> resultFaceCompareDtoList = completionService.take().get();
                    allFaceCompareDtoList.addAll(resultFaceCompareDtoList);
                }
                log.info("[FaceServiceImpl] compareFace() 共有" + allFaceCompareDtoList.size() + "条相似的面部信息");
                allFaceCompareDtoList.sort((h1, h2) -> h2.getSimilarValue().compareTo(h1.getSimilarValue()));
                FaceCompareDto faceCompareDto = allFaceCompareDtoList.get(0);
                log.info("[FaceServiceImpl] compareFace() 查找出最相似的面部信息: " + faceCompareDto.toString());
                return new ResponseResult(faceCompareDto, true, "面部特征比对成功", StatusCode.SUCCESS_POST_PUT_PATCH);
            }
        }
        log.info("[FaceServiceImpl] compareFace() 面部图片Base64字符串为空");
        return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
    }

    /**
     * deleteFace: 删除面部信息
     *
     * @param faceId
     * @return  成功: {true, "删除面部信息成功", 204}
     *          失败: {false, "参数为空", 400}, {false, "删除面部信息失败", 500}
     */
    @Override
    public ResponseResult deleteFace(String faceId) {
        log.info("[FaceServiceImpl] deleteFace() 进入删除面部信息方法");
        if (StringUtils.isBlank(faceId)) {
            log.info("[FaceServiceImpl] deleteFace() faceId为空，不能删除面部信息");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        int result = faceMapper.deleteByPrimaryKey(faceId);
        if (result == 0) {
            log.info("[FaceServiceImpl] deleteFace() 删除面部信息执行失败: " + faceId);
            return new ResponseResult(false, "删除面部信息失败", StatusCode.OPERATIONERROR);
        }
        log.info("[FaceServiceImpl] deleteFace() 删除面部信息成功: " + faceId);
        return new ResponseResult(true, "删除面部信息成功", StatusCode.SUCCESS_DELETE);
    }

    /**
     * updateFace: 更新面部信息
     *
     * @param faceDto
     * @return  成功: {true, "更新面部信息成功", 201}
     *          失败: {false, "参数为空", 400}, {false, "识别到多个人脸，请重试", 500}, {false, "没有捕捉到人脸", 500}
     */
    @Override
    public ResponseResult updateFace(FaceDto faceDto) {
        log.info("[FaceServiceImpl] updateFace() 进入更新面部信息方法");
        if (faceDto == null) {
            log.info("[FaceServiceImpl] updateFace() 参数为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        Face face = new Face();
        face.setFaceId(faceDto.getFaceId());
        face.setFaceUserId(faceDto.getFaceUserId());
        if (!StringUtils.isBlank(faceDto.getFaceFeature())) {
            log.info("[FaceServiceImpl] updateFace() 更新面部特征信息");
            FaceFeatureDto faceFeatureDto = extractFaceFeature(Base64.getDecoder().decode(faceDto.getFaceFeature()));
            if (faceFeatureDto != null) {
                log.info("[FaceServiceImpl] updateFace() 成功提取到面部特征");
                if (faceFeatureDto.getFaceNumber() != 1) {
                    log.info("[FaceServiceImpl] updateFace() 识别到多个人脸，请重试");
                    return new ResponseResult(false, "识别到多个人脸，请重试", StatusCode.OPERATIONERROR);
                }
                face.setFaceFeature(faceFeatureDto.getFeaceFeature());
                face.setFaceAge(faceFeatureDto.getFaceAge());
                face.setFaceGender(faceFeatureDto.getFaceGender());
                log.info("[FaceServiceImpl] updateFace() 面部特征更新成功");
            } else {
                log.info("[FaceServiceImpl] updateFace() 面部特征提取失败");
                return new ResponseResult(false, "没有捕捉到人脸", StatusCode.OPERATIONERROR);
            }
        } else {
           log.info("[FaceServiceImpl] updateFace() 不需要更新面部特征信息");
        }
        face.setFaceUpdatedId("U000000001");
        if (faceDto.getFaceRemarks() != null) {
            face.setFaceRemarks(faceDto.getFaceRemarks());
        }
        if (faceMapper.updateByPrimaryKeySelective(face) == 0) {
            log.info("[FaceServiceImpl] updateFace() 更新面部信息执行失败");
            return new ResponseResult(false, "更新面部信息失败", StatusCode.OPERATIONERROR);
        }
        log.info("[FaceServiceImpl] updateFace() 更新面部信息成功");
        return new ResponseResult(true, "更新面部信息成功", StatusCode.SUCCESS_POST_PUT_PATCH);
    }

    /**
     * queryFace: 查询面部信息
     *
     * @param faceId
     * @return  成功: {faceInfoVO, true, "查询面部信息成功", 200}
     *          失败: {false, "参数为空", 400}, {false, "查询面部信息失败", 500}
     */
    @Override
    public ResponseResult queryFace(String faceId) {
        log.info("[FaceServiceImpl] queryFace() 进入查询面部信息方法");
        if (StringUtils.isBlank(faceId)) {
            log.info("[FaceServiceImpl] queryFace() faceId为空，不能查询面部信息");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        Face face = faceMapper.selectByPrimaryKey(faceId);
        if (face == null) {
            log.info("[FaceServiceImpl] queryFace() 没有查询到此面部信息，faceId: " + faceId);
            return new ResponseResult(false, "没有查询到此面部信息", StatusCode.OPERATIONERROR);
        }
        FaceInfoVO faceInfoVO = faceToFaceInfoVO(face);
        log.info("[FaceServiceImpl] queryFace() 查询面部信息成功");
        return new ResponseResult(faceInfoVO, true, "查询面部信息成功", StatusCode.SUCCESS_GET);
    }

    /**
     * queryAllFaces: 查询所有面部信息
     *
     * @return  成功: {faceInfoVOList, true, "查询面部信息成功", 200}
     *          失败: {false, "没有查到面部信息", 500}
     */
    @Override
    public ResponseResult queryAllFaces() {
        log.info("[FaceServiceImpl] queryAllFaces() 进入查询所有面部信息方法");
        List<Face> faceList = faceMapper.findAllFace();
        if (CollectionUtils.isEmpty(faceList)) {
            log.info("[FaceServiceImpl] queryAllFaces() 没有查到面部信息");
            return new ResponseResult(false, "没有查到面部信息", StatusCode.OPERATIONERROR);
        }
        List<FaceInfoVO> faceInfoVOList = new ArrayList<>();
        for (Face face : faceList) {
            faceInfoVOList.add(faceToFaceInfoVO(face));
        }
        log.info("[FaceServiceImpl] queryAllFaces() 查询所有面部信息成功");
        return new ResponseResult(faceInfoVOList, true, "查询面部信息成功", StatusCode.SUCCESS_GET);
    }

    /**
     * faceLogin: 刷脸登陆
     *
     * @param faceBase64Dto
     * @return
     */
    @Override
    public ResponseResult faceLogin(FaceBase64Dto faceBase64Dto) {
        log.info("[FaceServiceImpl] faceLogin() 进入刷脸登陆方法");
        ResponseResult result;
        try {
            result = compareFace(faceBase64Dto);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseResult(false, "刷脸登陆失败", StatusCode.OPERATIONERROR);
        }
        if (!result.isSuccess()) {
            return result;
        }
        FaceCompareDto faceCompareDto = (FaceCompareDto) result.getData();
        String faceUserId = faceCompareDto.getFaceUserId();
        log.info("[FaceServiceImpl] faceLogin() 匹配到的用户编号为: " + faceUserId);
        ResponseResult remoteResult = smFeign.getUserInfoByUserId(faceUserId);
        if (!remoteResult.isSuccess()) {
            log.info("[FaceServiceImpl] faceLogin() 获取用户信息失败");
            return new ResponseResult(false, "获取用户信息失败", StatusCode.OPERATIONERROR);
        }
        log.info("[FaceServiceImpl] faceLogin() 刷脸登陆成功");
        return new ResponseResult(remoteResult.getData(), true, "刷脸登陆成功", StatusCode.SUCCESS_POST_PUT_PATCH);
    }

    /**
     * getFaceFeature: 获取面部特征值
     *
     * @param imageBytes
     * @return
     */
    @Override
    public FaceFeatureDto extractFaceFeature(byte[] imageBytes) {
        log.info("FaceServiceImpl] extractFaceFeature() 进入提取面部特征信息方法");
        ImageInfo imageInfo = ImageUtil.imageBytesToImageInfo(imageBytes);
        if (imageInfo != null) {
            FaceEngine faceEngine = null;
            try {
                faceEngine = extractFaceFeatureObjectPool.borrowObject();
                log.info("FaceServiceImpl] extractFaceFeature() 进行面部信息检测");
                List<FaceInfo> faceInfoList = new ArrayList<>();
                faceEngine.detectFaces(imageInfo.getImgData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList);
                if (!CollectionUtils.isEmpty(faceInfoList)) {
                    log.info("[FaceServiceImpl] extractFaceFeature() 识别到" + faceInfoList.size() + "个人脸");
                    FaceFeatureDto faceFeatureDto = new FaceFeatureDto();
                    if (faceInfoList.size() != 1) {
                        log.info("[FaceServiceImpl] extractFaceFeature() 识别出多个人脸");
                        faceFeatureDto.setFaceNumber(faceInfoList.size());
                        return faceFeatureDto;
                    }
                    log.info("FaceServiceImpl] extractFaceFeature() 进行面部信息特征值提取");
                    FaceFeature faceFeature = new FaceFeature();
                    faceEngine.extractFaceFeature(imageInfo.getImgData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList.get(0), faceFeature);
                    log.info("FaceServiceImpl] extractFaceFeature() 进行面部信息处理");
                    faceEngine.process(imageInfo.getImgData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList, FunctionConfiguration.builder().supportAge(true).supportGender(true).build());
                    List<AgeInfo> ageInfoList = new ArrayList<>();
                    faceEngine.getAge(ageInfoList);
                    List<GenderInfo> genderInfoList = new ArrayList<>();
                    faceEngine.getGender(genderInfoList);
                    faceFeatureDto.setFeaceFeature(faceFeature.getFeatureData());
                    faceFeatureDto.setFaceAge(ageInfoList.get(0).getAge());
                    faceFeatureDto.setFaceGender(genderInfoList.get(0).getGender());
                    faceFeatureDto.setFaceNumber(faceInfoList.size());
                    log.info("[FaceServiceImpl] extractFaceFeature() 提取到的面部信息: " + faceFeatureDto.toString());
                    return faceFeatureDto;
                }
            } catch (Exception e) {
                log.info("FaceServiceImpl] extractFaceFeature() 提取面部特征信息出错");
                e.printStackTrace();
                return null;
            } finally {
                if (faceEngine != null) {
                    extractFaceFeatureObjectPool.returnObject(faceEngine);
                }
            }
        }
        log.info("FaceServiceImpl] extractFaceFeature() 面部图片字节数组转为图片信息错误");
        return null;
    }

    private FaceInfoVO faceToFaceInfoVO(Face face) {
        FaceInfoVO faceInfoVO = new FaceInfoVO();
        faceInfoVO.setFaceId(face.getFaceId());
        faceInfoVO.setFaceUserId(face.getFaceUserId());
        faceInfoVO.setFaceAge(face.getFaceAge());
        faceInfoVO.setFaceGender(face.getFaceGender());
        faceInfoVO.setFaceCreatedId(face.getFaceCreatedId());
        faceInfoVO.setFaceCreatedTime(face.getFaceCreatedTime());
        faceInfoVO.setFaceUpdatedId(face.getFaceUpdatedId());
        faceInfoVO.setFaceUpdatedTime(face.getFaceUpdatedTime());
        faceInfoVO.setFaceRemarks(face.getFaceRemarks());
        return faceInfoVO;
    }

    private class CompareFaceTask implements Callable<List<FaceCompareDto>> {

        private List<Face> faceList;
        private FaceFeature targetFaceFeature;

        CompareFaceTask(List<Face> faceList, FaceFeature targetFaceFeature) {
            this.faceList = faceList;
            this.targetFaceFeature = targetFaceFeature;
        }

        @Override
        public List<FaceCompareDto> call() {
            log.info("[CompareFaceTask] call() 进入并发面部特征比对方法");
            FaceEngine faceEngine = null;
            List<FaceCompareDto> resultFaceCompareDtoList = new LinkedList<>();//识别到的人脸列表
            try {
                faceEngine = compareFaceFeatureObjectPool.borrowObject();
                for (Face face : faceList) {
                    FaceFeature sourceFaceFeature = new FaceFeature();
                    sourceFaceFeature.setFeatureData(face.getFaceFeature());
                    FaceSimilar faceSimilar = new FaceSimilar();
                    faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature, faceSimilar);
                    float similarValue = faceSimilar.getScore();
                    if (similarValue > 0.8) {
                        FaceCompareDto faceCompareDto = new FaceCompareDto();
                        faceCompareDto.setFaceId(face.getFaceId());
                        faceCompareDto.setFaceUserId(face.getFaceUserId());
                        faceCompareDto.setSimilarValue(similarValue);
                        resultFaceCompareDtoList.add(faceCompareDto);
                    }
                }
            } catch (Exception e) {
                log.error("", e);
            } finally {
                if (faceEngine != null) {
                    compareFaceFeatureObjectPool.returnObject(faceEngine);
                }
            }
            log.info("[CompareFaceTask] call() 当前组中共有" + resultFaceCompareDtoList.size() + "条相似的面部信息");
            return resultFaceCompareDtoList;
        }
    }
}
