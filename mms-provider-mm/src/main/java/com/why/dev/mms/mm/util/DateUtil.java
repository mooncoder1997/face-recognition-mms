/**
 * Project Name: face-recognition-mms
 * File Name: DateUtil
 * Package Name: com.why.dev.mms.mm.util
 * Date: 2019-03-02 12:13
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.util;

import org.springframework.beans.factory.annotation.Value;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: DateUtil
 * Description: TODO
 * Date: 2019-03-02 12:13
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
public class DateUtil {

    @Value("${mm.meeting.start}")
    private static String startTime;

    @Value("${mm.meeting.end}")
    private static String endTime;

    /**
     * stringToDate: 日期字符串转Date
     *
     * @param date
     * @return
     */
    public static Date stringToDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * dateToTime: 去掉日期只保留时间
     *
     * @param date  yyyy-MM-dd HH:mm:ss
     * @return      HH:mm:ss
     */
    public static Date dateToTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String dateTemp = simpleDateFormat.format(date);
        try {
            return simpleDateFormat.parse(dateTemp);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * startTime: 获取会议开始预定时间
     *
     * @return
     */
    public static Date startTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            return simpleDateFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * endTime: 获取会议结束时间
     *
     * @return
     */
    public static Date endTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            return simpleDateFormat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
