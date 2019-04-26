package com.yp.common.service.impl;

import com.yp.common.mapper.SanitationMapper;
import com.yp.common.pojo.Sanitation;
import com.yp.common.service.SanitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SanitationServiceImpl implements SanitationService {
@Autowired
private SanitationMapper sanitationMapper;
    @Override
    public Sanitation selectOneSanitationById(int sId) {
        return sanitationMapper.selectOneSanitationById(sId);
    }

    @Override
    public List<Sanitation> selectSanitationByUserId(int userId) {
        return sanitationMapper.selectSanitationByUserId(userId);
    }

    @Override
    public List<Sanitation> selectAllSanitation() {
        return sanitationMapper.selectAllSanitation();
    }

    @Override
    public boolean insertOneSanitation(Sanitation sanitation) {
        return sanitationMapper.insertOneSanitation(sanitation);
    }

    @Override
    public boolean updateOneSanitation(Sanitation sanitation) {
        return sanitationMapper.updateOneSanitation(sanitation);
    }

    @Override
    public int deleteOneSanitationById(int sId) {
        return sanitationMapper.deleteOneSanitationById(sId);
    }
}
