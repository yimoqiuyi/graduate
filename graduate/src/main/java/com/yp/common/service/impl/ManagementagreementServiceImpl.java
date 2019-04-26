package com.yp.common.service.impl;

import com.yp.common.mapper.ManagementagreementMapper;
import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.Managementagreement;
import com.yp.common.service.ManagementagreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class ManagementagreementServiceImpl implements ManagementagreementService {
@Autowired
private ManagementagreementMapper managementagreementMapper;
    @Override
    public Managementagreement selectOneManagementagreementByid(int managementId) {
        return managementagreementMapper.selectOneManagementagreementByid(managementId);
    }

    @Override
    public List<Managementagreement> selectAllManagementagreementBygroupId(int groupId) {
        return managementagreementMapper.selectAllManagementagreementBygroupId(groupId);
    }

    @Override
    public List<Managementagreement> selectAllManagementagreementBysubParkId(int subParkId) {
        return managementagreementMapper.selectAllManagementagreementBysubParkId(subParkId);
    }

    @Override
    public List<Managementagreement> selectAllManagementagreementBygeneralParkId(int generalParkId) {
        return managementagreementMapper.selectAllManagementagreementBygeneralParkId(generalParkId);
    }

    @Override
    public List<Managementagreement> selectAllManagementagreementByTime(Dateutile dateutile) {
        return managementagreementMapper.selectAllManagementagreementByTime(dateutile);
    }

    @Override
    public List<Managementagreement> selectAllManagementagreementBytimeAndsubParkId(Dateutile dateutile) {
        return managementagreementMapper.selectAllManagementagreementBytimeAndsubParkId(dateutile);
    }

    @Override
    public List<Managementagreement> selectManagementagreementByMap(Map<String, Object> map) {
        return managementagreementMapper.selectManagementagreementByMap(map);
    }

    @Override
    public List<Managementagreement> selectManagementagreementByCondition(Map<String, Object> map) {
        return managementagreementMapper.selectManagementagreementByCondition(map);
    }

    @Override
    public List<Managementagreement> selectAllManagementagreementByTimeAndgeneralParkId(Dateutile dateutile) {
        return managementagreementMapper.selectAllManagementagreementByTimeAndgeneralParkId(dateutile);
    }

     @Override
    public List<Managementagreement> selectAllManagementagreement() {
        return managementagreementMapper.selectAllManagementagreement();
    }

    @Override
    public boolean insertOneManagementagreement(Managementagreement managementagreement) {
        return managementagreementMapper.insertOneManagementagreement(managementagreement);
    }

    @Override
    public boolean updateOneManagementagreement(Managementagreement managementagreement) {
        return managementagreementMapper.updateOneManagementagreement(managementagreement);
    }

    @Override
    public int delectOneManagementagreement(int managementId) {
        return managementagreementMapper.delectOneManagementagreement(managementId);
    }
}
