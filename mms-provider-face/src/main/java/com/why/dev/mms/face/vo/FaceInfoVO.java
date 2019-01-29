/**
 * Project Name: mms-provider-face
 * File Name: FaceInfoVO.java
 * Package Name: com.why.dev.mms.face.vo
 * Date: 2018/12/31 12:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.vo;

import java.util.Date;

/**
 * ClassName: FaceInfoVO
 * Description: 封装显示在前端的面部信息
 * Date: 2018/12/31 12:47 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class FaceInfoVO {

    private String faceId;

    private String faceUserId;

    private Integer faceAge;

    private Integer faceGender;

    private String faceCreatedId;

    private Date faceCreatedTime;

    private String faceUpdatedId;

    private Date faceUpdatedTime;

    private String faceRemarks;

    public FaceInfoVO() {
    }

    public FaceInfoVO(String faceId, String faceUserId, Integer faceAge, Integer faceGender, String faceCreatedId, Date faceCreatedTime, String faceUpdatedId, Date faceUpdatedTime, String faceRemarks) {
        this.faceId = faceId;
        this.faceUserId = faceUserId;
        this.faceAge = faceAge;
        this.faceGender = faceGender;
        this.faceCreatedId = faceCreatedId;
        this.faceCreatedTime = faceCreatedTime;
        this.faceUpdatedId = faceUpdatedId;
        this.faceUpdatedTime = faceUpdatedTime;
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

    public Integer getFaceAge() {
        return faceAge;
    }

    public void setFaceAge(Integer faceAge) {
        this.faceAge = faceAge;
    }

    public Integer getFaceGender() {
        return faceGender;
    }

    public void setFaceGender(Integer faceGender) {
        this.faceGender = faceGender;
    }

    public String getFaceCreatedId() {
        return faceCreatedId;
    }

    public void setFaceCreatedId(String faceCreatedId) {
        this.faceCreatedId = faceCreatedId;
    }

    public Date getFaceCreatedTime() {
        return faceCreatedTime;
    }

    public void setFaceCreatedTime(Date faceCreatedTime) {
        this.faceCreatedTime = faceCreatedTime;
    }

    public String getFaceUpdatedId() {
        return faceUpdatedId;
    }

    public void setFaceUpdatedId(String faceUpdatedId) {
        this.faceUpdatedId = faceUpdatedId;
    }

    public Date getFaceUpdatedTime() {
        return faceUpdatedTime;
    }

    public void setFaceUpdatedTime(Date faceUpdatedTime) {
        this.faceUpdatedTime = faceUpdatedTime;
    }

    public String getFaceRemarks() {
        return faceRemarks;
    }

    public void setFaceRemarks(String faceRemarks) {
        this.faceRemarks = faceRemarks;
    }

    @Override
    public String toString() {
        return "FaceInfoVO{" +
                "faceId='" + faceId + '\'' +
                ", faceUserId='" + faceUserId + '\'' +
                ", faceAge=" + faceAge +
                ", faceGender=" + faceGender +
                ", faceCreatedId='" + faceCreatedId + '\'' +
                ", faceCreatedTime=" + faceCreatedTime +
                ", faceUpdatedId='" + faceUpdatedId + '\'' +
                ", faceUpdatedTime=" + faceUpdatedTime +
                ", faceRemarks='" + faceRemarks + '\'' +
                '}';
    }
}
