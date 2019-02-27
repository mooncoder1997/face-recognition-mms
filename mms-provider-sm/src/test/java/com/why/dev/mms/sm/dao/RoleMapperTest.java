package com.why.dev.mms.sm.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

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
    public void testFindAllRole() {
        List<String> roleList = roleMapper.findAllRole();
        log.info(roleList.toString());
    }
}