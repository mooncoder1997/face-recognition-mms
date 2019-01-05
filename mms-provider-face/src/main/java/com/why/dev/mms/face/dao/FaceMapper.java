/**
 * Project Name: mms-provider-face
 * File Name: FaceMapper.java
 * Package Name: com.why.dev.mms.face.dao
 * Date: 2018/12/30 12:20 AM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.dao;

import com.why.dev.mms.face.pojo.Face;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: FaceMapper
 * Description: 面部信息映射接口
 * Date: 2018/12/23 8:35 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Mapper
public interface FaceMapper {

    int insertSelective(Face face);

    int deleteByPrimaryKey(String faceId);

    int updateByPrimaryKeySelective(Face record);

    Face selectByPrimaryKey(String faceId);

    List<Face> findAllFace();
}