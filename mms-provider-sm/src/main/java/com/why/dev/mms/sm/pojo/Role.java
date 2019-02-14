/**
 * Project Name: mms-provider-sm
 * File Name: Role.java
 * Package Name: com.why.dev.mms.sm.pojo
 * Date: 2018/01/02 10:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.pojo;

import java.util.Date;

/**
 * ClassName: Role
 * Description: 数据库SM_ROLE表实体类
 * Date: 2018/01/02 10:47 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class Role {
    private String roleId;

    private String roleName;

    private Integer roleIsdel;

    private String roleCreatedId;

    private Date roleCreatedTime;

    private String roleUpdatedId;

    private Date roleUpdatedTime;

    private String roleRemarks;

    public Role() {
    }

    public Role(String roleId, String roleName, Integer roleIsdel, String roleCreatedId, Date roleCreatedTime, String roleUpdatedId, Date roleUpdatedTime, String roleRemarks) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleIsdel = roleIsdel;
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

    public Integer getRoleIsdel() {
        return roleIsdel;
    }

    public void setRoleIsdel(Integer roleIsdel) {
        this.roleIsdel = roleIsdel;
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
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleIsdel=" + roleIsdel +
                ", roleCreatedId='" + roleCreatedId + '\'' +
                ", roleCreatedTime=" + roleCreatedTime +
                ", roleUpdatedId='" + roleUpdatedId + '\'' +
                ", roleUpdatedTime=" + roleUpdatedTime +
                ", roleRemarks='" + roleRemarks + '\'' +
                '}';
    }
}