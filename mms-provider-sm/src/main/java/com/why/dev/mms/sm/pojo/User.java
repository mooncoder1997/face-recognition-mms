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

    private String userNickname;

    private String userPassword;

    private String userName;

    private Integer userGender;

    private String userEmail;

    private String userMobile;

    private String userRoleId;

    private String userFaceId;

    private Integer userIsdel;

    private String userCreatedNickname;

    private Date userCreatedTime;

    private String userUpdatedNickname;

    private Date userUpdatedTime;

    private String userRemarks;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }

    public String getUserFaceId() {
        return userFaceId;
    }

    public void setUserFaceId(String userFaceId) {
        this.userFaceId = userFaceId == null ? null : userFaceId.trim();
    }

    public Integer getUserIsdel() {
        return userIsdel;
    }

    public void setUserIsdel(Integer userIsdel) {
        this.userIsdel = userIsdel;
    }

    public String getUserCreatedNickname() {
        return userCreatedNickname;
    }

    public void setUserCreatedNickname(String userCreatedNickname) {
        this.userCreatedNickname = userCreatedNickname == null ? null : userCreatedNickname.trim();
    }

    public Date getUserCreatedTime() {
        return userCreatedTime;
    }

    public void setUserCreatedTime(Date userCreatedTime) {
        this.userCreatedTime = userCreatedTime;
    }

    public String getUserUpdatedNickname() {
        return userUpdatedNickname;
    }

    public void setUserUpdatedNickname(String userUpdatedNickname) {
        this.userUpdatedNickname = userUpdatedNickname == null ? null : userUpdatedNickname.trim();
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
        this.userRemarks = userRemarks == null ? null : userRemarks.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userGender=" + userGender +
                ", userEmail='" + userEmail + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userRoleId='" + userRoleId + '\'' +
                ", userFaceId='" + userFaceId + '\'' +
                ", userIsdel=" + userIsdel +
                ", userCreatedNickname='" + userCreatedNickname + '\'' +
                ", userCreatedTime=" + userCreatedTime +
                ", userUpdatedNickname='" + userUpdatedNickname + '\'' +
                ", userUpdatedTime=" + userUpdatedTime +
                ", userRemarks='" + userRemarks + '\'' +
                '}';
    }
}