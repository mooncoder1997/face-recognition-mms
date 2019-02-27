/**
 * Project Name: mms-provider-sm
 * File Name: RoleController.java
 * Package Name: com.why.dev.mms.sm.controller
 * Date: 2018/12/31 10:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.controller;

import com.why.dev.mms.sm.dto.ResponseResult;
import com.why.dev.mms.sm.service.RoleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: RoleController
 * Description: 角色信息处理Controller
 * Date: 2018/12/31 10:47 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
@RestController
@RequestMapping("/v1/role/")
@Api(value = "角色Controller", description = "系统管理服务 - 角色模块API")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResponseResult queryAll() {
        log.info("[RoleController] queryAll() 进入查询所有角色方法");
        return roleService.queryAllRoles();
    }
}
