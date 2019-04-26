package com.yp.common.service;

import com.yp.common.pojo.Building;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildingService {
    //���ݶ�����ѡ��鿴
    public Building selectOneBuildingBybuildId(@Param("buildId") int buildId);

    //ѡ��鿴���ж�
    public List<Building> selectAllBuilding();

    //���ݷ�԰�����ѡ��鿴���ڶ�
    public List<Building> selectAllBuildingBysubParkId(int subParkId);

    //������԰�����ѡ��鿴���ж�
    public List<Building> selectAllBuildingBygeneralParkId(@Param("generalParkId") int generalParkId);

    //¼�붰
    public boolean insertOneBuilding(Building building);

    //���ݶ������޸Ķ�
    public boolean updateOneBuildingById(Building building);

    //���ݶ�idɾ����
    public int delectBuildingByid(@Param("buildId") int buildId);

    //ɾ�����ж�
    public int delectAllBuilding();
}