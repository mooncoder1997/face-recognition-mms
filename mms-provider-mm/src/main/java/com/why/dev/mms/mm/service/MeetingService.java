/**
 * Project Name: face-recognition-mms
 * File Name: MeetingService.java
 * Package Name: com.why.dev.mms.mm.service
 * Date: 2019-02-28 00:33
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.service;

import com.why.dev.mms.mm.common.StatusCode;
import com.why.dev.mms.mm.dao.MeetingMapper;
import com.why.dev.mms.mm.dto.QueryAvaliableTimeDto;
import com.why.dev.mms.mm.dto.ResponseResult;
import com.why.dev.mms.mm.pojo.Meeting;
import com.why.dev.mms.mm.util.DateUtil;
import com.why.dev.mms.mm.vo.AvaliableTimeVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * ClassName: MeetingService
 * Description: 会议信息业务逻辑实现
 * Date: 2019-02-28 00:33
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
@Service
public class MeetingService {

    @Resource
    private MeetingMapper meetingMapper;

    /**
     * addUser: 预定会议
     *
     * @param meeting
     * @return  成功: {true, "预定会议成功", 201}
     *          失败: {false, "参数为空", 400}, {false, "预定会议失败", 500}, {false, "会议已存在", 500},
     */
    public ResponseResult addMeeting(Meeting meeting) {
        log.info("[MeetingService] addMeeting() 进入预定会议方法");
        if (meeting == null) {
            log.info("[MeetingService] addMeeting() 参数为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        meeting.setMeetingId(UUID.randomUUID().toString().replace("-",""));
        try {
            if (meetingMapper.insertSelective(meeting) == 0) {
                log.info("[MeetingService] addMeeting() 预定会议执行失败");
                return new ResponseResult(false, "预定会议失败", StatusCode.OPERATIONERROR);
            }
            log.info("[MeetingService] addMeeting() 预定会议成功: " + meeting.toString());
            return new ResponseResult(true, "预定会议成功", StatusCode.SUCCESS_POST_PUT_PATCH);
        } catch (DuplicateKeyException e) {
            log.info("[MeetingService] addMeeting() 预定会议出错，违反唯一约束");
            return new ResponseResult(false, "会议已存在", StatusCode.ERROR_INVALID_RREQUEST);
        }
    }

    /**
     *deleteUser: 删除会议
     *
     * @param meetingId
     * @return  成功: {true, "删除会议成功", 204}
     *          失败: {false, "参数为空", 400}, {false, "会议不存在", 410}
     */
    public ResponseResult deleteMeeting(String meetingId) {
        log.info("[MeetingService] deleteMeeting() 进入删除会议方法");
        if (StringUtils.isBlank(meetingId)) {
            log.info("[MeetingService] deleteMeeting() roomName为空，不能删除会议");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        int result = meetingMapper.deleteByPrimaryKey(meetingId);
        if (result == 0) {
            log.info("[MeetingService] deleteMeeting() 会议不存在，meetingId: " + meetingId);
            return new ResponseResult(false, "会议不存在", StatusCode.ERROR_GONE);
        }
        log.info("[MeetingService] deleteMeeting() 删除会议成功: " + meetingId);
        return new ResponseResult(true, "删除会议成功", StatusCode.SUCCESS_DELETE);
    }

    /**
     * updateUser: 更新会议
     *
     * @param meeting
     * @return  成功: {true, "更新会议室成功", 201}
     *          失败: {false, "参数为空", 400}, {false, "更新会议室失败", 500}
     */
    public ResponseResult updateMeeting(Meeting meeting) {
        log.info("[MeetingService] updateMeeting() 进入更新会议方法");
        if (meeting == null) {
            log.info("[MeetingService] updateMeeting() 参数为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        if (meetingMapper.updateByPrimaryKeySelective(meeting) == 0) {
            log.info("[MeetingService] updateMeeting() 更新会议执行失败");
            return new ResponseResult(false, "更新会议失败", StatusCode.OPERATIONERROR);
        }
        log.info("[MeetingService] updateMeeting() 更新会议成功: " + meeting.toString());
        return new ResponseResult(true, "更新会议成功", StatusCode.SUCCESS_POST_PUT_PATCH);
    }

    /**
     * queryUser: 查询会议
     *
     * @param meetingId
     * @return  成功: {faceInfoVO, true, "查询会议室成功", 200}
     *          失败: {false, "参数为空", 400}, {false, "会议不存在", 410}
     */
    public ResponseResult queryMeeting(String meetingId) {
        log.info("[MeetingService] queryMeeting() 进入查询会议方法");
        if (StringUtils.isBlank(meetingId)) {
            log.info("[MeetingService] queryMeeting() meetingId为空，不能查询会议");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        Meeting meeting = meetingMapper.selectByPrimaryKey(meetingId);
        if (meeting == null) {
            log.info("[MeetingService] queryMeeting() 会议不存在，meetingId: " + meetingId);
            return new ResponseResult(false, "会议不存在", StatusCode.ERROR_GONE);
        }
        log.info("[MeetingService] queryMeeting() 查询会议成功: " + meeting.toString());
        return new ResponseResult(meeting, true, "查询会议成功", StatusCode.SUCCESS_GET);
    }

    /**
     * queryAllUsers: 查询所有会议
     *
     * @return  成功: {userInfoVOList, true, "查询会议成功", 200}
     *          失败: {false, "没有查到会议", 410}
     */
    public ResponseResult queryAllMeeting() {
        log.info("[MeetingService] queryAllMeeting() 进入查询所有会议方法");
        List<Meeting> meetingList = meetingMapper.findAllMeeting();
        if (CollectionUtils.isEmpty(meetingList)) {
            log.info("[MeetingService] queryAllMeeting() 没有查到会议");
            return new ResponseResult(false, "没有查到会议", StatusCode.ERROR_GONE);
        }
        log.info("[MeetingService] queryAllMeeting() 查询所有会议成功，共查到" + meetingList.size() + "个会议");
        return new ResponseResult(meetingList, true, "查询会议成功", StatusCode.SUCCESS_GET);
    }

    /**
     * queryAvaliableTime: 查询可预定时段
     *
     * @param queryAvaliableTimeDto
     * @return
     */
    public ResponseResult queryAvaliableTime(QueryAvaliableTimeDto queryAvaliableTimeDto) {
        List<AvaliableTimeVO> avaliableTimeVOList = new ArrayList<>();

        log.info("[MeetingService] queryAllMeeting() 进入查询可预定会议时段方法");
        try {
            Optional.ofNullable(queryAvaliableTimeDto)
                    .map(QueryAvaliableTimeDto::getRoomName).orElseThrow(Exception::new);
            Optional.of(queryAvaliableTimeDto)
                    .map(QueryAvaliableTimeDto::getRoomDate).orElseThrow(Exception::new);
        } catch (Exception e) {
            log.info("[MeetingService] queryAvaliableTime() queryAvaliableTimeDto为空，不能查询可预定时段");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }

        try {
            List<Meeting> meetingList = Optional.ofNullable(meetingMapper.selectByRoomNameAndDate(queryAvaliableTimeDto))
                    .orElseThrow(Exception::new);
            log.info("[MeetingService] queryAvaliableTime() DB中取到的会议列表: " + meetingList.toString());
            // 根据会议开始时间字段对DB中取到的已预定会议列表从早到晚排序
            meetingList.sort((m1, m2) -> {
                if (m1.getMeetingStartTime().before(m2.getMeetingStartTime())) {return -1;}
                else if (m1.getMeetingStartTime().after(m2.getMeetingStartTime())) {return 1;}
                else {return 0;}
            });
            log.info("[MeetingService] queryAvaliableTime() DB排序后的会议列表: " + meetingList.toString());

//            meetingList.forEach(meeting -> {
//                meeting.setMeetingStartTime(DateUtil.dateToTime(meeting.getMeetingStartTime()));
//                meeting.setMeetingEndTime(DateUtil.dateToTime(meeting.getMeetingEndTime()));
//            });
//            log.info("[MeetingService] queryAvaliableTime() 时间处理后的会议列表: " + meetingList.toString());

            if (meetingList.size() > 0) {
                if (DateUtil.startTime().before(meetingList.get(0).getMeetingStartTime())) {
                    avaliableTimeVOList.add(new AvaliableTimeVO(DateUtil.startTime(), meetingList.get(0).getMeetingStartTime()));
                }
                for (int i = 0; i < meetingList.size() - 1; i++) {
                    if (meetingList.get(i).getMeetingEndTime().before(meetingList.get(i + 1).getMeetingStartTime())) {
                        avaliableTimeVOList.add(new AvaliableTimeVO(meetingList.get(i).getMeetingEndTime(), meetingList.get(i + 1).getMeetingStartTime()));
                    }
                }
                if (DateUtil.endTime().after(meetingList.get(meetingList.size() - 1).getMeetingEndTime())) {
                    avaliableTimeVOList.add(new AvaliableTimeVO(meetingList.get(meetingList.size() - 1).getMeetingEndTime(), DateUtil.endTime()));
                }
            }
        } catch (Exception e) {
            log.info("[MeetingService] queryAvaliableTime() 没有查到会议");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        log.info("[MeetingService] queryAvaliableTime() 查询可预定时段成功: " + avaliableTimeVOList.toString());
        return new ResponseResult(avaliableTimeVOList, true, "查询可预定时段成功", StatusCode.SUCCESS_GET);
    }
}
