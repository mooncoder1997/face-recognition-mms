/**
 * Project Name: mms-provider-face
 * File Name: FaceService.java
 * Package Name: com.why.dev.mms.face.service
 * Date: 2018/12/23 8:40 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.service;

import com.why.dev.mms.face.dto.*;

import java.util.concurrent.ExecutionException;

/**
 * ClassName: FaceService
 * Description: 面部信息业务逻辑接口
 * Date: 2018/12/23 8:40 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public interface FaceService {
    ResponseResult addFace(FaceDto faceDto);

    ResponseResult compareFace(FaceBase64Dto faceBase64Dto) throws InterruptedException, ExecutionException;

    ResponseResult deleteFace(String faceId);

    ResponseResult updateFace(FaceDto faceDto);

    ResponseResult queryFace(String faceId);

    ResponseResult queryAllFaces();

    FaceFeatureDto extractFaceFeature(byte[] imageBytes);
}
