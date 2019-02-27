package com.why.dev.mms.sm.dao;

import com.why.dev.mms.sm.pojo.User;
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
 * Project Name: mms-provider-sm
 * File Name: UserMapperTest.java
 * Package Name: com.why.dev.mms.sm.dao
 * Date: 2019/1/2 11:03 PM
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsertSelective() {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString().replace("-",""));
        user.setUserName("测试1");
        user.setUserPassword("123456");
        user.setUserGender("男");
        user.setUserEmail("Ce, Shi1@qq.com");
        user.setUserMobile("10000000001");
        user.setUserRoleName("user");
        user.setUserFaceId("F0000000000000000000000000000001");
        int result = userMapper.insertSelective(user);
        Assert.assertEquals(1, result);
        log.info("[UserMapperTest] testInsertSelective 成功插入了" + result + "条用户信息");
    }

    @Test
    public void testDeleteByPrimaryKey() {
        int result = userMapper.deleteByPrimaryKey("5226fad220564e4d8c1990d5f1a03fc2");
        Assert.assertEquals(1, result);
        log.info("[UserMapperTest] testDeleteByPrimaryKey 成功删除了" + result + "条用户信息");
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        User user = new User();
        user.setUserId("662bf5cf371243a3b4eb35a9681985ae");
        user.setUserGender("女");
        int result = userMapper.updateByPrimaryKeySelective(user);
        Assert.assertEquals(1, result);
        log.info("[UserMapperTest] testInsertSelective 成功更新了" + result + "条用户信息");
    }

    @Test
    public void testSelectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey("662bf5cf371243a3b4eb35a9681985ae");
        if (user == null) {
            log.info("[UserMapperTest] testSelectByPrimaryKey 查询用户信息失败" );
        }
        Assert.assertNotNull(user);
        log.info("[UserMapperTest] testSelectByPrimaryKey 成功查到1条用户信息: " + user.toString());
    }

    @Test
    public void testFindAllUser() {
        List<User> userList = userMapper.findAllUser();
        if (userList == null) {
            log.info("[UserMapperTest] testFindAllUser 查询用户信息失败" );
        }
        Assert.assertNotNull(userList);
        log.info("[UserMapperTest] testFindAllUser 成功查到" + userList.size() + "条用户信息");
    }
}