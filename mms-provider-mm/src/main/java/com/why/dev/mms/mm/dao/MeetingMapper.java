/**
 * Project Name: face-recognition-mms
 * File Name: MeetingMapper.java
 * Package Name: com.why.dev.mms.mm.dao
 * Date: 2019-02-27 00:13
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.dao;

import com.why.dev.mms.mm.dto.QueryAvaliableTimeDto;
import com.why.dev.mms.mm.pojo.Meeting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: MeetingMapper
 * Description: 会议信息映射接口
 * Date: 2019-02-27 00:13
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Mapper
public interface MeetingMapper {

    int insertSelective(Meeting meeting);

    int deleteByPrimaryKey(String meetingId);

    int updateByPrimaryKeySelective(Meeting meeting);

    Meeting selectByPrimaryKey(String meetingId);

    List<Meeting> selectByRoomNameAndDate(QueryAvaliableTimeDto queryAvaliableTimeDto);

    List<Meeting> findAllMeeting();
}
