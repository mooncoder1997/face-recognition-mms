/**
 * Project Name: mms-provider-sm
 * File Name: RoleMapper.java
 * Package Name: com.why.dev.mms.sm.dao
 * Date: 2018/01/02 10:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.dao;

import com.why.dev.mms.sm.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: RoleMapper
 * Description: 角色信息映射接口
 * Date: 2018/01/02 10:47 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Mapper
public interface RoleMapper {

    int insertSelective(Role record);

    int deleteByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role record);

    Role selectByPrimaryKey(String roleId);

    String selectRoleNameByPrimiaryKey(String roleId);

    List<Role> findAllRole();
}