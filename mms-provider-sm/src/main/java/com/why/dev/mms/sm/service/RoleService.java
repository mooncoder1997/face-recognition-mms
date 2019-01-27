/**
 * Project Name: face-recognition-mms
 * File Name: RoleService.java
 * Package Name: com.why.dev.mms.sm.service
 * Date: 2019-01-16 21:43
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.service;

import com.why.dev.mms.sm.dto.ResponseResult;
import com.why.dev.mms.sm.pojo.Role;

/**
 * ClassName: RoleService
 * Description: 角色信息业务员逻辑借口
 * Date: 2019-01-16 21:43
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public interface RoleService {
    ResponseResult addRole(Role role);

    ResponseResult deleteRole(String roleId);

    ResponseResult updateRole(Role role);

    ResponseResult queryRole(String roleId);

    ResponseResult queryAllRoles();
}
