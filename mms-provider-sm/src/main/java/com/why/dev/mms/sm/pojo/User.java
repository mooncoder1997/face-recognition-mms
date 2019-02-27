/**
 * Project Name: mms-provider-sm
 * File Name: User.java
 * Package Name: com.why.dev.mms.sm.pojo
 * Date: 2018/01/02 10:47 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

/**
 * ClassName: User
 * Description: 数据库SM_USER表实体类
 * Date: 2018/01/02 10:47 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"userPassword"})
public class User {

    private String userId;

    @JsonProperty(access = WRITE_ONLY)
    private String userPassword;

    private String userName;

    private String userGender;

    private String userEmail;

    private String userMobile;

    private String userRoleName;

    private String userFaceId;

    private String userRemarks;

}