/**
 * Project Name: mms-provider-sm
 * File Name: UserServiceImpl.java
 * Package Name: com.why.dev.mms.sm.service.impl
 * Date: 2019/1/2 11:31 PM
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.service.impl;

import com.why.dev.mms.sm.common.StatusCode;
import com.why.dev.mms.sm.dao.RoleMapper;
import com.why.dev.mms.sm.dao.UserMapper;
import com.why.dev.mms.sm.dto.ResponseResult;
import com.why.dev.mms.sm.pojo.User;
import com.why.dev.mms.sm.service.UserService;
import com.why.dev.mms.sm.vo.UserInfoVO;
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
 * ClassName: UserServiceImpl
 * Description: 用户信息业务逻辑实现
 * Date: 2019/1/2 11:31 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public ResponseResult addUser(User user) {
        log.info("[UserServiceImpl] addUser() 进入添加用户信息方法");
        if (user == null) {
            log.info("[UserServiceImpl] addUser() 参数为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        user.setUserId(UUID.randomUUID().toString().replace("-",""));
        try {
            if (userMapper.insertSelective(user) == 0) {
                log.info("[UserServiceImpl] addUser() 添加用户信息执行失败");
                return new ResponseResult(false, "添加用户信息失败", StatusCode.OPERATIONERROR);
            }
            log.info("[UserServiceImpl] addUser() 添加用户信息成功: " + user.toString());
            return new ResponseResult(true, "添加用户信息成功", StatusCode.SUCCESS_POST_PUT_PATCH);
        } catch (DuplicateKeyException e) {
            log.info("[UserServiceImpl] addUser() 添加用户信息出错，违反唯一约束");
            return new ResponseResult(false, "用户昵称重复", StatusCode.OPERATIONERROR);
        }
    }

    @Override
    public ResponseResult deleteUser(String userId) {
        log.info("[UserServiceImpl] deleteUser() 进入删除用户信息方法");
        if (StringUtils.isBlank(userId)) {
            log.info("[UserServiceImpl] deleteUser() userId为空，不能删除面部信息");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        int result = userMapper.deleteByPrimaryKey(userId);
        if (result == 0) {
            log.info("[UserServiceImpl] deleteUser() 用户不存在，userId: " + userId);
            return new ResponseResult(false, "用户不存在", StatusCode.OPERATIONERROR);
        }
        log.info("[UserServiceImpl] deleteUser() 删除用户信息成功: " + userId);
        return new ResponseResult(true, "删除用户信息成功", StatusCode.SUCCESS_DELETE);
    }

    @Override
    public ResponseResult updateUser(User user) {
        log.info("[UserServiceImpl] updateUser() 进入更新用户信息方法");
        if (user == null) {
            log.info("[UserServiceImpl] updateUser() 参数为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        if (userMapper.updateByPrimaryKeySelective(user) == 0) {
            log.info("[UserServiceImpl] updateUser() 更新用户信息执行失败");
            return new ResponseResult(false, "更新用户信息失败", StatusCode.OPERATIONERROR);
        }
        log.info("[UserServiceImpl] updateUser() 更新用户信息成功: " + user.toString());
        return new ResponseResult(true, "更新用户信息成功", StatusCode.SUCCESS_POST_PUT_PATCH);
    }

    @Override
    public ResponseResult queryUser(String userId) {
        log.info("[UserServiceImpl] queryUser() 进入查询用户信息方法");
        if (StringUtils.isBlank(userId)) {
            log.info("[UserServiceImpl] queryUser() userId为空，不能查询用户信息");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            log.info("[UserServiceImpl] queryUser() 用户不存在，userId: " + userId);
            return new ResponseResult(false, "用户不存在", StatusCode.OPERATIONERROR);
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUserId(user.getUserId());
        userInfoVO.setUserNickname(user.getUserNickname());
        userInfoVO.setUserName(user.getUserName());
        userInfoVO.setUserGender(user.getUserGender());
        userInfoVO.setUserEmail(user.getUserEmail());
        userInfoVO.setUserMobile(user.getUserMobile());
        userInfoVO.setUserRoleName(roleMapper.selectRoleNameByPrimiaryKey(user.getUserRoleId()));
        userInfoVO.setUserCreatedNickname(user.getUserCreatedNickname());
        userInfoVO.setUserCreatedTime(user.getUserCreatedTime());
        if (!StringUtils.isBlank(user.getUserCreatedNickname())) {
            userInfoVO.setUserUpdatedNickname(user.getUserUpdatedNickname());
            userInfoVO.setUserUpdatedTime(user.getUserUpdatedTime());
        }
        log.info("[UserServiceImpl] queryUser() 查询用户信息成功: " + userInfoVO.toString());
        return new ResponseResult(userInfoVO, true, "查询用户信息成功", StatusCode.SUCCESS_GET);
    }

    @Override
    public ResponseResult queryAllUsers() {
        log.info("[UserServiceImpl] queryAllUsers() 进入查询所有用户信息方法");
        List<User> userList = userMapper.findAllUser();
        if (CollectionUtils.isEmpty(userList)) {
            log.info("[UserServiceImpl] queryAllUsers() 没有查到用户信息");
            return new ResponseResult(false, "没有查到用户信息", StatusCode.OPERATIONERROR);
        }
        List<UserInfoVO> userInfoVOList = new ArrayList<>();
        for (User user : userList) {
            UserInfoVO userInfoVO = new UserInfoVO();
            userInfoVO.setUserId(user.getUserId());
            userInfoVO.setUserNickname(user.getUserNickname());
            userInfoVO.setUserName(user.getUserName());
            userInfoVO.setUserGender(user.getUserGender());
            userInfoVO.setUserEmail(user.getUserEmail());
            userInfoVO.setUserMobile(user.getUserMobile());
            userInfoVO.setUserRoleName(roleMapper.selectRoleNameByPrimiaryKey(user.getUserRoleId()));
            userInfoVO.setUserCreatedNickname(user.getUserCreatedNickname());
            userInfoVO.setUserCreatedTime(user.getUserCreatedTime());
            if (!StringUtils.isBlank(user.getUserCreatedNickname())) {
                userInfoVO.setUserUpdatedNickname(user.getUserUpdatedNickname());
                userInfoVO.setUserUpdatedTime(user.getUserUpdatedTime());
            }
            userInfoVOList.add(userInfoVO);
        }
        log.info("[UserServiceImpl] queryAllUsers() 查询所有用户信息成功，共查到" + userInfoVOList.size() + "条用户信息数据");
        return new ResponseResult(userInfoVOList, true, "查询所有用户信息成功", StatusCode.SUCCESS_GET);
    }
}
