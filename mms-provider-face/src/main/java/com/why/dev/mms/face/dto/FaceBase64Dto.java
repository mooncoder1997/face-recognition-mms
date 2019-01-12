/**
 * Project Name: mms-provider-face
 * File Name: FaceBase64Dto.java
 * Package Name: com.why.dev.mms.face.dto
 * Date: 2019/1/2 8:18 PM
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.dto;

/**
 * ClassName: FaceBase64Dto
 * Description: 封装前端传入的面部信息Base64字符串
 * Date: 2019/1/2 8:18 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class FaceBase64Dto {

    private String faceImageBase64;

    public FaceBase64Dto() {
    }

    public FaceBase64Dto(String faceImageBase64) {
        this.faceImageBase64 = faceImageBase64;
    }

    public String getFaceImageBase64() {
        return faceImageBase64;
    }

    public void setFaceImageBase64(String faceImageBase64) {
        this.faceImageBase64 = faceImageBase64;
    }

    @Override
    public String toString() {
        return "FaceBase64Dto{" +
                "faceImageBase64='" + faceImageBase64 + '\'' +
                '}';
    }
}
