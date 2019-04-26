package com.yp.common.service;

import com.yp.common.pojo.Building;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildingService {
    //根据栋主键选择查看
    public Building selectOneBuildingBybuildId(@Param("buildId") int buildId);

    //选择查看所有栋
    public List<Building> selectAllBuilding();

    //根据分园区外键选择查看所在栋
    public List<Building> selectAllBuildingBysubParkId(int subParkId);

    //根据总园区外键选择查看所有栋
    public List<Building> selectAllBuildingBygeneralParkId(@Param("generalParkId") int generalParkId);

    //录入栋
    public boolean insertOneBuilding(Building building);

    //根据栋主键修改栋
    public boolean updateOneBuildingById(Building building);

    //根据栋id删除栋
    public int delectBuildingByid(@Param("buildId") int buildId);

    //删除所有栋
    public int delectAllBuilding();
}
