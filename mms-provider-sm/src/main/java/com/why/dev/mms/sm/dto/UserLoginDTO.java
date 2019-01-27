/**
 * Project Name: face-recognition-mms
 * File Name: UserLoginDTO
 * Package Name: com.why.dev.mms.sm.dto
 * Date: 2019-01-18 15:31
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.dto;

/**
 * ClassName: UserLoginDTO
 * Description: TODO
 * Date: 2019-01-18 15:31
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class UserLoginDTO {

    private String userId;

    private String userPassword;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
