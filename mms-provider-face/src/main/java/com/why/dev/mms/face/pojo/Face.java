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

    private String faceUserNickname;

    private String faceUserName;

    private Integer faceAge;

    private Integer faceGender;

    private byte[] faceFeature;

    private Integer faceIsdel;

    private String faceCreatedNickname;

    private Date faceCreatedTime;

    private String faceUpdatedNickname;

    private Date faceUpdatedTime;

    private String faceRemarks;

    public String getFaceId() {
        return faceId;
    }

    public Face() {
    }

    public Face(String faceId, String faceUserId, String faceUserNickname, String faceUserName, Integer faceAge, Integer faceGender, byte[] faceFeature, Integer faceIsdel, String faceCreatedNickname, Date faceCreatedTime, String faceUpdatedNickname, Date faceUpdatedTime, String faceRemarks) {
        this.faceId = faceId;
        this.faceUserId = faceUserId;
        this.faceUserNickname = faceUserNickname;
        this.faceUserName = faceUserName;
        this.faceAge = faceAge;
        this.faceGender = faceGender;
        this.faceFeature = faceFeature;
        this.faceIsdel = faceIsdel;
        this.faceCreatedNickname = faceCreatedNickname;
        this.faceCreatedTime = faceCreatedTime;
        this.faceUpdatedNickname = faceUpdatedNickname;
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

    public String getFaceCreatedNickname() {
        return faceCreatedNickname;
    }

    public void setFaceCreatedNickname(String faceCreatedNickname) {
        this.faceCreatedNickname = faceCreatedNickname;
    }

    public Date getFaceCreatedTime() {
        return faceCreatedTime;
    }

    public void setFaceCreatedTime(Date faceCreatedTime) {
        this.faceCreatedTime = faceCreatedTime;
    }

    public String getFaceUpdatedNickname() {
        return faceUpdatedNickname;
    }

    public void setFaceUpdatedNickname(String faceUpdatedNickname) {
        this.faceUpdatedNickname = faceUpdatedNickname;
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
                ", faceUserNickname='" + faceUserNickname + '\'' +
                ", faceUserName='" + faceUserName + '\'' +
                ", faceAge=" + faceAge +
                ", faceGender=" + faceGender +
                ", faceIsdel=" + faceIsdel +
                ", faceCreatedNickname='" + faceCreatedNickname + '\'' +
                ", faceCreatedTime=" + faceCreatedTime +
                ", faceUpdatedNickname='" + faceUpdatedNickname + '\'' +
                ", faceUpdatedTime=" + faceUpdatedTime +
                ", faceRemarks='" + faceRemarks + '\'' +
                '}';
    }
}