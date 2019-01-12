/**
 * Project Name: mms-provider-sm
 * File Name: RoleGroup.java
 * Package Name: com.why.dev.mms.sm.pojo
 * Date: 2018/01/02 10:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.pojo;

import java.util.Date;

/**
 * ClassName: RoleGroup
 * Description: 数据库SM_ROLE_GROUP表实体类
 * Date: 2018/01/02 10:47 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class RoleGroup {
    private String roleGroupId;

    private String roleGroupRoleId;

    private String roleGroupMenuId;

    private String roleGroupMenuPermission;

    private Integer roleGroupIsdel;

    private String roleGroupCreatedNickname;

    private Date roleGroupCreatedTime;

    private String roleGroupUpdatedNickname;

    private Date roleGroupUpdatedTime;

    private String roleGroupRemarks;

    public String getRoleGroupId() {
        return roleGroupId;
    }

    public void setRoleGroupId(String roleGroupId) {
        this.roleGroupId = roleGroupId == null ? null : roleGroupId.trim();
    }

    public String getRoleGroupRoleId() {
        return roleGroupRoleId;
    }

    public void setRoleGroupRoleId(String roleGroupRoleId) {
        this.roleGroupRoleId = roleGroupRoleId == null ? null : roleGroupRoleId.trim();
    }

    public String getRoleGroupMenuId() {
        return roleGroupMenuId;
    }

    public void setRoleGroupMenuId(String roleGroupMenuId) {
        this.roleGroupMenuId = roleGroupMenuId == null ? null : roleGroupMenuId.trim();
    }

    public String getRoleGroupMenuPermission() {
        return roleGroupMenuPermission;
    }

    public void setRoleGroupMenuPermission(String roleGroupMenuPermission) {
        this.roleGroupMenuPermission = roleGroupMenuPermission == null ? null : roleGroupMenuPermission.trim();
    }

    public Integer getRoleGroupIsdel() {
        return roleGroupIsdel;
    }

    public void setRoleGroupIsdel(Integer roleGroupIsdel) {
        this.roleGroupIsdel = roleGroupIsdel;
    }

    public String getRoleGroupCreatedNickname() {
        return roleGroupCreatedNickname;
    }

    public void setRoleGroupCreatedNickname(String roleGroupCreatedNickname) {
        this.roleGroupCreatedNickname = roleGroupCreatedNickname == null ? null : roleGroupCreatedNickname.trim();
    }

    public Date getRoleGroupCreatedTime() {
        return roleGroupCreatedTime;
    }

    public void setRoleGroupCreatedTime(Date roleGroupCreatedTime) {
        this.roleGroupCreatedTime = roleGroupCreatedTime;
    }

    public String getRoleGroupUpdatedNickname() {
        return roleGroupUpdatedNickname;
    }

    public void setRoleGroupUpdatedNickname(String roleGroupUpdatedNickname) {
        this.roleGroupUpdatedNickname = roleGroupUpdatedNickname == null ? null : roleGroupUpdatedNickname.trim();
    }

    public Date getRoleGroupUpdatedTime() {
        return roleGroupUpdatedTime;
    }

    public void setRoleGroupUpdatedTime(Date roleGroupUpdatedTime) {
        this.roleGroupUpdatedTime = roleGroupUpdatedTime;
    }

    public String getRoleGroupRemarks() {
        return roleGroupRemarks;
    }

    public void setRoleGroupRemarks(String roleGroupRemarks) {
        this.roleGroupRemarks = roleGroupRemarks == null ? null : roleGroupRemarks.trim();
    }
}