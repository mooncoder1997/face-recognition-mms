package com.why.dev.mms.sm.dao;

import com.why.dev.mms.sm.pojo.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Project Name: face-recognition-mms
 * File Name: RoleMapperTest
 * Package Name: com.why.dev.mms.sm.dao
 * Date: 2019/1/4 8:18 PM
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {

    @Resource
    private RoleMapper roleMapper;

    @Test
    public void testInsertSelective() {
        Role role = new Role();
        role.setRoleId(UUID.randomUUID().toString().replace("-",""));
        role.setRoleName("超级管理员");
        role.setRoleCreatedNickname("Wang, Haoyue");
        int result = roleMapper.insertSelective(role);
        Assert.assertEquals(1, result);
        log.info("[RoleMapperTest] testInsertSelective 成功插入了" + result + "条角色信息");
    }

    @Test
    public void testDeleteByPrimaryKey() {
        int result = roleMapper.deleteByPrimaryKey("R0000000000000000000000000000001");
        Assert.assertEquals(1, result);
        log.info("[RoleMapperTest] testDeleteByPrimaryKey 成功删除了" + result + "条角色信息");
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
    }

    @Test
    public void testSelectByPrimaryKey() {
        Role role = roleMapper.selectByPrimaryKey("R0000000000000000000000000000001");
        if (role == null) {
            log.info("[RoleMapperTest] testSelectByPrimaryKey 查询角色信息失败");
        }
        Assert.assertNotNull(role);
        log.info("[RoleMapperTest] testSelectByPrimaryKey 成功查到1条角色信息: " + role.toString());
    }

    @Test
    public void testSelectRoleNameByPrimiaryKey() {
        String roleName = roleMapper.selectRoleNameByPrimiaryKey("R0000000000000000000000000000001");
        if (roleName == null) {
            log.info("[RoleMapperTest] testSelectRoleNameByPrimiaryKey 查询角色名称失败");
        }
        Assert.assertNotNull(roleName);
        log.info("[RoleMapperTest] testSelectRoleNameByPrimiaryKey 成功查到角色名称: " + roleName);
    }

    @Test
    public void testFindAllRole() {
    }
}