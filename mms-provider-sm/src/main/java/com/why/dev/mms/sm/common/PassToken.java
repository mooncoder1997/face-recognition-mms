/**
 * Project Name: face-recognition-mms
 * File Name: PassToken
 * Package Name: com.why.dev.mms.sm.common
 * Date: 2019-01-27 22:41
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: PassToken
 * Description: TODO
 * Date: 2019-01-27 22:41
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
