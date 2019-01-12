/**
 * Project Name: mms-provider-face
 * File Name: ImageInfo.java
 * Package Name: com.why.dev.mms.face.dto
 * Date: 2018/12/24 7:53 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.dto;

/**
 * ClassName: ImageInfo
 * Description: 封装图片信息
 * Date: 2018/12/24 7:53 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class ImageInfo {

    private byte[] imgData;
    private int height;
    private int width;

    public ImageInfo() {
    }

    public ImageInfo(byte[] imgDate, int height, int width) {
        this.imgData = imgDate;
        this.height = height;
        this.width = width;
    }

    public byte[] getImgData() {
        return imgData;
    }

    public void setImgData(byte[] imgData) {
        this.imgData = imgData;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
