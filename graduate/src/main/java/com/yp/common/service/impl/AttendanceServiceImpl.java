package com.yp.common.service.impl;

import com.yp.common.mapper.AttendanceMapper;
import com.yp.common.pojo.Attendance;
import com.yp.common.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AttendanceServiceImpl implements AttendanceService {
@Autowired
private AttendanceMapper attendanceMapper;
    @Override
    public Attendance selectOneAttendanceById(int attendanceId) {
        return attendanceMapper.selectOneAttendanceById(attendanceId);
    }
    @Override
    public List<Attendance> selectAllAttendance() {
        return attendanceMapper.selectAllAttendance();
    }

    @Override
    public boolean insertAttendance(Attendance attendance) {
        return attendanceMapper.insertAttendance(attendance);
    }

    @Override
    public boolean updateAttendance(Attendance attendance) {
        return attendanceMapper.updateAttendance(attendance);
    }

    @Override
    public int delectOneAttendanceByid(int attendanceId) {
        return attendanceMapper.delectOneAttendanceByid(attendanceId);
    }

    @Override
    public int delectAllAttendance() {
        return attendanceMapper.delectAllAttendance();
    }

    @Override
    public List<Attendance> selectAttendanceByUserId(int userId) {
        return attendanceMapper.selectAttendanceByUserId(userId);
    }


}
