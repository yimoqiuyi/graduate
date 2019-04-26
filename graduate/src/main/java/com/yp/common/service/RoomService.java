package com.yp.common.service;

import com.yp.common.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomService {
    //根据房间id选择房间
    public Room selectOneRoomById(@Param("roomId") int roomId);

    //根据分园区查看房间
    public List<Room> selectAllRoomBysubParkId(@Param("subParkId") int subParkId);

    //录入房间
    public boolean insertOneRoom(Room room);

    //修改房间
    public boolean updateOneRoom(Room room);

    //删除房间根据id
    public int deleteOneRoomById(@Param("roomId") int roomId);

    //通过buidingId查看房间
    public List<Room> selectRoomByBuildId(@Param("buildId") int buildId);

    //分页查看
    public List<Room> seletctRoomByLimit(@Param("subParkId") int subParkId, @Param("page") int page, @Param("limit") int limit);

    //删出房间根据buildId
    public int deleteOneRoomBybuildId(@Param("buildId") int buildId);

    //通过总园区generalParkId查看房间
    public List<Room> selectRoomBygeneralParkId(@Param("generalParkId") int generalParkId);

    //通过assetId查询房间
    public Room selectRoomByassetId(@Param("assetId") int assetId);

    //通过分园区外键统计房间数量
    public int selectRoomBySubParkId(@Param("subParkId") int subParkId);

    public int selectRoomNumberByBuildId(@Param("buildId") int buildId);
}
