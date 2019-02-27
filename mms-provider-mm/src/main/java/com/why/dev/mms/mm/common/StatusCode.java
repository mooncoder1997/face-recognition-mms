/**
 * Project Name: mms-provider-mm
 * File Name: StatusCode.java
 * Package Name: com.why.dev.mms.mm.common
 * Date: 2018/12/23 8:33 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.common;

/**
 * ClassName: StatusCode
 * Description: 状态码 常量类
 * Date: 2018/12/23 8:33 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class StatusCode {
    /** 操作成功*/
    public static final Integer OPERATIONSUCCESS = 200;

    /** 操作失败*/
    public static final Integer OPERATIONERROR = 500;

    /** [GET] 服务器成功返回用户请求的数据 */
    public final static Integer SUCCESS_GET = 200;

    /** [POST/PUT/PATCH] 用户新建或修改数据成功 */
    public final static Integer SUCCESS_POST_PUT_PATCH = 201;

    /** [*] 表示一个请求已经进入后台排队（异步任务） */
    public final static Integer SUCCESS_INTO_QUEUE = 202;

    /** [DELETE] 用户删除数据成功 */
    public final static Integer SUCCESS_DELETE = 204;

    /** [POST/PUT/PATCH] 用户发出的请求有错误，服务器没有进行新建或修改数据的操作 */
    public final static Integer ERROR_INVALID_RREQUEST = 400;

    /** [*] 表示用户没有权限 */
    public final static Integer ERROR_UNAUTHORIZED = 401;

    /** [*] 访问被禁止 */
    public final static Integer ERROR_FORBIDDEN = 403;

    /** [GET] 用户请求的格式不可得 */
    public final static Integer ERROR_NOT_ACCEPTABLE = 406;

    /** 用户请求的资源被删除 */
    public final static Integer ERROR_GONE = 410;

    /** [*] 服务器发生错误 */
    public final static Integer ERROR_INTERNAL_SERVER_ERROR = 500;
}
