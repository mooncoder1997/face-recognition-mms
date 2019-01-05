/**
 * Project Name: mms-provider-face
 * File Name: DateUtil.java
 * Package Name: com.why.dev.mms.face.util
 * Date: 2018/12/24 12:32 AM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: DateUtil
 * Description: 时间工具类
 * Date: 2018/12/24 12:32 AM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class DateUtil {
    /**
     * dateToString: 日期转字符串
     *
     * @param date 		日期对象
     * @param format 	日期转为字符串时使用的格式
     * @return String 	转换后的日期字符串
     */
    public static String dateToString(Date date, String format) {
        if (format == null || "".equals(format)) {
            return null;
        } else if (date == null) {
            return null;
        } else {
            return (new SimpleDateFormat(format)).format(date);
        }
    }

    /**
     * dateToString: 当前日期转字符串
     *
     * @param format 	日期转为字符串时使用的格式
     * @return String	转换后的当前日期字符串
     */
    public static String dateToString(String format) {
        return dateToString(new Date(), format);
    }
}
