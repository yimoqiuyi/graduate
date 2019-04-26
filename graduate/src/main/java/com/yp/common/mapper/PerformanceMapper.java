package com.yp.common.mapper;

import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.Performance;
import com.yp.common.utils.DateUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PerformanceMapper {

    //通过id查询绩效
    public Performance selectOnePerformance(@Param("performanceId") int performanceId);

    //通过团队外键查看绩效
    public List<Performance> selectPerformanceByGroupId(int groupId);  //用_parameter

    //通过分园区外键查询绩效
    public List<Performance> selectPerformanceBySubparkId(int subParkId);

    //通过总园区外键查看绩效
    public List<Performance> selectPerformanceByGeneralParkId(@Param("generalParkId") int generalParkId);

    //通过时间以及团队外键查看绩效
    public List<Performance> selectPerformanceByGroupIdAndTime(Dateutile dateutile);

    //模糊查询绩效
    public List<Performance> selectPerformanceByCondition(@Param("map") Map<String, Object> map);

    //通过时间以及分园区外键查看绩效
    public List<Performance> selectPerformanceBySubparkIdAndTime(Dateutile dateutile);

    //根据时间以及总园区查看绩效
    public List<Performance> selectPerformanceByGeneralParkIdAndTime(Dateutile dateutile);

    //分页查询
    public List<Performance> selectPerformanceBySubparkIdAndLimit(@Param("subParkId") int subParkId, @Param("page") int page, @Param("limit") int limit);

    //录入绩效
    public boolean insertPerformance(Performance performance);

    //修改绩效
    public boolean updatePerformance(Performance performance);

    //删除绩效
    public int deletePerformanceById(@Param("performanceId") int performanceId);
}
