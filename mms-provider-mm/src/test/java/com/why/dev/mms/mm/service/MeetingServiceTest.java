package com.why.dev.mms.mm.service;

import com.why.dev.mms.mm.dto.QueryAvaliableTimeDto;
import com.why.dev.mms.mm.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Project Name: face-recognition-mms
 * File Name: MeetingServiceTest
 * Package Name: com.why.dev.mms.mm.service
 * Date: 2019-03-02 00:37
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingServiceTest {

    @Autowired
    private MeetingService meetingService;

    @Test
    public void queryAvaliableTime() {
        QueryAvaliableTimeDto queryAvaliableTimeDto = new QueryAvaliableTimeDto();
        queryAvaliableTimeDto.setRoomName("MeetingRoom1");
        queryAvaliableTimeDto.setRoomDate(DateUtil.stringToDate("2019-03-02"));
        meetingService.queryAvaliableTime(queryAvaliableTimeDto);
    }
}