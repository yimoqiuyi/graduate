package com.yp.common.service;

import com.yp.common.pojo.WorkAttendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkAttendanceService {

    public List<WorkAttendance> selectAllWorkAttendanceByAttendanceId(@Param("attendanceId") int attendanceId);
    //用户-考勤录入
    public boolean insertOneWorkAttendance(WorkAttendance workAttendance);

    //用户-考勤修改
    public boolean updateOneWorkAttendance(WorkAttendance workAttendance);

    //用户-考勤删除
    public int deleteOneWorkAttendanceById(@Param("waId") int waId);

    //根据userId删除用户-考勤
    public int deleteWorkAttendacneByUserId(@Param("userId") int userId);
}
