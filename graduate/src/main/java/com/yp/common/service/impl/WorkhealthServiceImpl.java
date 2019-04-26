package com.yp.common.service.impl;

import com.yp.common.mapper.WorkhealthMapper;
import com.yp.common.pojo.Workhealth;
import com.yp.common.service.WorkhealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkhealthServiceImpl implements WorkhealthService {
@Autowired
private WorkhealthMapper workhealthMapper;
    @Override
    public boolean insertOneWorkhealth(Workhealth workhealth) {
        return workhealthMapper.insertOneWorkhealth(workhealth);
    }

    @Override
    public boolean updateOneWorkhealth(Workhealth workhealth) {
        return workhealthMapper.updateOneWorkhealth(workhealth);
    }

    @Override
    public int deleteOneWorkhealthById(int whId) {
        return workhealthMapper.deleteOneWorkhealthById(whId);
    }

    @Override
    public int deleteWorkHealthByUserId(int userId) {
        return workhealthMapper.deleteWorkHealthByUserId(userId);
    }


}
