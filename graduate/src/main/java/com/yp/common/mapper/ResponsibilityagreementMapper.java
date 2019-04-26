package com.yp.common.mapper;

import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.Responsibilityagreement;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

//卫生协议表的操作
public interface ResponsibilityagreementMapper {
    //同意主键获取卫生协议表
    public Responsibilityagreement selectOneResponsibilityagreementById(@Param("responsibleId") int responsibleId);

    //通过团队外键获取卫生协议
    public List<Responsibilityagreement> selectAllResponsibilityagreementBygroupId(int groupId);

    //通过分园全外键获取卫生协议
    public List<Responsibilityagreement> selectAllResponsibilityagreementBysubParkId(int subParkId);

    //通过总园区外键获取卫生协议
    public List<Responsibilityagreement> selectAllResponsibilityagreementBygeneralParkId(@Param("generalParkId") int generalParkId);

    //通过团队以及时间获取卫生协议
    public List<Responsibilityagreement> selectAllResponsibilityagreementByTimeAndgroupId(Dateutile dateutile);

    //通过时间与分园区获取卫生协议
    public List<Responsibilityagreement> selectAllResponsibilityagreementByTimeAndsubParkId(Dateutile dateutile);

    //根据书剑与总园区获取卫生协议
    public List<Responsibilityagreement> selectAllResponsibilityagreementByTimeAndgeneralParkId(Dateutile dateutile);

    //分页查询
    public List<Responsibilityagreement> selectResponsibilityagreementBymap(@Param("map") Map<String, Object> map);

    //根据条件分页查询
    public List<Responsibilityagreement> selectResponsibilityagreementByCondition(@Param("map") Map<String, Object> map);

    //录入卫生协议表
    public boolean insertOneResponsibilityagreement(Responsibilityagreement responsibilityagreement);

    //修改卫生协议
    public boolean updateOneResponsibilityagreement(Responsibilityagreement responsibilityagreement);

    //删除卫生协议
    public int delectOneResponsibilityagreementById(@Param("responsibleId") int responsibleId);


}
