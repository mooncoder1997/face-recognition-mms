/**
 * Project Name: face-recognition-mms
 * File Name: JsonException.java
 * Package Name: com.why.dev.mms.face.exception
 * Date: 2018/12/23 8:39 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.common.exception;

/**
 * ClassName: JsonException
 * Description: Json工具类使用的自定义异常类
 * Date: 2018/12/23 8:39 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class JsonException extends Exception {
    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }
}
