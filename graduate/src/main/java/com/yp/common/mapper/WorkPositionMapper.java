package com.yp.common.mapper;

import com.yp.common.pojo.WorkPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//工位操作
public interface WorkPositionMapper {

    //根据主键获取工位信息
    public WorkPosition selectOneWorkPositionById(@Param("workId") int workId);

    //根据座位样式id查看座位
    public List<WorkPosition> selectWorkPositionByworkStyleId(@Param("workStyleId") int workStyleId);

    //根据负责人查看工位
    public List<WorkPosition> selectAllWorkPositionBygroupId(int groupId);

    //根据负责人与工位状态查看工位
    public List<WorkPosition> selectAllWorkPositionBygroupIdandState(@Param("groupId") int groupId, @Param("workState") int workState);

    //根据状态查看所有位置
    public List<WorkPosition> selectWorkPositionByState(@Param("state") int state);

    //根据房间外键查看工位
    public List<WorkPosition> selectAllWorkPositionByroomId(@Param("roomId") int roomId);

    //通过分园区信息选择查看所属园区中所有的工位
    public List<WorkPosition> selectAllWorkPositionBySubparkId(int subParkId);

    //录入工位信息
    public boolean insertOneWorkPosition(WorkPosition workPosition);

    //修改工位信息
    public boolean updateOneWorkPosition(WorkPosition workPosition);

    //删除工位
    public int deleteOneWorkPositionById(@Param("workId") int workId);

    //通过房间外键总和座位数量
    public int selectWorkPositionByRoomId(@Param("roomId") int roomId);
}
