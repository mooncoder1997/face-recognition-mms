/**
 * Project Name: mms-provider-face
 * File Name: ImageUtil.java
 * Package Name: com.why.dev.mms.face.util
 * Date: 2018/12/24 8:13 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.util;

import com.why.dev.mms.face.dto.ImageInfo;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: ImageUtil
 * Description: 图片工具类
 * Date: 2018/12/24 8:13 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
public class ImageUtil {

    /**
     * 将存放图片的字节数组转换成ImageInfo对象
     * 1. 图片的宽度和高度处理
     * 2. 获取RGB值
     *
     * @param imageBytes
     * @return
     */
    public static ImageInfo imageBytesToImageInfo(byte[] imageBytes) {
        if (imageBytes == null) {
            log.info("[ImageUtil] imageBytesToImageInfo 存放图片的byte[]为空");
            return null;
        }
        InputStream inputStream = new ByteArrayInputStream(imageBytes);
        ImageInfo imageInfo = new ImageInfo();
        try {
            BufferedImage inBufferedImage = ImageIO.read(inputStream);
            imageInfo.setWidth(inBufferedImage.getWidth() & (~3));
            imageInfo.setHeight(inBufferedImage.getHeight() & (~3));
            BufferedImage cacheBufferedImage = new BufferedImage(imageInfo.getWidth(), imageInfo.getHeight(), inBufferedImage.getType());
            cacheBufferedImage.setRGB(0, 0, imageInfo.getWidth(), imageInfo.getHeight(), inBufferedImage.getRGB(0, 0, imageInfo.getWidth(), imageInfo.getHeight(), null, 0, imageInfo.getWidth()), 0, imageInfo.getWidth());
            if (cacheBufferedImage.getType() == BufferedImage.TYPE_3BYTE_BGR) {
                imageInfo.setImgData(((DataBufferByte) (cacheBufferedImage.getRaster().getDataBuffer())).getData());
            } else {
                BufferedImage outBufferedImage = new BufferedImage(imageInfo.getWidth(), imageInfo.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
                ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_LINEAR_RGB);
                ColorConvertOp colorConvertOp = new ColorConvertOp(cs, outBufferedImage.createGraphics().getRenderingHints());
                colorConvertOp.filter(cacheBufferedImage, outBufferedImage);
                imageInfo.setImgData(((DataBufferByte) (outBufferedImage.getRaster().getDataBuffer())).getData());
            }
            return imageInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
