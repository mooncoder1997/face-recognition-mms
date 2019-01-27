/**
 * Project Name: mms-provider-sm
 * File Name: UserController.java
 * Package Name: com.why.dev.mms.sm.controller
 * Date: 2018/12/31 10:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.controller;

import com.why.dev.mms.sm.dto.ResponseResult;
import com.why.dev.mms.sm.dto.UserLoginDTO;
import com.why.dev.mms.sm.pojo.User;
import com.why.dev.mms.sm.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: UserController
 * Description: 用户信息处理Controller
 * Date: 2018/12/31 10:47 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/user/")
@Api(value = "UserController", description = "User module API")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * addUser: 插入一条用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseResult addUser(@RequestBody User user) {
        log.info("[UserController] addUser() 进入添加用户信息方法");
        return userService.addUser(user);
    }

    /**
     * deleteUser: 删除一条用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "user/{userId}", method = RequestMethod.DELETE)
    public ResponseResult deleteUser(@PathVariable("userId") String userId) {
        log.info("[UserController] deleteUser() 进入删除用户信息方法");
        return userService.deleteUser(userId);
    }

    /**
     * updateUser: 更新用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public ResponseResult updateUser(@RequestBody User user) {
        log.info("[UserController] updateUser() 进入更新用户信息方法");
        return userService.updateUser(user);
    }

    /**
     * queryOne: 查询一条用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
    public ResponseResult queryOne(@PathVariable("userId") String userId) {
        log.info("[UserController] queryOne() 进入查询用户信息方法");
        return userService.queryUser(userId);
    }

    /**
     * queryAll: 查询所有用户信息
     *
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseResult queryAll() {
        log.info("[UserController] queryAll() 进入查询所有用户信息方法");
        return userService.queryAllUsers();
    }

    @RequestMapping(value = "login", method = RequestMethod.PUT)
    public ResponseResult login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("[UserController] login() 进入用户登陆方法");
        return userService.userLogin(userLoginDTO);
    }
}
