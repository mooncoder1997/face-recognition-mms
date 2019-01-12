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

    private String faceUserNickname;

    private String faceUserName;

    private Integer faceAge;

    private Integer faceGender;

    private String faceCreatedNickname;

    private Date faceCreatedTime;

    private String faceUpdatedNickname;

    private Date faceUpdatedTime;

    private String faceRemarks;

    public FaceInfoVO() {
    }

    public FaceInfoVO(String faceId, String faceUserNickname, String faceUserName, Integer faceAge, Integer faceGender, String faceCreatedNickname, Date faceCreatedTime, String faceUpdatedNickname, Date faceUpdatedTime, String faceRemarks) {
        this.faceId = faceId;
        this.faceUserNickname = faceUserNickname;
        this.faceUserName = faceUserName;
        this.faceAge = faceAge;
        this.faceGender = faceGender;
        this.faceCreatedNickname = faceCreatedNickname;
        this.faceCreatedTime = faceCreatedTime;
        this.faceUpdatedNickname = faceUpdatedNickname;
        this.faceUpdatedTime = faceUpdatedTime;
        this.faceRemarks = faceRemarks;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
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
        return "FaceInfoVO{" +
                "faceId='" + faceId + '\'' +
                ", faceUserNickname='" + faceUserNickname + '\'' +
                ", faceUserName='" + faceUserName + '\'' +
                ", faceAge=" + faceAge +
                ", faceGender=" + faceGender +
                ", faceCreatedNickname='" + faceCreatedNickname + '\'' +
                ", faceCreatedTime=" + faceCreatedTime +
                ", faceUpdatedNickname='" + faceUpdatedNickname + '\'' +
                ", faceUpdatedTime=" + faceUpdatedTime +
                ", faceRemarks='" + faceRemarks + '\'' +
                '}';
    }
}
