/**
 * Project Name: face-recognition-mms
 * File Name: JWTUtil
 * Package Name: com.why.dev.mms.sm.util
 * Date: 2019-01-27 22:44
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.why.dev.mms.sm.dto.UserLoginDTO;

/**
 * ClassName: JWTUtil
 * Description: TODO
 * Date: 2019-01-27 22:44
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class JWTUtil {
    public String getToken(UserLoginDTO userLoginDTO) {
        return JWT.create().withAudience(userLoginDTO.getUserNickname())
                .sign(Algorithm.HMAC256(userLoginDTO.getUserPassword()));
    }
}
