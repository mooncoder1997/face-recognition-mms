/**
 * Project Name: mms-provider-face
 * File Name: FaceCompareDto.java
 * Package Name: com.why.dev.mms.face.dto
 * Date: 2019/1/2 12:37 AM
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.dto;

/**
 * ClassName: FaceCompareDto
 * Description: 封装面部特征比对时相似对象
 * Date: 2019/1/2 12:37 AM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class FaceCompareDto {
    private String faceId;

    private String faceUserId;

    private Float similarValue;

    public FaceCompareDto() {
    }

    public FaceCompareDto(String faceId, String faceUserId, Float similarValue) {
        this.faceId = faceId;
        this.faceUserId = faceUserId;
        this.similarValue = similarValue;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public String getFaceUserId() {
        return faceUserId;
    }

    public void setFaceUserId(String faceUserId) {
        this.faceUserId = faceUserId;
    }

    public Float getSimilarValue() {
        return similarValue;
    }

    public void setSimilarValue(Float similarValue) {
        this.similarValue = similarValue;
    }

    @Override
    public String toString() {
        return "FaceCompareDto{" +
                "faceId='" + faceId + '\'' +
                ", faceUserId='" + faceUserId + '\'' +
                ", similarValue=" + similarValue +
                '}';
    }
}
