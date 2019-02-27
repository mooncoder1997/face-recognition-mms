/**
 * Project Name: mms-provider-mm
 * File Name: ResponseResult.java
 * Package Name: com.why.dev.mms.mm.dto
 * Date: 2018/12/23 8:37 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * ClassName: ResponseResult
 * Description: 封装返回值
 * Date: 2018/12/23 8:37 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@ApiModel(value="ResponseResult")
@JsonSerialize
public class ResponseResult implements Serializable {
    /** 返回的数据 */
    @ApiModelProperty(value="data(Object)",example="map/list...")
    private Object data;

    /** 成功or失败 */
    @ApiModelProperty(value="success(boolean)",example="true")
    private boolean success;

    /** 消息 */
    @ApiModelProperty(value="message(String)",example="登录成功 , 用户为注册")
    private String message;

    /** 状态码 */
    @ApiModelProperty(value="code(Integer)",example="404")
    private Integer code;

    /** 前端弹窗级别："warning", "error", "success", "info" */
    @ApiModelProperty(value="icon(String)",example="warning/error/success/info")
    private String icon;

    public ResponseResult() {

    }

    public ResponseResult(boolean success, String message) {
        this.success = success;
        this.message = message;
        if (success) icon = "success";
        else icon = "error";
    }

    public ResponseResult(boolean success, String message, Integer code) {
        this(success, message);
        this.code = code;
    }

    public ResponseResult(Object data, boolean success, String message, Integer code) {
        this(success, message, code);
        this.data = data;
    }

    public static ResponseResult responseResult(Object data, boolean success, String message, Integer code,String icon) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.data = data;
        responseResult.success = success;
        responseResult.message = message;
        responseResult.code = code;
        responseResult.icon = icon;
        return responseResult;
    }

    // 返回成功结果
    public static ResponseResult resultSuccess(Object data, String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.data = data;
        responseResult.success = true;
        responseResult.message = message;
        return responseResult;
    }

    // 返回失败结果
    public static ResponseResult resultError(String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.success = false;
        responseResult.message = message;
        return responseResult;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "data=" + data +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", icon='" + icon + '\'' +
                '}';
    }
}
