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

    private String faceUserNickname;

    private String faceUserName;

    private String faceFeature;

    private String faceCreatedNickname;

    private String faceUpdatedNickname;

    private String faceRemarks;

    public FaceDto() {
    }

    public FaceDto(String faceId, String faceUserId, String faceUserNickname, String faceUserName, String faceFeature, String faceCreatedNickname, String faceUpdatedNickname, String faceRemarks) {
        this.faceId = faceId;
        this.faceUserId = faceUserId;
        this.faceUserNickname = faceUserNickname;
        this.faceUserName = faceUserName;
        this.faceFeature = faceFeature;
        this.faceCreatedNickname = faceCreatedNickname;
        this.faceUpdatedNickname = faceUpdatedNickname;
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

    public String getFaceUserNickname() {
        return faceUserNickname;
    }

    public void setFaceUserNickname(String faceUserNickname) {
        this.faceUserNickname = faceUserNickname;
    }

    public String getFaceUserName() {
        return faceUserName;
    }

    public void setFaceUserName(String faceUserName) {
        this.faceUserName = faceUserName;
    }

    public String getFaceFeature() {
        return faceFeature;
    }

    public void setFaceFeature(String faceFeature) {
        this.faceFeature = faceFeature;
    }

    public String getFaceCreatedNickname() {
        return faceCreatedNickname;
    }

    public void setFaceCreatedNickname(String faceCreatedNickname) {
        this.faceCreatedNickname = faceCreatedNickname;
    }

    public String getFaceUpdatedNickname() {
        return faceUpdatedNickname;
    }

    public void setFaceUpdatedNickname(String faceUpdatedNickname) {
        this.faceUpdatedNickname = faceUpdatedNickname;
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
                ", faceUserNickname='" + faceUserNickname + '\'' +
                ", faceUserName='" + faceUserName + '\'' +
                ", faceCreatedNickname='" + faceCreatedNickname + '\'' +
                ", faceUpdatedNickname='" + faceUpdatedNickname + '\'' +
                ", faceRemarks='" + faceRemarks + '\'' +
                '}';
    }
}
