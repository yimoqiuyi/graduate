package com.yp.common.mapper;

import com.yp.common.pojo.Patent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//专利表的操作
public interface PatentMapper {
    //通过主键查看专利
    public Patent selectOnePatentByid(int patentId);

    //用过团队外键查询专利数量
    public int selectPatentsByGroupId(int groupId);

    //通过团队外键查看专利
    public List<Patent> selectAllPatentBygroupId(int groupId);

    //通过团队外键以及状态码查看专利
    public List<Patent> selectPatentByGroupIdAndState(@Param("groupId") int groupId, @Param("patentState") int patentState);

    //通过分园区外键查看专利
    public List<Patent> selectAllPatentBysubParkId(int subParkId);

    //分页查看专利
    public List<Patent> selectPatentByLimit(@Param("map") Map<String, Object> map);

    //通过总园区外键查看专利
    public List<Patent> selectAllPatentBygeneralParkId(@Param("generalParkId") int generalParkId);

    //分页查询根据团队Id
    public List<Patent> selectPatentByGroupIdandLimit(@Param("map") Map<String, Object> map);

    //查询所有的专利表
    public List<Patent> selectAllPatent();

    //录入专利表
    public boolean insertOnePatent(Patent patent);

    //修改专利表
    public boolean updateOnePatent(Patent patent);

    //删除专利表
    public int delectOnePatentByid(int patentId);

    //删除所有专利通过achievementsId
    public int deletePatentByAchievementsId(@Param("achievementsId") int achievementsId);
}
