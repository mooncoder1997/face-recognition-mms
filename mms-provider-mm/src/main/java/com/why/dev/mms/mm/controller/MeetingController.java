/**
 * Project Name: face-recognition-mms
 * File Name: MeetingController.java
 * Package Name: com.why.dev.mms.mm.controller
 * Date: 2019-02-28 23:55
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.controller;

import com.why.dev.mms.mm.dto.QueryAvaliableTimeDto;
import com.why.dev.mms.mm.dto.ResponseResult;
import com.why.dev.mms.mm.pojo.Meeting;
import com.why.dev.mms.mm.service.MeetingService;
import com.why.dev.mms.mm.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: MeetingController
 * Description: 会议信息处理Controller
 * Date: 2019-02-28 23:55
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    /**
     * addMeeting: 预定会议
     *
     * @param meeting
     * @return
     */
    @RequestMapping(value = "meeting", method = RequestMethod.POST)
    public ResponseResult addMeeting(@RequestBody Meeting meeting) {
        log.info("[MeetingController] addMeeting() 进入预定会议方法");
        return meetingService.addMeeting(meeting);
    }

    /**
     * deleteMeeting: 删除会议
     *
     * @param meetingId
     * @return
     */
    @RequestMapping(value = "meeting/{meetingId}", method = RequestMethod.DELETE)
    public ResponseResult deleteMeeting(@PathVariable("meetingId") String meetingId) {
        log.info("[MeetingController] deleteRoom() 进入删除会议方法");
        return meetingService.deleteMeeting(meetingId);
    }

    /**
     * updateMeeting: 更新会议
     *
     * @param meeting
     * @return
     */
    @RequestMapping(value = "meeting", method = RequestMethod.PUT)
    public ResponseResult updateMeeting(@RequestBody Meeting meeting) {
        log.info("[MeetingController] updateRoom() 进入更新会议方法");
        return meetingService.updateMeeting(meeting);
    }

    /**
     * queryOne: 查询一个会议
     *
     * @param meetingId
     * @return
     */
    @RequestMapping(value = "meeting/{meetingId}", method = RequestMethod.GET)
    public ResponseResult queryOne(@PathVariable("meetingId") String meetingId) {
        log.info("[MeetingController] queryOne() 进入查询会议方法");
        return meetingService.queryMeeting(meetingId);
    }

    /**
     * queryAll: 查询所有会议
     *
     * @return
     */
    @RequestMapping(value = "meeting", method = RequestMethod.GET)
    public ResponseResult queryAll() {
        log.info("[MeetingController] queryAll() 进入查询所有会议方法");
        return meetingService.queryAllMeeting();
    }

    @RequestMapping(value = "avaliable", method = RequestMethod.GET)
    public ResponseResult queryAT(String roomName, String roomDate) {
        log.info("[MeetingController] queryAT() 进入查询可预定时段方法");
        QueryAvaliableTimeDto queryAvaliableTimeDto = new QueryAvaliableTimeDto(roomName, DateUtil.stringToDate(roomDate));
        return meetingService.queryAvaliableTime(queryAvaliableTimeDto);
    }
}
