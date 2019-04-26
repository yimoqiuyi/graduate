package com.yp.common.service.impl;

import com.yp.common.mapper.ResponsibilityagreementMapper;
import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.Responsibilityagreement;
import com.yp.common.service.ResponsibilityagreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class ResponsibilityagreementServiceImpl implements ResponsibilityagreementService {
    @Autowired
    private ResponsibilityagreementMapper responsibilityagreementMapper;

    @Override
    public Responsibilityagreement selectOneResponsibilityagreementById(int responsibleId) {
        return responsibilityagreementMapper.selectOneResponsibilityagreementById(responsibleId);
    }

    @Override
    public List<Responsibilityagreement> selectAllResponsibilityagreementBygroupId(int groupId) {
        return responsibilityagreementMapper.selectAllResponsibilityagreementBygroupId(groupId);
    }

    @Override
    public List<Responsibilityagreement> selectAllResponsibilityagreementBysubParkId(int subParkId) {
        return responsibilityagreementMapper.selectAllResponsibilityagreementBysubParkId(subParkId);
    }

    @Override
    public List<Responsibilityagreement> selectAllResponsibilityagreementBygeneralParkId(int generalParkId) {
        return responsibilityagreementMapper.selectAllResponsibilityagreementBygeneralParkId(generalParkId);
    }

    @Override
    public List<Responsibilityagreement> selectAllResponsibilityagreementByTimeAndgroupId(Dateutile dateutile) {
        return responsibilityagreementMapper.selectAllResponsibilityagreementByTimeAndgroupId(dateutile);
    }

    @Override
    public List<Responsibilityagreement> selectAllResponsibilityagreementByTimeAndsubParkId(Dateutile dateutile) {
        return responsibilityagreementMapper.selectAllResponsibilityagreementByTimeAndsubParkId(dateutile);
    }

    @Override
    public List<Responsibilityagreement> selectAllResponsibilityagreementByTimeAndgeneralParkId(Dateutile dateutile) {
        return responsibilityagreementMapper.selectAllResponsibilityagreementByTimeAndgeneralParkId(dateutile);
    }

    @Override
    public List<Responsibilityagreement> selectResponsibilityagreementBymap(Map<String, Object> map) {
        return responsibilityagreementMapper.selectResponsibilityagreementBymap(map);
    }

    @Override
    public List<Responsibilityagreement> selectResponsibilityagreementByCondition(Map<String, Object> map) {
        return responsibilityagreementMapper.selectResponsibilityagreementByCondition(map);
    }


    @Override
    public boolean insertOneResponsibilityagreement(Responsibilityagreement responsibilityagreement) {
        return responsibilityagreementMapper.insertOneResponsibilityagreement(responsibilityagreement);
    }

    @Override
    public boolean updateOneResponsibilityagreement(Responsibilityagreement responsibilityagreement) {
        return responsibilityagreementMapper.updateOneResponsibilityagreement(responsibilityagreement);
    }

    @Override
    public int delectOneResponsibilityagreementById(int responsibleId) {
        return responsibilityagreementMapper.delectOneResponsibilityagreementById(responsibleId);
    }
}
