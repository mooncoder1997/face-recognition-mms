/**
 * Project Name: face-recognition-mms
 * File Name: UserLoginToken
 * Package Name: com.why.dev.mms.sm
 * Date: 2019-01-27 22:43
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: UserLoginToken
 * Description: TODO
 * Date: 2019-01-27 22:43
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserLoginToken {
    boolean required() default true;
}
