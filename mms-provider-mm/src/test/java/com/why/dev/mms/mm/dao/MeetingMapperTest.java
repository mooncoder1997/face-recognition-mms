package com.why.dev.mms.mm.dao;

import com.why.dev.mms.mm.pojo.Meeting;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Project Name: face-recognition-mms
 * File Name: MeetingMapperTest.java
 * Package Name: com.why.dev.mms.mm.dao
 * Date: 2019-02-27 23:32
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingMapperTest {

    @Resource
    private MeetingMapper meetingMapper;

    @Test
    public void testInsertSelective() {
        Meeting meeting = new Meeting();
        meeting.setMeetingId(UUID.randomUUID().toString().replace("-",""));
        meeting.setMeetingUserId("U000000001");
        meeting.setMeetingName("测试会议1");
        meeting.setMeetingTopic("测试会议主题1");
        meeting.setMeetingRoomName("测试会议室1");
        meeting.setMeetingStartTime(new Date());
        meeting.setMeetingEndTime(new Date());
        int result = meetingMapper.insertSelective(meeting);
        Assert.assertEquals(1, result);
        log.info("[MeetingMapperTest] testInsertSelective 成功插入了" + result + "条会议信息");
    }

    @Test
    public void testDeleteByPrimaryKey() {
        int result = meetingMapper.deleteByPrimaryKey("15d5a80392984b40ba0a8c09b2756a1a");
        Assert.assertEquals(1, result);
        log.info("[MeetingMapperTest] testDeleteByPrimaryKey 成功删除了" + result + "条会议信息");
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        Meeting meeting = new Meeting();
        meeting.setMeetingId("4a57e196f6ee4a00a0bc5664870424b8");
        meeting.setMeetingTopic("测试会议主题11");
        int result = meetingMapper.updateByPrimaryKeySelective(meeting);
        Assert.assertEquals(1, result);
        log.info("[MeetingMapperTest] testInsertSelective 成功更新了" + result + "条会议信息");
    }

    @Test
    public void testSelectByPrimaryKey() {
        Meeting meeting = meetingMapper.selectByPrimaryKey("4a57e196f6ee4a00a0bc5664870424b8");
        if (meeting == null) {
            log.info("[MeetingMapperTest] testSelectByPrimaryKey 查询会议信息失败" );
        }
        Assert.assertNotNull(meeting);
        log.info("[MeetingMapperTest] testSelectByPrimaryKey 成功查到1条会议信息: " + meeting.toString());
    }

    @Test
    public void testFindAllMeeting() {
        List<Meeting> meetingList = meetingMapper.findAllMeeting();
        if (meetingList == null) {
            log.info("[MeetingMapperTest] testFindAllMeeting 查询会议信息失败" );
        }
        Assert.assertNotNull(meetingList);
        log.info("[MeetingMapperTest] testFindAllMeeting 成功查到" + meetingList.size() + "条会议信息");
    }
}