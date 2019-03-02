/**
 * Project Name: face-recognition-mms
 * File Name: RoomController.java
 * Package Name: com.why.dev.mms.mm.controller
 * Date: 2019-02-28 23:36
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.controller;

import com.why.dev.mms.mm.dto.ResponseResult;
import com.why.dev.mms.mm.pojo.Room;
import com.why.dev.mms.mm.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: RoomController
 * Description: 会议室信息处理Controller
 * Date: 2019-02-28 23:36
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/room/")
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * addRoom: 添加会议室
     *
     * @param room
     * @return
     */
    @RequestMapping(value = "room", method = RequestMethod.POST)
    public ResponseResult addRoom(@RequestBody Room room) {
        log.info("[RoomController] addRoom() 进入添加用户信息方法");
        return roomService.addRoom(room);
    }

    /**
     * deleteRoom: 删除会议室
     *
     * @param roomName
     * @return
     */
    @RequestMapping(value = "room/{roomName}", method = RequestMethod.DELETE)
    public ResponseResult deleteRoom(@PathVariable("roomName") String roomName) {
        log.info("[RoomController] deleteRoom() 进入删除会议室方法");
        return roomService.deleteRoom(roomName);
    }

    /**
     * updateRoom: 更新会议室
     *
     * @param room
     * @return
     */
    @RequestMapping(value = "room", method = RequestMethod.PUT)
    public ResponseResult updateRoom(@RequestBody Room room) {
        log.info("[RoomController] updateRoom() 进入更新会议室方法");
        return roomService.updateRoom(room);
    }

    /**
     * queryOne: 查询一个会议室
     *
     * @param roomName
     * @return
     */
    @RequestMapping(value = "room/{roomName}", method = RequestMethod.GET)
    public ResponseResult queryOne(@PathVariable("roomName") String roomName) {
        log.info("[RoomController] queryOne() 进入查询会议室方法");
        return roomService.queryRoom(roomName);
    }

    /**
     * queryAll: 查询所有会议室
     *
     * @return
     */
    @RequestMapping(value = "room", method = RequestMethod.GET)
    public ResponseResult queryAll() {
        log.info("[RoomController] queryAll() 进入查询所有会议室方法");
        return roomService.queryAllRoom();
    }
}
