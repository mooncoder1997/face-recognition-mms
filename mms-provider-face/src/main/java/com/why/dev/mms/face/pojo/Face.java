/**
 * Project Name: mms-provider-face
 * File Name: Face.java
 * Package Name: com.why.dev.mms.face.pojo
 * Date: 2018/12/30 12:20 AM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.pojo;

import java.util.Date;

/**
 * ClassName: Face
 * Description: 数据库FACE表实体类
 * Date: 2018/12/30 12:20 AM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class Face {
    private String faceId;

    private String faceUserId;

    private Integer faceAge;

    private Integer faceGender;

    private byte[] faceFeature;

    private Integer faceIsdel;

    private String faceCreatedId;

    private Date faceCreatedTime;

    private String faceUpdatedId;

    private Date faceUpdatedTime;

    private String faceRemarks;

    public String getFaceId() {
        return faceId;
    }

    public Face() {
    }

    public Face(String faceId, String faceUserId, Integer faceAge, Integer faceGender, byte[] faceFeature, Integer faceIsdel, String faceCreatedId, Date faceCreatedTime, String faceUpdatedId, Date faceUpdatedTime, String faceRemarks) {
        this.faceId = faceId;
        this.faceUserId = faceUserId;
        this.faceAge = faceAge;
        this.faceGender = faceGender;
        this.faceFeature = faceFeature;
        this.faceIsdel = faceIsdel;
        this.faceCreatedId = faceCreatedId;
        this.faceCreatedTime = faceCreatedTime;
        this.faceUpdatedId = faceUpdatedId;
        this.faceUpdatedTime = faceUpdatedTime;
        this.faceRemarks = faceRemarks;
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

    public byte[] getFaceFeature() {
        return faceFeature;
    }

    public void setFaceFeature(byte[] faceFeature) {
        this.faceFeature = faceFeature;
    }

    public Integer getFaceIsdel() {
        return faceIsdel;
    }

    public void setFaceIsdel(Integer faceIsdel) {
        this.faceIsdel = faceIsdel;
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
        return "Face{" +
                "faceId='" + faceId + '\'' +
                ", faceUserId='" + faceUserId + '\'' +
                ", faceAge=" + faceAge +
                ", faceGender=" + faceGender +
                ", faceIsdel=" + faceIsdel +
                ", faceCreatedId='" + faceCreatedId + '\'' +
                ", faceCreatedTime=" + faceCreatedTime +
                ", faceUpdatedId='" + faceUpdatedId + '\'' +
                ", faceUpdatedTime=" + faceUpdatedTime +
                ", faceRemarks='" + faceRemarks + '\'' +
                '}';
    }
}