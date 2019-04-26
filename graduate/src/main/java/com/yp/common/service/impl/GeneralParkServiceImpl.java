package com.yp.common.service.impl;

import com.yp.common.mapper.GeneralParkMapper;
import com.yp.common.pojo.GeneralPark;
import com.yp.common.service.GeneralParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GeneralParkServiceImpl implements GeneralParkService {
@Autowired
private GeneralParkMapper generalParkMapper;
    @Override
    public GeneralPark selectOneGeneralParkBygeneralParkId(int generalParkId) {
        return generalParkMapper.selectOneGeneralParkBygeneralParkId(generalParkId);
    }

    @Override
    public GeneralPark selectGeneralParkByid(int userId) {
        return generalParkMapper.selectGeneralParkByid(userId);
    }

    @Override
    public List<GeneralPark> selectAllGeneralPark() {
        return generalParkMapper.selectAllGeneralPark();
    }

    @Override
    public boolean insertGeneralPark(GeneralPark generalPark) {
        return generalParkMapper.insertGeneralPark(generalPark);
    }

    @Override
    public boolean updateGeneralPark(GeneralPark generalPark) {
        return generalParkMapper.updateGeneralPark(generalPark);
    }

    @Override
    public int delectGeneralParkByuserId(int generalParkId) {
        return generalParkMapper.delectGeneralParkByuserId(generalParkId);
    }

    @Override
    public int delectAllGeneralPark() {
        return generalParkMapper.delectAllGeneralPark();
    }
}
