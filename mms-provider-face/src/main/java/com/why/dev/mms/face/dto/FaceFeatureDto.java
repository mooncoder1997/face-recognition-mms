/**
 * Project Name: mms-provider-face
 * File Name: FaceFeatureDto.java
 * Package Name: com.why.dev.mms.face.dto
 * Date: 2018/12/30 12:54 AM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.dto;

/**
 * ClassName: FaceFeatureDto
 * Description: 封装提取到的面部特征信息
 * Date: 2018/12/30 12:54 AM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class FaceFeatureDto {

    private byte[] feaceFeature;

    private Integer faceAge;

    private Integer faceGender;

    private Integer faceNumber;

    public FaceFeatureDto() {
    }

    public FaceFeatureDto(byte[] feaceFeature, Integer faceAge, Integer faceGender, Integer faceNumber) {
        this.feaceFeature = feaceFeature;
        this.faceAge = faceAge;
        this.faceGender = faceGender;
        this.faceNumber = faceNumber;
    }

    public byte[] getFeaceFeature() {
        return feaceFeature;
    }

    public void setFeaceFeature(byte[] feaceFeature) {
        this.feaceFeature = feaceFeature;
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

    public Integer getFaceNumber() {
        return faceNumber;
    }

    public void setFaceNumber(Integer faceNumber) {
        this.faceNumber = faceNumber;
    }

    @Override
    public String toString() {
        return "FaceFeatureDto{" +
                "faceAge=" + faceAge +
                ", faceGender=" + faceGender +
                ", faceNumber=" + faceNumber +
                '}';
    }
}
