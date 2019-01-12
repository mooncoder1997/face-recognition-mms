/**
 * Project Name: face-recognition-mms
 * File Name: JsonUtil.java
 * Package Name: com.why.dev.mms.face.util
 * Date: 2018/12/23 8:43 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.why.dev.mms.face.exception.JsonException;

/**
 * ClassName: JsonUtil
 * Description: Json工具类
 * Date: 2018/12/23 8:43 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class JsonUtil<T> {
    static ObjectMapper objectMapper = null;

    static {
        objectMapper = new ObjectMapper().configure(SerializationFeature.WRITE_NULL_MAP_VALUES, true);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public JsonUtil() {
    }

    /**
     * Json字符串反序列化对象
     *
     * @param data
     * @param classToDeserialize
     * @return
     * @throws JsonException
     */
    public T deSerializeFromString(String data, Class<T> classToDeserialize) throws JsonException {
        ObjectMapper jsonConverter = this.getObjectMapper();
        try {
            T auditData = jsonConverter.readValue(data, classToDeserialize);
            return auditData;
        } catch (Exception e) {
            throw new JsonException("Json Deserialize Failed, Unable to Deserialize Object" + e.getMessage() ,e);
        }
    }

    /**
     * 对象序列化为Json字符串
     *
     * @param objectToSerialize
     * @return
     * @throws JsonException
     */
    public String serializeToString(T objectToSerialize) throws JsonException {
        ObjectMapper jsonConverter = this.getObjectMapper();
        try {
            return jsonConverter.writeValueAsString(objectToSerialize);
        } catch (Exception e) {
            throw new JsonException("Json Serialize Failed, Unable to Serialize String" + e.getMessage() ,e);
        }
    }
}
