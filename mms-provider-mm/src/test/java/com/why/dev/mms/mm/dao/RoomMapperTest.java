package com.why.dev.mms.mm.dao;

import com.why.dev.mms.mm.pojo.Room;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project Name: face-recognition-mms
 * File Name: RoomMapperTest.java
 * Package Name: com.why.dev.mms.mm.dao
 * Date: 2019-02-27 23:32
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomMapperTest {

    @Resource
    private RoomMapper roomMapper;

    @Test
    public void testInsertSelective() {
        Room room = new Room();
        room.setRoomName("测试会议室1");
        room.setRoomLocation("L1");
        room.setRoomPeople(1);
        int result = roomMapper.insertSelective(room);
        Assert.assertEquals(1, result);
        log.info("[RoomMapperTest] testInsertSelective 成功插入了" + result + "条会议室信息");
    }

    @Test
    public void testDeleteByPrimaryKey() {
        int result = roomMapper.deleteByPrimaryKey("测试会议室1");
        Assert.assertEquals(1, result);
        log.info("[RoomMapperTest] testDeleteByPrimaryKey 成功删除了" + result + "条会议室信息");
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        Room room = new Room();
        room.setRoomName("测试会议室1");
        room.setRoomPeople(11);
        int result = roomMapper.updateByPrimaryKeySelective(room);
        Assert.assertEquals(1, result);
        log.info("[RoomMapperTest] testInsertSelective 成功更新了" + result + "条会议室信息");
    }

    @Test
    public void testSelectByPrimaryKey() {
        Room room = roomMapper.selectByPrimaryKey("测试会议室1");
        if (room == null) {
            log.info("[RoomMapperTest] testSelectByPrimaryKey 查询会议室信息失败" );
        }
        Assert.assertNotNull(room);
        log.info("[RoomMapperTest] testSelectByPrimaryKey 成功查到1条会议室信息: " + room.toString());
    }

    @Test
    public void testFindAllRoom() {
        List<Room> roomList = roomMapper.findAllRoom();
        if (roomList == null) {
            log.info("[RoomMapperTest] testFindAllRoom 查询会议室信息失败" );
        }
        Assert.assertNotNull(roomList);
        log.info("[RoomMapperTest] testFindAllRoom 成功查到" + roomList.size() + "条会议室信息");
    }
}