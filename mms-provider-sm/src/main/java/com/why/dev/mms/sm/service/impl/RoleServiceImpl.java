/**
 * Project Name: face-recognition-mms
 * File Name: RoleServiceImpl
 * Package Name: com.why.dev.mms.sm.service.impl
 * Date: 2019-01-16 22:10
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.service.impl;

import com.why.dev.mms.sm.common.StatusCode;
import com.why.dev.mms.sm.dao.RoleMapper;
import com.why.dev.mms.sm.dto.ResponseResult;
import com.why.dev.mms.sm.pojo.Role;
import com.why.dev.mms.sm.service.RoleService;
import com.why.dev.mms.sm.vo.RoleInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public ResponseResult addRole(Role role) {
        log.info("[RoleServiceImpl] addRole() 进入添加角色信息方法");
        if (role == null) {
            log.info("[RoleServiceImpl] addRole() 参数为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        role.setRoleId(UUID.randomUUID().toString().replace("-",""));
        try {
            if (roleMapper.insertSelective(role) == 0) {
                log.info("[RoleServiceImpl] addRole() 添加角色信息执行失败");
                return new ResponseResult(false, "添加角色信息失败", StatusCode.OPERATIONERROR);
            }
            log.info("[RoleServiceImpl] addRole() 添加角色信息成功: " + role.toString());
            return new ResponseResult(true, "添加角色信息成功", StatusCode.SUCCESS_POST_PUT_PATCH);
        } catch (DuplicateKeyException e) {
            log.info("[RoleServiceImpl] addRole() 添加角色信息出错，违反唯一约束");
            return new ResponseResult(false, "角色名称重复", StatusCode.OPERATIONERROR);
        }
    }

    @Override
    public ResponseResult deleteRole(String roleId) {
        log.info("[RoleServiceImpl] deleteRole() 进入删除角色信息方法");
        if (StringUtils.isBlank(roleId)) {
            log.info("[RoleServiceImpl] deleteRole() roleId，不能删除角色信息");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        int result = roleMapper.deleteByPrimaryKey(roleId);
        if (result == 0) {
            log.info("[RoleServiceImpl] deleteRole() 角色不存在，roleId: " + roleId);
            return new ResponseResult(false, "角色不存在", StatusCode.OPERATIONERROR);
        }
        log.info("[RoleServiceImpl] deleteRole() 删除角色信息成功: " + roleId);
        return new ResponseResult(true, "删除角色信息成功", StatusCode.SUCCESS_DELETE);
    }

    @Override
    public ResponseResult updateRole(Role role) {
        log.info("[RoleServiceImpl] updateRole() 进入更新角色信息方法");
        if (role == null) {
            log.info("[RoleServiceImpl] updateRole() 参数为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        if (roleMapper.updateByPrimaryKeySelective(role) == 0) {
            log.info("[RoleServiceImpl] updateRole() 更新角色信息执行失败");
            return new ResponseResult(false, "更新角色信息失败", StatusCode.OPERATIONERROR);
        }
        log.info("[RoleServiceImpl] updateRole() 更新用户信息成功: " + role.toString());
        return new ResponseResult(true, "更新用户信息成功", StatusCode.SUCCESS_POST_PUT_PATCH);
    }

    @Override
    public ResponseResult queryRole(String roleId) {
        log.info("[RoleServiceImpl] queryRole() 进入查询角色信息方法");
        if (StringUtils.isBlank(roleId)) {
            log.info("[RoleServiceImpl] queryRole() roleId为空，不能查询角色信息");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        Role role = roleMapper.selectByPrimaryKey(roleId);
        if (role == null) {
            log.info("[RoleServiceImpl] queryRole() 角色不存在，roleId: " + roleId);
            return new ResponseResult(false, "角色不存在", StatusCode.OPERATIONERROR);
        }
        RoleInfoVO roleInfoVO = roleToRoleInfoVO(role);
        log.info("[RoleServiceImpl] queryRole() 查询角色信息成功: " + roleInfoVO.toString());
        return new ResponseResult(roleInfoVO, true, "查询角色信息成功", StatusCode.SUCCESS_GET);
    }

    @Override
    public ResponseResult queryAllRoles() {
        log.info("[RoleServiceImpl] queryAllRoles() 进入查询角色信息方法");
        List<Role> roleList = roleMapper.findAllRole();
        if (CollectionUtils.isEmpty(roleList)) {
            log.info("[RoleServiceImpl] queryAllRoles() 没有查到角色信息");
            return new ResponseResult(false, "没有查到角色信息", StatusCode.OPERATIONERROR);
        }
        List<RoleInfoVO> roleInfoVOList = new ArrayList<>();
        for (Role role : roleList) {
            RoleInfoVO roleInfoVO = roleToRoleInfoVO(role);
            roleInfoVOList.add(roleInfoVO);
        }
        log.info("[RoleServiceImpl] queryAllRoles() 查询所有角色信息成功，共查到" + roleInfoVOList.size() + "条角色信息数据");
        return new ResponseResult(roleInfoVOList, true, "查询角色信息成功", StatusCode.SUCCESS_GET);
    }

    private RoleInfoVO roleToRoleInfoVO(Role role) {
        RoleInfoVO roleInfoVO = new RoleInfoVO();
        roleInfoVO.setRoleId(role.getRoleId());
        roleInfoVO.setRoleName(role.getRoleName());
        roleInfoVO.setRoleCreatedId(role.getRoleCreatedId());
        roleInfoVO.setRoleCreatedTime(role.getRoleCreatedTime());
        if (StringUtils.isBlank(role.getRoleUpdatedId())) {
            roleInfoVO.setRoleUpdatedId(role.getRoleUpdatedId());
            roleInfoVO.setRoleUpdatedTime(role.getRoleUpdatedTime());
        }
        return roleInfoVO;
    }
}
