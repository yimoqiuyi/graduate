package com.yp.common.service.impl;

import com.yp.common.mapper.RoomMapper;
import com.yp.common.pojo.Room;
import com.yp.common.service.RoomService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Room selectOneRoomById(int roomId) {
        return roomMapper.selectOneRoomById(roomId);
    }

    @Override
    public List<Room> selectAllRoomBysubParkId(int subParkId) {
        return roomMapper.selectAllRoomBysubParkId(subParkId);
    }

    @Override
    public boolean insertOneRoom(Room room) {
        return roomMapper.insertOneRoom(room);
    }

    @Override
    public boolean updateOneRoom(Room room) {
        return roomMapper.updateOneRoom(room);
    }

    @Override
    public int deleteOneRoomById(int roomId) {
        return roomMapper.deleteOneRoomById(roomId);
    }

    @Override
    public int deleteOneRoomBybuildId(int buildId) {
        return roomMapper.deleteOneRoomBybuildId(buildId);
    }

    @Override
    public List<Room> selectRoomByBuildId(int buildId) {
        return roomMapper.selectRoomByBuildId(buildId);
    }

    @Override
    public List<Room> seletctRoomByLimit(int subParkId, int page, int limit) {
        return  roomMapper.seletctRoomByLimit(subParkId,page,limit);
    }

    @Override
    public List<Room> selectRoomBygeneralParkId(int generalParkId) {
        return roomMapper.selectRoomBygeneralParkId(generalParkId);
    }

    //通过分园区外键统计房间数量
    public int selectRoomBySubParkId(int subParkId) {
        return roomMapper.selectRoomBySubParkId(subParkId);
    }

    @Override
    public int selectRoomNumberByBuildId(int buildId) {
        return roomMapper.selectRoomNumberByBuildId(buildId);
    }

    @Override
    public Room selectRoomByassetId(int assetId) {
        return roomMapper.selectRoomByassetId(assetId);
    }
}
