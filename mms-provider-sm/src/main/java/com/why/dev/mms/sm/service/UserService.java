/**
 * Project Name: mms-provider-sm
 * File Name: UserService.java
 * Package Name: com.why.dev.mms.sm.service
 * Date: 2019/1/2 11:30 PM
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.service;

import com.why.dev.mms.sm.dto.ResponseResult;
import com.why.dev.mms.sm.dto.UserLoginDTO;
import com.why.dev.mms.sm.pojo.User;

/**
 * ClassName: UserService
 * Description: 用户信息业务逻辑接口
 * Date: 2019/1/2 11:30 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public interface UserService {
    ResponseResult addUser(User user);

    ResponseResult deleteUser(String userId);

    ResponseResult updateUser(User user);

    ResponseResult queryUser(String userId);

    ResponseResult queryAllUsers();

    ResponseResult userLogin(UserLoginDTO userLoginDTO);
}
