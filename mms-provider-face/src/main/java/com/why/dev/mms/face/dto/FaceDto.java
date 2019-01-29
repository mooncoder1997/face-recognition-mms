/**
 * Project Name: mms-provider-face
 * File Name: FaceDto.java
 * Package Name: com.why.dev.mms.face.dto
 * Date: 2018/12/24 12:16 AM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.dto;

/**
 * ClassName: FaceDto
 * Description: 封装前端传入的面部信息
 * Date: 2018/12/24 12:16 AM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class FaceDto {

    private String faceId;

    private String faceUserId;

    private String faceFeature;

    private String faceCreatedId;

    private String faceUpdatedId;

    private String faceRemarks;

    public FaceDto() {
    }

    public FaceDto(String faceId, String faceUserId, String faceFeature, String faceCreatedId, String faceUpdatedId, String faceRemarks) {
        this.faceId = faceId;
        this.faceUserId = faceUserId;
        this.faceFeature = faceFeature;
        this.faceCreatedId = faceCreatedId;
        this.faceUpdatedId = faceUpdatedId;
        this.faceRemarks = faceRemarks;
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

    public String getFaceFeature() {
        return faceFeature;
    }

    public void setFaceFeature(String faceFeature) {
        this.faceFeature = faceFeature;
    }

    public String getFaceCreatedId() {
        return faceCreatedId;
    }

    public void setFaceCreatedId(String faceCreatedId) {
        this.faceCreatedId = faceCreatedId;
    }

    public String getFaceUpdatedId() {
        return faceUpdatedId;
    }

    public void setFaceUpdatedId(String faceUpdatedId) {
        this.faceUpdatedId = faceUpdatedId;
    }

    public String getFaceRemarks() {
        return faceRemarks;
    }

    public void setFaceRemarks(String faceRemarks) {
        this.faceRemarks = faceRemarks;
    }

    @Override
    public String toString() {
        return "FaceDto{" +
                "faceId='" + faceId + '\'' +
                ", faceUserId='" + faceUserId + '\'' +
                ", faceCreatedId='" + faceCreatedId + '\'' +
                ", faceUpdatedId='" + faceUpdatedId + '\'' +
                ", faceRemarks='" + faceRemarks + '\'' +
                '}';
    }
}
