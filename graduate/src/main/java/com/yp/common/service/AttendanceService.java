package com.yp.common.service;

import com.yp.common.pojo.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttendanceService {
    //获取所有考勤设置
    public List<Attendance> selectAllAttendance();

    //录入考勤
    public boolean insertAttendance(Attendance attendance);

    //修改考勤配置
    public boolean updateAttendance(Attendance attendance);

    //删除考勤配置根据id
    public int delectOneAttendanceByid(@Param(value="attendanceId") int attendanceId);

    //删除所有考勤配置
    public int delectAllAttendance();

    //根据用户ID查看考勤设置
    public List<Attendance> selectAttendanceByUserId(@Param(value="userId") int userId);

    //根据主键查看考勤详情
    public Attendance selectOneAttendanceById(@Param(value="attendanceId") int attendanceId);
}
