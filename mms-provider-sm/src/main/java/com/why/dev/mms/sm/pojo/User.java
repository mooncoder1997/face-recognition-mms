/**
 * Project Name: mms-provider-sm
 * File Name: User.java
 * Package Name: com.why.dev.mms.sm.pojo
 * Date: 2018/01/02 10:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.pojo;

import java.util.Date;

/**
 * ClassName: User
 * Description: 数据库SM_USER表实体类
 * Date: 2018/01/02 10:47 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class User {
    private String userId;

    private String userPassword;

    private String userName;

    private Integer userGender;

    private String userEmail;

    private String userMobile;

    private String userRoleId;

    private String userFaceId;

    private Integer userIsdel;

    private String userCreatedId;

    private Date userCreatedTime;

    private String userUpdatedId;

    private Date userUpdatedTime;

    private String userRemarks;

    public User() {
    }

    public User(String userId, String userPassword, String userName, Integer userGender, String userEmail, String userMobile, String userRoleId, String userFaceId, Integer userIsdel, String userCreatedId, Date userCreatedTime, String userUpdatedId, Date userUpdatedTime, String userRemarks) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userGender = userGender;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.userRoleId = userRoleId;
        this.userFaceId = userFaceId;
        this.userIsdel = userIsdel;
        this.userCreatedId = userCreatedId;
        this.userCreatedTime = userCreatedTime;
        this.userUpdatedId = userUpdatedId;
        this.userUpdatedTime = userUpdatedTime;
        this.userRemarks = userRemarks;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserFaceId() {
        return userFaceId;
    }

    public void setUserFaceId(String userFaceId) {
        this.userFaceId = userFaceId;
    }

    public Integer getUserIsdel() {
        return userIsdel;
    }

    public void setUserIsdel(Integer userIsdel) {
        this.userIsdel = userIsdel;
    }

    public String getUserCreatedId() {
        return userCreatedId;
    }

    public void setUserCreatedId(String userCreatedId) {
        this.userCreatedId = userCreatedId;
    }

    public Date getUserCreatedTime() {
        return userCreatedTime;
    }

    public void setUserCreatedTime(Date userCreatedTime) {
        this.userCreatedTime = userCreatedTime;
    }

    public String getUserUpdatedId() {
        return userUpdatedId;
    }

    public void setUserUpdatedId(String userUpdatedId) {
        this.userUpdatedId = userUpdatedId;
    }

    public Date getUserUpdatedTime() {
        return userUpdatedTime;
    }

    public void setUserUpdatedTime(Date userUpdatedTime) {
        this.userUpdatedTime = userUpdatedTime;
    }

    public String getUserRemarks() {
        return userRemarks;
    }

    public void setUserRemarks(String userRemarks) {
        this.userRemarks = userRemarks;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userGender=" + userGender +
                ", userEmail='" + userEmail + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userRoleId='" + userRoleId + '\'' +
                ", userFaceId='" + userFaceId + '\'' +
                ", userIsdel=" + userIsdel +
                ", userCreatedId='" + userCreatedId + '\'' +
                ", userCreatedTime=" + userCreatedTime +
                ", userUpdatedId='" + userUpdatedId + '\'' +
                ", userUpdatedTime=" + userUpdatedTime +
                ", userRemarks='" + userRemarks + '\'' +
                '}';
    }
}