package com.yp.common.service.impl;

import com.yp.common.mapper.AchievementsMapper;
import com.yp.common.pojo.Achievements;
import com.yp.common.pojo.AchievementsNumber;
import com.yp.common.service.AchievementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AchievementsServiceImpl implements AchievementsService {
    @Autowired
    private AchievementsMapper achievementsMapper;

    @Override
    public List<Achievements> getAllachievements() {
        return achievementsMapper.getAllachievements();
    }

    @Override
    public boolean updateAchievement(Achievements achievements ) {
        return achievementsMapper.updateAchievement(achievements);
    }

    @Override
    public boolean insertAchievements(Achievements achievements) {
        return achievementsMapper.insertAchievements(achievements);
    }

    @Override
    public int delectAchievements(int achievementsId) {
        achievementsMapper.delectAchievements(achievementsId);
        return 0;
    }

    @Override
    public Achievements selectAchievementsByachievementsId(int achievementsId) {
        return achievementsMapper.selectAchievementsByachievementsId(achievementsId);
    }

    @Override
    public Achievements selectAchievementsBycompetitionId(int competitionId) {
        return achievementsMapper.selectAchievementsBycompetitionId(competitionId);
    }

    @Override
    public Achievements selectAchievementsBypaperId(int paperId) {
        return achievementsMapper.selectAchievementsBypaperId(paperId);
    }

    @Override
    public Achievements selectAchievementsBypatentId(int patentId) {
        return achievementsMapper.selectAchievementsBypatentId(patentId);
    }

    @Override
    public Achievements selectAchievementsBysoftId(int softId) {
        return achievementsMapper.selectAchievementsBysoftId(softId);
    }

    @Override
    public Achievements selectAchievementsByName(String achievementsName) {
        return achievementsMapper.selectAchievementsByName(achievementsName);
    }
}
