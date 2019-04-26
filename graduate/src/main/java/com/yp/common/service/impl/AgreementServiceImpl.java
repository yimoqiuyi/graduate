package com.yp.common.service.impl;

import com.yp.common.mapper.AgreementMapper;
import com.yp.common.pojo.Agreement;
import com.yp.common.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AgreementServiceImpl implements AgreementService {
    @Autowired
    private AgreementMapper agreementMapper;

    @Override
    public Agreement selectOneAgreementById(int agreementId) {
        return agreementMapper.selectOneAgreementById(agreementId);
    }

    @Override
    public List<Agreement> selectAllAgreement() {
        return agreementMapper.selectAllAgreement();
    }

    @Override
    public boolean insertAgreement(Agreement agreement) {
        return agreementMapper.insertAgreement(agreement);
    }

    @Override
    public boolean updateAgreementByid(Agreement agreement, int agreementId) {
        return agreementMapper.updateAgreementByid(agreement, agreementId);
    }

    @Override
    public int delectAgreementByid(int agreementId) {
        return agreementMapper.delectAgreementByid(agreementId);
    }

    @Override
    public int delectAllAgreement() {
        return agreementMapper.delectAllAgreement();
    }

    @Override
    public Agreement selectAgreementBymanagementId(int managementId) {
        return null;
    }

    @Override
    public Agreement selectAgreementByresponsibleId(int responsibleId) {
        return agreementMapper.selectAgreementByresponsibleId(responsibleId);
    }
}
