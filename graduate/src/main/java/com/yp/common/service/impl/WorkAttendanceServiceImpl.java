package com.yp.common.service.impl;

import com.yp.common.mapper.WorkAttendanceMapper;
import com.yp.common.pojo.WorkAttendance;
import com.yp.common.service.WorkAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkAttendanceServiceImpl implements WorkAttendanceService {
@Autowired
private WorkAttendanceMapper workAttendanceMapper;
    @Override
    public boolean insertOneWorkAttendance(WorkAttendance workAttendance) {
        return workAttendanceMapper.insertOneWorkAttendance(workAttendance);
    }

    @Override
    public boolean updateOneWorkAttendance(WorkAttendance workAttendance) {
        return workAttendanceMapper.updateOneWorkAttendance(workAttendance);
    }

    @Override
    public int deleteOneWorkAttendanceById(int waId) {
        return workAttendanceMapper.deleteOneWorkAttendanceById(waId);
    }

    @Override
    public int deleteWorkAttendacneByUserId(int userId) {
        return workAttendanceMapper.deleteWorkAttendacneByUserId(userId);
    }
}
