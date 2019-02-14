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

    private String roleCreatedId;

    private Date roleCreatedTime;

    private String roleUpdatedId;

    private Date roleUpdatedTime;

    private String roleRemarks;

    public RoleInfoVO() {
    }

    public RoleInfoVO(String roleId, String roleName, String roleCreatedId, Date roleCreatedTime, String roleUpdatedId, Date roleUpdatedTime, String roleRemarks) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleCreatedId = roleCreatedId;
        this.roleCreatedTime = roleCreatedTime;
        this.roleUpdatedId = roleUpdatedId;
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

    public String getRoleCreatedId() {
        return roleCreatedId;
    }

    public void setRoleCreatedId(String roleCreatedId) {
        this.roleCreatedId = roleCreatedId;
    }

    public Date getRoleCreatedTime() {
        return roleCreatedTime;
    }

    public void setRoleCreatedTime(Date roleCreatedTime) {
        this.roleCreatedTime = roleCreatedTime;
    }

    public String getRoleUpdatedId() {
        return roleUpdatedId;
    }

    public void setRoleUpdatedId(String roleUpdatedId) {
        this.roleUpdatedId = roleUpdatedId;
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
                ", roleCreatedId='" + roleCreatedId + '\'' +
                ", roleCreatedTime=" + roleCreatedTime +
                ", roleUpdatedId='" + roleUpdatedId + '\'' +
                ", roleUpdatedTime=" + roleUpdatedTime +
                ", roleRemarks='" + roleRemarks + '\'' +
                '}';
    }
}
