package com.yp.common.service.impl;

import com.yp.common.mapper.BuildingMapper;
import com.yp.common.pojo.Building;
import com.yp.common.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BuildingServiceImpl implements BuildingService {
@Autowired
private BuildingMapper buildingMapper;
    @Override
    public Building selectOneBuildingBybuildId(int buildId) {
        return buildingMapper.selectOneBuildingBybuildId(buildId);
    }

    @Override
    public List<Building> selectAllBuilding() {
        return buildingMapper.selectAllBuilding();
    }

    @Override
    public List<Building> selectAllBuildingBysubParkId(int subParkId) {
        return buildingMapper.selectAllBuildingBysubParkId(subParkId);
    }

    @Override
    public List<Building> selectAllBuildingBygeneralParkId(int generalParkId) {
        return buildingMapper.selectAllBuildingBygeneralParkId(generalParkId);
    }

    @Override
    public boolean insertOneBuilding(Building building) {
        return buildingMapper.insertOneBuilding(building);
    }

    @Override
    public boolean updateOneBuildingById(Building building) {
        return buildingMapper.updateOneBuildingById(building);
    }

    @Override
    public int delectBuildingByid(int buildId) {
        return buildingMapper.delectBuildingByid(buildId);
    }

    @Override
    public int delectAllBuilding() {
        return buildingMapper.delectAllBuilding();
    }
}
