/**
 * Project Name: face-recognition-mms
 * File Name: RoleInfoVO
 * Package Name: com.why.dev.mms.sm.vo
 * Date: 2019-01-17 16:29
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.vo;

import java.util.Date;

/**
 * ClassName: RoleInfoVO
 * Description: 封装显示在前端的角色信息
 * Date: 2019-01-17 16:29
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class RoleInfoVO {
    private String roleId;

    private String roleName;

    private String roleCreatedNickname;

    private Date roleCreatedTime;

    private String roleUpdatedNickname;

    private Date roleUpdatedTime;

    private String roleRemarks;

    public RoleInfoVO() {
    }

    public RoleInfoVO(String roleId, String roleName, String roleCreatedNickname, Date roleCreatedTime, String roleUpdatedNickname, Date roleUpdatedTime, String roleRemarks) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleCreatedNickname = roleCreatedNickname;
        this.roleCreatedTime = roleCreatedTime;
        this.roleUpdatedNickname = roleUpdatedNickname;
        this.roleUpdatedTime = roleUpdatedTime;
        this.roleRemarks = roleRemarks;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCreatedNickname() {
        return roleCreatedNickname;
    }

    public void setRoleCreatedNickname(String roleCreatedNickname) {
        this.roleCreatedNickname = roleCreatedNickname;
    }

    public Date getRoleCreatedTime() {
        return roleCreatedTime;
    }

    public void setRoleCreatedTime(Date roleCreatedTime) {
        this.roleCreatedTime = roleCreatedTime;
    }

    public String getRoleUpdatedNickname() {
        return roleUpdatedNickname;
    }

    public void setRoleUpdatedNickname(String roleUpdatedNickname) {
        this.roleUpdatedNickname = roleUpdatedNickname;
    }

    public Date getRoleUpdatedTime() {
        return roleUpdatedTime;
    }

    public void setRoleUpdatedTime(Date roleUpdatedTime) {
        this.roleUpdatedTime = roleUpdatedTime;
    }

    public String getRoleRemarks() {
        return roleRemarks;
    }

    public void setRoleRemarks(String roleRemarks) {
        this.roleRemarks = roleRemarks;
    }

    @Override
    public String toString() {
        return "RoleInfoVO{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleCreatedNickname='" + roleCreatedNickname + '\'' +
                ", roleCreatedTime=" + roleCreatedTime +
                ", roleUpdatedNickname='" + roleUpdatedNickname + '\'' +
                ", roleUpdatedTime=" + roleUpdatedTime +
                ", roleRemarks='" + roleRemarks + '\'' +
                '}';
    }
}
