/**
 * Project Name: mms-provider-face
 * File Name: FaceController.java
 * Package Name: com.why.dev.mms.face.controller
 * Date: 2018/12/23 8:35 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.controller;

import com.why.dev.mms.face.dto.FaceBase64Dto;
import com.why.dev.mms.face.dto.FaceDto;
import com.why.dev.mms.face.dto.ResponseResult;
import com.why.dev.mms.face.service.FaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * ClassName: FaceController
 * Description: 面部信息处理Controller
 * Date: 2018/12/23 8:35 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
@RestController
@RequestMapping("/v1/face/")
@Api(value = "FaceController", description = "Face module API")
public class FaceController {

    @Autowired
    FaceService faceService;

    /**
     * addFace: 插入一条面部信息
     *
     * @param faceDto
     *
     * @return
     */
    @ApiOperation(value = "addFace", notes = "Use this API to add a new face.")
    @RequestMapping(value = "face", method = RequestMethod.POST)
    public ResponseResult addFace(@RequestBody FaceDto faceDto) {
        log.info("[FaceController] addFace() 进入添加面部信息方法");
        return faceService.addFace(faceDto);
    }

    /**
     * compareFace: 比对面部特征
     *
     * @param faceBase64Dto
     * @return
     */
    @RequestMapping(value = "compare", method = RequestMethod.POST)
    public ResponseResult compareFace(@RequestBody FaceBase64Dto faceBase64Dto) throws ExecutionException, InterruptedException {
        log.info("[FaceController] compareFace() 进入比对面部特征方法");
        return faceService.compareFace(faceBase64Dto);
    }

    /**
     * deleteFace: 删除一条面部信息
     *
     * @param faceId
     * @return
     */
    @ApiOperation(value = "deleteFace", notes = "传入面部信息编号faceId，删除该用户的人脸信息.")
    @ApiImplicitParam(paramType = "path", name = "用户名", value = "userName", required = true, dataType = "String")
    @RequestMapping(value = "face/{faceId}", method = RequestMethod.DELETE)
    public ResponseResult deleteFace(@PathVariable("faceId") String faceId) {
        log.info("[FaceController] deleteFace() 进入删除面部信息方法");
        return faceService.deleteFace(faceId);
    }

    /**
     * updateFace: 更新面部信息
     *
     * @param faceDto
     * @return
     */
    @ApiOperation(value = "updateFace", notes = "Use this API to update a face by userName.")
    @RequestMapping(value = "face", method = RequestMethod.PUT)
    public ResponseResult updateFace(@RequestBody FaceDto faceDto) {
        log.info("[FaceController] updateFace() 进入更新面部信息方法");
        return faceService.updateFace(faceDto);
    }

    /**
     * queryOne: 查询一条面部信息
     *
     * @param faceId
     * @return
     */
    @ApiOperation(value = "queryOne", notes = "传入面部信息编号faceId，查询")
    @RequestMapping(value = "face/{faceId}", method = RequestMethod.GET)
    public ResponseResult queryOne(@PathVariable("faceId") String faceId) {
        log.info("[FaceController] queryOne() 进入查询面部信息方法");
        return faceService.queryFace(faceId);
    }

    /**
     * queryAll: 查询所有面部信息
     *
     * @return
     */
    @RequestMapping(value = "face", method = RequestMethod.GET)
    public ResponseResult queryAll() {
        log.info("[FaceController] queryAll() 进入查询所有面部信息方法");
        return faceService.queryAllFaces();
    }
}
