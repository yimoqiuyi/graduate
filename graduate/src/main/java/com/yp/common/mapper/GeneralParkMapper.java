package com.yp.common.mapper;

import com.yp.common.pojo.GeneralPark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//总园区操作
public interface GeneralParkMapper {

    //根据总园区id选择总园区
    public GeneralPark selectOneGeneralParkBygeneralParkId(@Param("generalParkId") int generalParkId);

    //根据园区负责人选择园区
    public GeneralPark selectGeneralParkByid(@Param("userId")int userId);

    //查看所有的总园区
    public List<GeneralPark> selectAllGeneralPark();

    //录入总园区
    public boolean insertGeneralPark(GeneralPark generalPark);

    //修改总园区
    public boolean updateGeneralPark(GeneralPark generalPark);

    //删除某个总园区
    public int delectGeneralParkByuserId(@Param("generalParkId")int generalParkId);

    //删除所有总园区
    public int delectAllGeneralPark();
}
