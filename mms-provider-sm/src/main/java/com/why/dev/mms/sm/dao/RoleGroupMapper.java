/**
 * Project Name: mms-provider-sm
 * File Name: RoleGroupMapper.java
 * Package Name: com.why.dev.mms.sm.dao
 * Date: 2018/01/02 10:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.dao;

import com.why.dev.mms.sm.pojo.RoleGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleGroupMapper {

    int insertSelective(RoleGroup record);

    int deleteByPrimaryKey(String roleGroupId);

    int updateByPrimaryKeySelective(RoleGroup record);

    RoleGroup selectByPrimaryKey(String roleGroupId);
}