/**
 * Project Name: face-recognition-mms
 * File Name: UserInfoVO
 * Package Name: com.why.dev.mms.sm.vo
 * Date: 2019/1/3 8:16 PM
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.vo;

import java.util.Date;

/**
 * ClassName: UserInfoVO
 * Description: TODO ADD REASON
 * Date: 2019/1/3 8:16 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class UserInfoVO {
    private String userId;

    private String userNickname;

    private String userName;

    private Integer userGender;

    private String userEmail;

    private String userMobile;

    private String userRoleName;

    private String userCreatedNickname;

    private Date userCreatedTime;

    private String userUpdatedNickname;

    private Date userUpdatedTime;

    private String userRemarks;

    public UserInfoVO() {
    }

    public UserInfoVO(String userId, String userNickname, String userName, Integer userGender, String userEmail, String userMobile, String userRoleName, String userCreatedNickname, Date userCreatedTime, String userUpdatedNickname, Date userUpdatedTime, String userRemarks) {
        this.userId = userId;
        this.userNickname = userNickname;
        this.userName = userName;
        this.userGender = userGender;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.userRoleName = userRoleName;
        this.userCreatedNickname = userCreatedNickname;
        this.userCreatedTime = userCreatedTime;
        this.userUpdatedNickname = userUpdatedNickname;
        this.userUpdatedTime = userUpdatedTime;
        this.userRemarks = userRemarks;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
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

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getUserCreatedNickname() {
        return userCreatedNickname;
    }

    public void setUserCreatedNickname(String userCreatedNickname) {
        this.userCreatedNickname = userCreatedNickname;
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
        this.userUpdatedNickname = userUpdatedNickname;
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
        return "UserInfoVO{" +
                "userId='" + userId + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userName='" + userName + '\'' +
                ", userGender=" + userGender +
                ", userEmail='" + userEmail + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userRoleName='" + userRoleName + '\'' +
                ", userCreatedNickname='" + userCreatedNickname + '\'' +
                ", userCreatedTime=" + userCreatedTime +
                ", userUpdatedNickname='" + userUpdatedNickname + '\'' +
                ", userUpdatedTime=" + userUpdatedTime +
                ", userRemarks='" + userRemarks + '\'' +
                '}';
    }
}
