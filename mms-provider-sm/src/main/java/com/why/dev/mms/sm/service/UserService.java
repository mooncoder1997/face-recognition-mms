/**
 * Project Name: mms-provider-sm
 * File Name: UserServiceImpl.java
 * Package Name: com.why.dev.mms.sm.service.impl
 * Date: 2019/1/2 11:31 PM
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.service;

import com.why.dev.mms.sm.common.StatusCode;
import com.why.dev.mms.sm.dao.UserMapper;
import com.why.dev.mms.sm.dto.ResponseResult;
import com.why.dev.mms.sm.dto.UserLoginDTO;
import com.why.dev.mms.sm.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * addUser: 添加新的用户信息
     *
     * @param user
     * @return  成功: {true, "添加用户信息成功", 201}
     *          失败: {false, "参数为空", 400}, {false, "添加用户信息失败", 500}, {false, "用户昵称重复", 500},
     */
    public ResponseResult addUser(User user) {
        log.info("[UserService] addUser() 进入添加用户信息方法");
        if (user == null) {
            log.info("[UserService] addUser() 参数为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        try {
            if (userMapper.insertSelective(user) == 0) {
                log.info("[UserService] addUser() 添加用户信息执行失败");
                return new ResponseResult(false, "添加用户信息失败", StatusCode.OPERATIONERROR);
            }
            log.info("[UserService] addUser() 添加用户信息成功: " + user.toString());
            return new ResponseResult(true, "添加用户信息成功", StatusCode.SUCCESS_POST_PUT_PATCH);
        } catch (DuplicateKeyException e) {
            log.info("[UserService] addUser() 添加用户信息出错，违反唯一约束");
            return new ResponseResult(false, "用户昵称重复", StatusCode.ERROR_INVALID_RREQUEST);
        }
    }

    /**
     *deleteUser: 删除用户信息
     *
     * @param userId
     * @return  成功: {true, "删除用户信息成功", 204}
     *          失败: {false, "参数为空", 400}, {false, "用户不存在", 410}
     */
    public ResponseResult deleteUser(String userId) {
        log.info("[UserService] deleteUser() 进入删除用户信息方法");
        if (StringUtils.isBlank(userId)) {
            log.info("[UserService] deleteUser() userId为空，不能删除用户信息");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        int result = userMapper.deleteByPrimaryKey(userId);
        if (result == 0) {
            log.info("[UserService] deleteUser() 用户不存在，userId: " + userId);
            return new ResponseResult(false, "用户不存在", StatusCode.ERROR_GONE);
        }
        log.info("[UserService] deleteUser() 删除用户信息成功: " + userId);
        return new ResponseResult(true, "删除用户信息成功", StatusCode.SUCCESS_DELETE);
    }

    /**
     * updateUser: 更新用户信息
     *
     * @param user
     * @return  成功: {true, "更新用户信息成功", 201}
     *          失败: {false, "参数为空", 400}, {false, "更新用户信息失败", 500}
     */
    public ResponseResult updateUser(User user) {
        log.info("[UserService] updateUser() 进入更新用户信息方法");
        if (user == null) {
            log.info("[UserService] updateUser() 参数为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        if (userMapper.updateByPrimaryKeySelective(user) == 0) {
            log.info("[UserService] updateUser() 更新用户信息执行失败");
            return new ResponseResult(false, "更新用户信息失败", StatusCode.OPERATIONERROR);
        }
        log.info("[UserService] updateUser() 更新用户信息成功: " + user.toString());
        return new ResponseResult(true, "更新用户信息成功", StatusCode.SUCCESS_POST_PUT_PATCH);
    }

    /**
     * queryUser: 查询用户信息
     *
     * @param userId
     * @return  成功: {faceInfoVO, true, "查询用户信息成功", 200}
     *          失败: {false, "参数为空", 400}, {false, "用户不存在", 410}
     */
    public ResponseResult queryUser(String userId) {
        log.info("[UserService] queryUser() 进入查询用户信息方法");
        if (StringUtils.isBlank(userId)) {
            log.info("[UserService] queryUser() userId为空，不能查询用户信息");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            log.info("[UserService] queryUser() 用户不存在，userId: " + userId);
            return new ResponseResult(false, "用户不存在", StatusCode.ERROR_GONE);
        }
        log.info("[UserService] queryUser() 查询用户信息成功: " + user.toString());
        return new ResponseResult(user, true, "查询用户信息成功", StatusCode.SUCCESS_GET);
    }

    /**
     * queryAllUsers: 查询所有用户信息
     *
     * @return  成功: {userInfoVOList, true, "查询用户信息成功", 200}
     *          失败: {false, "没有查到用户信息", 410}
     */
    public ResponseResult queryAllUsers() {
        log.info("[UserService] queryAllUsers() 进入查询所有用户信息方法");
        List<User> userList = userMapper.findAllUser();
        if (CollectionUtils.isEmpty(userList)) {
            log.info("[UserService] queryAllUsers() 没有查到用户信息");
            return new ResponseResult(false, "没有查到用户信息", StatusCode.ERROR_GONE);
        }
        log.info("[UserService] queryAllUsers() 查询所有用户信息成功，共查到" + userList.size() + "条用户信息数据");
        return new ResponseResult(userList, true, "查询用户信息成功", StatusCode.SUCCESS_GET);
    }

    /**
     * userLogin: 用户登陆
     *
     * @param userLoginDTO
     * @return  成功: {userInfoVO, true, "登陆成功", 201}
     *          失败: {false, "参数为空", 400}, {false, "用户不存在", 410}, {false, "密码不正确", 401}
     */
    public ResponseResult userLogin(UserLoginDTO userLoginDTO) {
        log.info("[UserService] userLogin() 进入用户登陆方法");
        if (userLoginDTO == null) {
            log.info("[UserService] userLogin() userLoginDTO为空，不能登陆");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        } else if (StringUtils.isBlank(userLoginDTO.getUsername()) || StringUtils.isBlank(userLoginDTO.getPassword())) {
            log.info("[UserService] userLogin() 用户名或密码为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        User user = userMapper.selectByPrimaryKey(userLoginDTO.getUsername());
        if (user == null) {
            log.info("[UserService] userLogin() 用户不存在，userId: " + userLoginDTO.getUsername());
            return new ResponseResult(false, "用户不存在", StatusCode.ERROR_GONE);
        }
        if (!userLoginDTO.getPassword().equals(user.getUserPassword())) {
            log.info("[UserService] userLogin() 密码错误,登陆失败");
            return new ResponseResult(false, "密码不正确", StatusCode.ERROR_UNAUTHORIZED);
        }
        log.info("[UserService] userLogin() 登陆成功: " + user.toString());
        return new ResponseResult(user, true, "登陆成功", StatusCode.SUCCESS_POST_PUT_PATCH);
    }
}
