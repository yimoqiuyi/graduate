package com.yp.common.mapper;

import com.yp.common.pojo.Achievements;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//成果配置表
public interface AchievementsMapper {

    //获取所有成果配置项
    public List<Achievements> getAllachievements();

    //跟新成果配置
    public boolean updateAchievement(Achievements achievements);

    //添加成果项
    public boolean insertAchievements(Achievements achievements);

    //根据成果id查询成果
    public int delectAchievements(@Param("achievementsId") int achievementsId);

    //根据id查询成果
    public Achievements selectAchievementsByachievementsId(@Param("achievementsId") int achievementsId);

    //根据competitionId查询成果
    public Achievements selectAchievementsBycompetitionId(@Param("competitionId") int competitionId);

    //根据PaperId查询成果
    public Achievements selectAchievementsBypaperId(@Param("paperId") int paperId);

    //根据patentId查询成果
    public Achievements selectAchievementsBypatentId(@Param("patentId") int patentId);

    //根据软件id查询成果
    public Achievements selectAchievementsBysoftId(@Param("softId") int softId);

    //根据名字查询成果
    public Achievements selectAchievementsByName(@Param("achievementsName") String achievementsName);

}
