package com.yp.common.service.impl;

import com.yp.common.mapper.PatentMapper;
import com.yp.common.pojo.Patent;
import com.yp.common.service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PatentServiceImpl implements PatentService {
  @Autowired
  private PatentMapper patentMapper;
    @Override
    public Patent selectOnePatentByid(int patentId) {
        return patentMapper.selectOnePatentByid(patentId);
    }

    @Override
    public int selectPatentsByGroupId(int groupId) {
        return patentMapper.selectPatentsByGroupId(groupId);
    }

    @Override
    public List<Patent> selectAllPatentBygroupId(int groupId) {
        return patentMapper.selectAllPatentBygroupId(groupId);
    }

    @Override
    public List<Patent> selectAllPatentBysubParkId(int subParkId) {
        return patentMapper.selectAllPatentBysubParkId(subParkId);
    }

    @Override
    public List<Patent> selectPatentByGroupIdAndState(int groupId, int patentState) {
        return patentMapper.selectPatentByGroupIdAndState(groupId,patentState);
    }

    @Override
    public List<Patent> selectAllPatentBygeneralParkId(int generalParkId) {
        return patentMapper.selectAllPatentBygeneralParkId(generalParkId);
    }

    @Override
    public List<Patent> selectPatentByLimit(Map<String, Object> map) {
        return patentMapper.selectPatentByLimit(map);
    }

    @Override
    public List<Patent> selectAllPatent() {
        return patentMapper.selectAllPatent();
    }

    @Override
    public List<Patent> selectPatentByGroupIdandLimit(Map<String, Object> map) {
        return patentMapper.selectPatentByGroupIdandLimit(map);
    }

    @Override
    public boolean insertOnePatent(Patent patent) {
        return patentMapper.insertOnePatent(patent);
    }

    @Override
    public boolean updateOnePatent(Patent patent) {
        return patentMapper.updateOnePatent(patent);
    }

    @Override
    public int delectOnePatentByid(int patentId) {
        return patentMapper.delectOnePatentByid(patentId);
    }

    @Override
    public int deletePatentByAchievementsId(int achievementsId) {
        return patentMapper.deletePatentByAchievementsId(achievementsId);
    }
}
