package com.yp.common.mapper;

import com.yp.common.pojo.Competition;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//竞赛的操作
public interface CompetitionMapper {
    //根据竞赛id查看竞赛
    public Competition selectOneCompetitionBycompetitionId(@Param("competitionId") int competitionId);

    //根据团队id查看团队竞赛数量
    public int selctCompetitionsBygroupId(int groupId);

    //根据团队id查看团队竞赛集合
    public List<Competition> selectAllCompetitionBygroupId(int groupId);

    //查看所有竞赛
    public List<Competition> selectAllCompetition();

    //根据分园区查看所有竞赛
    public List<Competition> selectAllCompetitionBysubParkId(int subParkId);

    //根据总园区外键查看所有竞赛
    public List<Competition> selectAllCompetitionBygeneralParkId(@Param("generalParkId") int generalParkId);

    //根据团队id以及文件状态查询
    public List<Competition> selectCompetionByGroupIdAndcompetitionState(@Param("groupId") int groupId, @Param("competitionState") int competitionState);

    //通过groupId分页查询
    public List<Competition> selectCompetitionByGroupIdandLimit(@Param("map") Map<String, Object> map);

    //分页查询
    public List<Competition> selectCompetitionByLimit(@Param("map") Map<String, Object> map);

    //录入竞赛
    public boolean insertCompetition(Competition competition);

    //根据id修改竞赛
    public boolean updateCompetition(Competition competition);

    //删除团队竞赛信息
    public int deleteComptitionById(@Param("competitionId") int competitionId);

    //删除团队竞赛信息通过achievementsId
    public int deleteCompitionByAchievementsId(@Param("achievementsId") int achievementsId);
}
