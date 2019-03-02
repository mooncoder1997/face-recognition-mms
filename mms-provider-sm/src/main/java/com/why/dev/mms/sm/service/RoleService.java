/**
 * Project Name: face-recognition-mms
 * File Name: RoleServiceImpl
 * Package Name: com.why.dev.mms.sm.service.impl
 * Date: 2019-01-16 22:10
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.service;

import com.why.dev.mms.sm.common.StatusCode;
import com.why.dev.mms.sm.dao.RoleMapper;
import com.why.dev.mms.sm.dto.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: RoleServiceImpl
 * Description: 角色信息业务逻辑实现
 * Date: 2019-01-16 22:10
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;

    public ResponseResult queryAllRoles() {
        log.info("[RoleService] queryAllRoles() 进入查询角色方法");
        List<String> roleList = roleMapper.findAllRole();
        if (CollectionUtils.isEmpty(roleList)) {
            log.info("[RoleService] queryAllRoles() 没有查到角色");
            return new ResponseResult(false, "没有查到角色", StatusCode.OPERATIONERROR);
        }
        log.info("[RoleService] queryAllRoles() 查询所有角色成功，共查到" + roleList.size() + "个角色");
        return new ResponseResult(roleList, true, "查询角色成功", StatusCode.SUCCESS_GET);
    }
}
