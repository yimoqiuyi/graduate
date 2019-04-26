package com.yp.common.service.impl;

import com.yp.common.mapper.SoftwareMapper;
import com.yp.common.pojo.Software;
import com.yp.common.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SoftwareServiceImpl implements SoftwareService {
@Autowired
private SoftwareMapper softwareMapper;
    @Override
    public Software selectOneSoftwareById(int softId) {
        return softwareMapper.selectOneSoftwareById(softId);
    }

    @Override
    public int selectSoftWaresByGroupId(int groupId) {
        return softwareMapper.selectSoftWaresByGroupId(groupId);
    }

    @Override
    public List<Software> selectAllSoftwareBygroupId(int groupId) {
        return softwareMapper.selectAllSoftwareBygroupId(groupId);
    }

    @Override
    public List<Software> selectAllSoftwareBysubParkId(int subParkId) {
        return softwareMapper.selectAllSoftwareBysubParkId(subParkId);
    }

    @Override
    public List<Software> selectAllSoftwareBygeneralParkId(int generalParkId) {
        return softwareMapper.selectAllSoftwareBygeneralParkId(generalParkId);
    }

    @Override
    public List<Software> selectSoftWareByGroupIdAndsoftwareState(int groupId, int softwareState) {
        return softwareMapper.selectSoftWareByGroupIdAndsoftwareState(groupId,softwareState);
    }

    @Override
    public List<Software> selectSoftwareByLimit(Map<String, Object> map) {
        return softwareMapper.selectSoftwareByLimit(map);
    }

    @Override
    public List<Software> selectSoftwareByGroupIdandLimit(Map<String, Object> map) {
        return softwareMapper.selectSoftwareByGroupIdandLimit(map);
    }

    @Override
    public boolean insertOneSoftware(Software software) {
        return softwareMapper.insertOneSoftware(software);
    }

    @Override
    public boolean updateOneSoftware(Software software) {
        return softwareMapper.updateOneSoftware(software);
    }

    @Override
    public int deleteOneSoftwareById(int softId) {
        return softwareMapper.deleteOneSoftwareById(softId);
    }

    @Override
    public int deleteSoftWareByAchievementsId(int achievementsId) {
        return softwareMapper.deleteSoftWareByAchievementsId(achievementsId);
    }
}
