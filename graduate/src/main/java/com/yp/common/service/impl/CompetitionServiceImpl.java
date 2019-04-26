package com.yp.common.service.impl;

import com.yp.common.mapper.CompetitionMapper;
import com.yp.common.pojo.Competition;
import com.yp.common.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CompetitionServiceImpl implements CompetitionService {
    @Autowired
    private CompetitionMapper competitionMapper;

    @Override
    public Competition selectOneCompetitionBycompetitionId(int competitionId) {
        return competitionMapper.selectOneCompetitionBycompetitionId(competitionId);
    }

    @Override
    public int selctCompetitionsBygroupId(int groupId) {
        return competitionMapper.selctCompetitionsBygroupId(groupId);
    }

    @Override
    public List<Competition> selectAllCompetitionBygroupId(int groupId) {
        return competitionMapper.selectAllCompetitionBygroupId(groupId);
    }

    @Override
    public List<Competition> selectAllCompetition() {
        return competitionMapper.selectAllCompetition();
    }

    @Override
    public List<Competition> selectAllCompetitionBysubParkId(int subParkId) {
        return competitionMapper.selectAllCompetitionBysubParkId(subParkId);
    }

    @Override
    public List<Competition> selectAllCompetitionBygeneralParkId(int generalParkId) {
        return competitionMapper.selectAllCompetitionBygeneralParkId(generalParkId);
    }

    @Override
    public List<Competition> selectCompetionByGroupIdAndcompetitionState(int groupId, int competitionState) {
        return competitionMapper.selectCompetionByGroupIdAndcompetitionState(groupId,competitionState);
    }

    @Override
    public List<Competition> selectCompetitionByLimit(Map<String, Object> map) {
        return competitionMapper.selectCompetitionByLimit(map);
    }

    @Override
    public List<Competition> selectCompetitionByGroupIdandLimit(Map<String, Object> map) {
        return competitionMapper.selectCompetitionByGroupIdandLimit(map);
    }

    @Override
    public boolean insertCompetition(Competition competition) {
        return competitionMapper.insertCompetition(competition);
    }

    @Override
    public boolean updateCompetition(Competition competition) {
        return competitionMapper.updateCompetition(competition);
    }

    @Override
    public int deleteComptitionById(int competitionId) {
        return competitionMapper.deleteComptitionById(competitionId);
    }

    @Override
    public int deleteCompitionByAchievementsId(int achievementsId) {
        return competitionMapper.deleteCompitionByAchievementsId(achievementsId);
    }
}
