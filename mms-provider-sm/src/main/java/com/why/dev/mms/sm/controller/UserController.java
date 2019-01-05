/**
 * Project Name: mms-provider-sm
 * File Name: UserController.java
 * Package Name: com.why.dev.mms.sm.controller
 * Date: 2018/12/31 10:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.controller;

import com.why.dev.mms.sm.dto.ResponseResult;
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
@RequestMapping("/v1/user/")
@Api(value = "UserController", description = "User module API")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseResult addUser(@RequestBody User user) {
        log.info("[UserController] addUser() 进入添加用户信息方法");
        return userService.addUser(user);
    }

    @RequestMapping(value = "user/{userId}", method = RequestMethod.DELETE)
    public ResponseResult deleteUser(@PathVariable("userId") String userId) {
        log.info("[UserController] deleteUser() 进入删除用户信息方法");
        return userService.deleteUser(userId);
    }

    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public ResponseResult updateUser(@RequestBody User user) {
        log.info("[FaceController] updateUser() 进入更新面部信息方法");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
    public ResponseResult queryOne(@PathVariable("userId") String userId) {
        log.info("[FaceController] queryOne() 进入查询用户信息方法");
        return userService.queryUser(userId);
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseResult queryAll() {
        log.info("[FaceController] queryAll() 进入查询所有用户信息方法");
        return userService.queryAllUsers();
    }

}
