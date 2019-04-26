package com.yp.common.service;

import com.yp.common.pojo.Achievements;
import com.yp.common.pojo.AchievementsNumber;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AchievementsNumberService {
    public List<AchievementsNumber> getAllAchievementsNumber();//获取所有团队的成果显示

    public AchievementsNumber selectOneAchievementsNumber(@Param("groupId") int groupId);//通过团队id选择团队成果

    public boolean updateOneAchievementsNumber(AchievementsNumber achievementsNumber);
    //根据团队id进行成果的录入
    public boolean insertAchievementsNumber(AchievementsNumber achievementsNumber);

    public int delectOneAchievementsNumber(@Param("groupId") int groupId);//根据团队id删除团队成果

    public int delectOneAchievementsNumberById(@Param("achievementsNumId")int achievementsNumId);//删除所有团队成果表
}
