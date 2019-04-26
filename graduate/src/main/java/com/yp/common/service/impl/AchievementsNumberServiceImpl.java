package com.yp.common.service.impl;

import com.yp.common.mapper.AchievementsNumberMapper;
import com.yp.common.pojo.Achievements;
import com.yp.common.pojo.AchievementsNumber;
import com.yp.common.service.AchievementsNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AchievementsNumberServiceImpl implements AchievementsNumberService {
@Autowired
private AchievementsNumberMapper achievementsNumberMapper;
    @Override
    @Cacheable(value="redisCacheManager",key="'redis_role_'+#achievementsNumId")
    public List<AchievementsNumber> getAllAchievementsNumber() {

        return achievementsNumberMapper.getAllAchievementsNumber();
    }

    @Override
    public AchievementsNumber selectOneAchievementsNumber(int groupId) {
        return achievementsNumberMapper.selectOneAchievementsNumber(groupId);
    }

    @Override
    public boolean updateOneAchievementsNumber(AchievementsNumber achievementsNumber) {
        return achievementsNumberMapper.updateOneAchievementsNumber(achievementsNumber);
    }

    @Override
    public boolean insertAchievementsNumber(AchievementsNumber achievementsNumber) {
        return achievementsNumberMapper.insertAchievementsNumber(achievementsNumber);
    }

    @Override
    public int delectOneAchievementsNumber(int groupId) {
        achievementsNumberMapper.delectOneAchievementsNumber(groupId);
        return 0;
    }

    @Override
    public int delectOneAchievementsNumberById(int achievementsNumId) {
        achievementsNumberMapper.delectOneAchievementsNumberById(achievementsNumId);
        return 0;
    }
}
