/**
 * Project Name: face-recognition-mms
 * File Name: RoomMapper
 * Package Name: com.why.dev.mms.mm.dao
 * Date: 2019-02-27 00:13
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.dao;

import com.why.dev.mms.mm.pojo.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: RoomMapper
 * Description: TODO
 * Date: 2019-02-27 00:13
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Mapper
public interface RoomMapper {

    int insertSelective(Room room);

    int deleteByPrimaryKey(String roomName);

    int updateByPrimaryKeySelective(Room room);

    Room selectByPrimaryKey(String roomName);

    List<Room> findAllRoom();
}
