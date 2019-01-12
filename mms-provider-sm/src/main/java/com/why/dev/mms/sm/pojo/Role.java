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

    private String roleCreatedNickname;

    private Date roleCreatedTime;

    private String roleUpdatedNickname;

    private Date roleUpdatedTime;

    private String roleRemarks;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getRoleIsdel() {
        return roleIsdel;
    }

    public void setRoleIsdel(Integer roleIsdel) {
        this.roleIsdel = roleIsdel;
    }

    public String getRoleCreatedNickname() {
        return roleCreatedNickname;
    }

    public void setRoleCreatedNickname(String roleCreatedNickname) {
        this.roleCreatedNickname = roleCreatedNickname == null ? null : roleCreatedNickname.trim();
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
        this.roleUpdatedNickname = roleUpdatedNickname == null ? null : roleUpdatedNickname.trim();
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
        this.roleRemarks = roleRemarks == null ? null : roleRemarks.trim();
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleIsdel=" + roleIsdel +
                ", roleCreatedNickname='" + roleCreatedNickname + '\'' +
                ", roleCreatedTime=" + roleCreatedTime +
                ", roleUpdatedNickname='" + roleUpdatedNickname + '\'' +
                ", roleUpdatedTime=" + roleUpdatedTime +
                ", roleRemarks='" + roleRemarks + '\'' +
                '}';
    }
}