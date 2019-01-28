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

    private String username;

    private String password;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
