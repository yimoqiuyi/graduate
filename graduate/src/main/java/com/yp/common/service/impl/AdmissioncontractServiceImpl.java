package com.yp.common.service.impl;

import com.yp.common.mapper.AdmissioncontractMapper;
import com.yp.common.pojo.Admissioncontract;
import com.yp.common.pojo.Dateutile;
import com.yp.common.service.AdmissioncontractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class AdmissioncontractServiceImpl implements AdmissioncontractService {
    @Autowired
    private AdmissioncontractMapper admissioncontractMapper;

    @Override
    public Admissioncontract selectOneAdmissioncontract(int admissionId) {
        return admissioncontractMapper.selectOneAdmissioncontract(admissionId);
    }

    @Override
    public List<Admissioncontract> selectOneAllAdmissioncontract(int groupId) {
        return admissioncontractMapper.selectOneAllAdmissioncontract(groupId);
    }

    @Override
    public List<Admissioncontract> selectAllAdmissioncontract() {
        return admissioncontractMapper.selectAllAdmissioncontract();
    }

    @Override
    public List<Admissioncontract> selectAllAdmissioncontractBysubParkId(int subParkId) {
        return admissioncontractMapper.selectAllAdmissioncontractBysubParkId(subParkId);
    }

    @Override
    public List<Admissioncontract> selectAllAdmissioncontractBygeneralParkId(int generalParkId) {
        return admissioncontractMapper.selectAllAdmissioncontractBygeneralParkId(generalParkId);
    }
     // int groupId,String signDate, String expirationDate
    @Override
    public List<Admissioncontract> selectAllAdmissioncontractBytimeandgroupID(Dateutile dateutile) {
        return admissioncontractMapper.selectAllAdmissioncontractBytimeandgroupID(dateutile );
    }

    @Override
    public List<Admissioncontract> selectAllAdmissioncontractByTimeAndsubParkId(Dateutile dateutile) {
        return admissioncontractMapper.selectAllAdmissioncontractByTimeAndsubParkId(dateutile);
    }

    @Override
    public List<Admissioncontract> selectAllAdmissioncontractByTimeAndgeneralParkId(Dateutile dateutile) {
        return null;
    }

    @Override
    public List<Admissioncontract> selectAdmissioncontractByLimit(int subParkId, int page, int limit) {
        return admissioncontractMapper.selectAdmissioncontractByLimit(subParkId,page,limit);
    }

    @Override
    public Admissioncontract selectAllAdmissioncontractBytime(String signDate, String expirationDate) {
        return admissioncontractMapper.selectAllAdmissioncontractBytime(signDate, expirationDate);
    }

    @Override
    public List<Admissioncontract> selectAdmissioncontractByCondition(Map<String, Object> map) {
        return admissioncontractMapper.selectAdmissioncontractByCondition(map);
    }

    @Override
    public boolean insertOneAdmissioncontract(Admissioncontract admissioncontract) {
        return admissioncontractMapper.insertOneAdmissioncontract(admissioncontract);
    }

    @Override
    public int delectOneAdmissioncontractByid(int admissionId) {
        admissioncontractMapper.delectOneAdmissioncontractByid(admissionId);
        return 0;
    }

    @Override
    public int delectAllAdmissioncontract() {
        admissioncontractMapper.delectAllAdmissioncontract();
        return 0;
    }

    @Override
    public boolean updateOneAdmissioncontractByid(Admissioncontract admissioncontract) {
        return admissioncontractMapper.updateOneAdmissioncontractByid(admissioncontract);
    }
}
