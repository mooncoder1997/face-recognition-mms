package com.why.dev.mms.face.dao;

import com.why.dev.mms.face.pojo.Face;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Project Name: mms-provider-face
 * File Name: FaceMapperTest.java
 * Package Name: com.why.dev.mms.face.dao
 * Date: 2018/12/29 10:17 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class FaceMapperTest {

    @Resource
    private FaceMapper faceMapper;

    @Test
    public void testInsertSelective() {
        Face face = new Face();
        face.setFaceId(UUID.randomUUID().toString().replace("-",""));
        face.setFaceUserId(UUID.randomUUID().toString().replace("-",""));
        int result = faceMapper.insertSelective(face);
        Assert.assertEquals(1, result);
        log.info("[FaceMapperTest] testInsertSelective 成功插入了" + result + "条面部信息");
    }

    @Test
    public void testDeleteByPrimaryKey() {
        int result = faceMapper.deleteByPrimaryKey("6284e4e1a5c546f9bdeeb02b2c290997");
        Assert.assertEquals(1, result);
        log.info("[FaceMapperTest] testDeleteByPrimaryKey 成功删除了" + result + "条面部信息");
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void testSelectByPrimaryKey() {
        Face face = faceMapper.selectByPrimaryKey("6284e4e1a5c546f9bdeeb02b2c290997");
        if (face == null) {
            log.info("[FaceMapperTest] testSelectByPrimaryKey 查询面部信息失败" );
        }
        Assert.assertNotNull(face);
        log.info("[FaceMapperTest] testSelectByPrimaryKey 成功查到1条面部信息: " + face.toString());
    }

    @Test
    public void testFindAllFace() {
        List<Face> faceList = faceMapper.findAllFace();
        if (faceList == null) {
            log.info("[FaceMapperTest] testFindAllFace 查询面部信息失败" );
        }
        Assert.assertNotNull(faceList);
        log.info("[FaceMapperTest] testFindAllFace 成功查到" + faceList.size() + "条面部信息");
    }
}