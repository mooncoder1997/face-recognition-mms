/**
 * Project Name: mms-provider-sm
 * File Name: Role.java
 * Package Name: com.why.dev.mms.sm.pojo
 * Date: 2018/01/02 10:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ClassName: Role
 * Description: 数据库SM_ROLE表实体类
 * Date: 2018/01/02 10:47 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {

    private String roleName;

    private String roleRemarks;

}