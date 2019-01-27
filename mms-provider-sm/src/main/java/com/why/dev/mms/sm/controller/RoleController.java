/**
 * Project Name: mms-provider-sm
 * File Name: RoleController.java
 * Package Name: com.why.dev.mms.sm.controller
 * Date: 2018/12/31 10:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.controller;

import com.why.dev.mms.sm.dto.ResponseResult;
import com.why.dev.mms.sm.pojo.Role;
import com.why.dev.mms.sm.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: RoleController
 * Description: TODO ADD REASON
 * Date: 2018/12/31 10:47 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
@RestController
@RequestMapping("/v1/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public ResponseResult addRole(@RequestBody Role role) {
        log.info("[RoleController] addRole() 进入添加角色信息方法");
        return roleService.addRole(role);
    }

    @RequestMapping(value = "/role/{roleId}", method = RequestMethod.DELETE)
    public ResponseResult deleteRole(@PathVariable("roleId") String roleId) {
        log.info("[RoleController] deleteRole() 进入删除角色信息方法");
        return roleService.deleteRole(roleId);
    }

    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    public ResponseResult updateRole(@RequestBody Role role) {
        log.info("[RoleController] updateRole() 进入更新角色信息方法");
        return roleService.updateRole(role);
    }

    @RequestMapping(value = "/role/{roleId}", method = RequestMethod.GET)
    public ResponseResult queryOne(@PathVariable("roleId") String roleId) {
        log.info("[RoleController] queryOne() 进入查询角色信息方法");
        return roleService.queryRole(roleId);
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResponseResult queryAll() {
        log.info("[RoleController] queryAll() 进入查询所有角色信息方法");
        return roleService.queryAllRoles();
    }
}
