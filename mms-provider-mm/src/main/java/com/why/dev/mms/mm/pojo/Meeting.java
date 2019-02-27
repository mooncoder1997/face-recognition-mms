/**
 * Project Name: face-recognition-mms
 * File Name: Meeting
 * Package Name: com.why.dev.mms.mm.pojo
 * Date: 2019-02-27 00:09
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName: Meeting
 * Description: TODO
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

    private Date meetingStartTime;

    private Date meetingEndTime;

    private String meetingRemarks;
}
