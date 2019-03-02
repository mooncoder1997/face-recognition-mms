/**
 * Project Name: face-recognition-mms
 * File Name: RoomService.java
 * Package Name: com.why.dev.mms.mm.service
 * Date: 2019-02-28 00:33
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm.service;

import com.why.dev.mms.mm.common.StatusCode;
import com.why.dev.mms.mm.dao.RoomMapper;
import com.why.dev.mms.mm.dto.ResponseResult;
import com.why.dev.mms.mm.pojo.Room;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: RoomService
 * Description:会议室信息业务逻辑实现
 * Date: 2019-02-28 00:33
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@Slf4j
@Service
public class RoomService {

    @Resource
    private RoomMapper roomMapper;

    /**
     * addUser: 添加会议室
     *
     * @param room
     * @return  成功: {true, "添加会议室成功", 201}
     *          失败: {false, "参数为空", 400}, {false, "添加会议室失败", 500}, {false, "会议室已存在", 500},
     */
    public ResponseResult addRoom(Room room) {
        log.info("[RoomService] addRoom() 进入添加会议室方法");
        if (room == null) {
            log.info("[RoomService] addRoom() 参数为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        try {
            if (roomMapper.insertSelective(room) == 0) {
                log.info("[RoomService] addRoom() 添加会议室执行失败");
                return new ResponseResult(false, "添加会议室失败", StatusCode.OPERATIONERROR);
            }
            log.info("[RoomService] addRoom() 添加会议室成功: " + room.toString());
            return new ResponseResult(true, "添加会议室成功", StatusCode.SUCCESS_POST_PUT_PATCH);
        } catch (DuplicateKeyException e) {
            log.info("[RoomService] addRoom() 添加会议室出错，违反唯一约束");
            return new ResponseResult(false, "会议室已存在", StatusCode.ERROR_INVALID_RREQUEST);
        }
    }

    /**
     *deleteUser: 删除会议室
     *
     * @param roomName
     * @return  成功: {true, "删除用户信息成功", 204}
     *          失败: {false, "参数为空", 400}, {false, "用户不存在", 410}
     */
    public ResponseResult deleteRoom(String roomName) {
        log.info("[RoomService] deleteRoom() 进入删除会议室方法");
        if (StringUtils.isBlank(roomName)) {
            log.info("[RoomService] deleteRoom() roomName为空，不能删除会议室");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        int result = roomMapper.deleteByPrimaryKey(roomName);
        if (result == 0) {
            log.info("[RoomService] deleteRoom() 会议室不存在，roomName: " + roomName);
            return new ResponseResult(false, "会议室不存在", StatusCode.ERROR_GONE);
        }
        log.info("[RoomService] deleteRoom() 删除会议室成功: " + roomName);
        return new ResponseResult(true, "删除会议室成功", StatusCode.SUCCESS_DELETE);
    }

    /**
     * updateUser: 更新会议室
     *
     * @param room
     * @return  成功: {true, "更新会议室成功", 201}
     *          失败: {false, "参数为空", 400}, {false, "更新会议室失败", 500}
     */
    public ResponseResult updateRoom(Room room) {
        log.info("[RoomService] updateRoom() 进入更新会议室方法");
        if (room == null) {
            log.info("[RoomService] updateRoom() 参数为空");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        if (roomMapper.updateByPrimaryKeySelective(room) == 0) {
            log.info("[RoomService] updateRoom() 更新会议室执行失败");
            return new ResponseResult(false, "更新会议室失败", StatusCode.OPERATIONERROR);
        }
        log.info("[RoomService] updateRoom() 更新会议室成功: " + room.toString());
        return new ResponseResult(true, "更新会议室成功", StatusCode.SUCCESS_POST_PUT_PATCH);
    }

    /**
     * queryUser: 查询会议室
     *
     * @param roomName
     * @return  成功: {faceInfoVO, true, "查询会议室成功", 200}
     *          失败: {false, "参数为空", 400}, {false, "会议室不存在", 410}
     */
    public ResponseResult queryRoom(String roomName) {
        log.info("[RoomService] queryRoom() 进入查询会议室方法");
        if (StringUtils.isBlank(roomName)) {
            log.info("[RoomService] queryRoom() roomName为空，不能查询会议室");
            return new ResponseResult(false, "参数为空", StatusCode.ERROR_INVALID_RREQUEST);
        }
        Room room = roomMapper.selectByPrimaryKey(roomName);
        if (room == null) {
            log.info("[RoomService] queryRoom() 会议室不存在，roomName: " + roomName);
            return new ResponseResult(false, "会议室不存在", StatusCode.ERROR_GONE);
        }
        log.info("[RoomService] queryRoom() 查询会议室成功: " + room.toString());
        return new ResponseResult(room, true, "查询会议室成功", StatusCode.SUCCESS_GET);
    }

    /**
     * queryAllUsers: 查询所有会议室
     *
     * @return  成功: {userInfoVOList, true, "查询会议室成功", 200}
     *          失败: {false, "没有查到会议室", 410}
     */
    public ResponseResult queryAllRoom() {
        log.info("[RoomService] queryAllRoom() 进入查询所有会议室方法");
        List<Room> roomList = roomMapper.findAllRoom();
        if (CollectionUtils.isEmpty(roomList)) {
            log.info("[RoomService] queryAllRoom() 没有查到会议室");
            return new ResponseResult(false, "没有查到会议室", StatusCode.ERROR_GONE);
        }
        log.info("[RoomService] queryAllRoom() 查询所有会议室成功，共查到" + roomList.size() + "个会议室");
        return new ResponseResult(roomList, true, "查询会议室成功", StatusCode.SUCCESS_GET);
    }
}
