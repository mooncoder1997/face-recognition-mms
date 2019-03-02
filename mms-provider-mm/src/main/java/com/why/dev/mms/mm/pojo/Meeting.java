/**
 * Project Name: face-recognition-mms
 * File Name: Meeting.java
 * Package Name: com.why.dev.mms.mm.pojo
 * Date: 2019-02-27 00:09
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName: Meeting
 * Description: 数据库MM_MEETING表实体类
 * Date: 2019-02-27 00:09
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Meeting {

    private String meetingId;

    private String meetingUserId;

    private String meetingName;

    private String meetingTopic;

    private String meetingRoomName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date meetingDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private Date meetingStartTime;

    @JsonFormat(pattern = "HH:mm:ss")
    private Date meetingEndTime;

    private String meetingRemarks;
}
