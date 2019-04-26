package com.yp.common.service.impl;

import com.yp.common.mapper.SubParkMapper;
import com.yp.common.pojo.SubPark;
import com.yp.common.service.SubParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SubParkServiceImpl implements SubParkService {
@Autowired
private SubParkMapper subParkMapper;
    @Override
    public SubPark selectOneSubParkById(int subParkId) {
        return subParkMapper.selectOneSubParkById(subParkId);
    }

    @Override
    public List<SubPark> selectAllSubParkBygeneralParkId(int generalParkId) {
        return subParkMapper.selectAllSubParkBygeneralParkId(generalParkId);
    }

    @Override
    public  SubPark selectSubparkByUserId(int userId) {
        return subParkMapper.selectSubparkByUserId(userId);
    }

    @Override
    public boolean insertOneSubPark(SubPark subPark) {
        return subParkMapper.insertOneSubPark(subPark);
    }

    @Override
    public boolean updateOneSubPark(SubPark subPark) {
        return subParkMapper.updateOneSubPark(subPark);
    }

    @Override
    public int deleteOneSubPark(int subParkId) {
        return subParkMapper.deleteOneSubPark(subParkId);
    }
}
