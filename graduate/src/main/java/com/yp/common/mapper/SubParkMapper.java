package com.yp.common.mapper;

import com.yp.common.pojo.SubPark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//分园区操作类
public interface SubParkMapper {
    //根据主键选择分园区
    public SubPark selectOneSubParkById(int subParkId);

    //根据用户id查看分园区管理者
    public SubPark selectSubparkByUserId(@Param("userId") int userId);

    //根据总园区选择分园区
    public List<SubPark> selectAllSubParkBygeneralParkId(@Param("generalParkId") int generalParkId);

    //录入分园区
    public boolean insertOneSubPark(SubPark subPark);

    //修改分园区
    public boolean updateOneSubPark(SubPark subPark);

    //删除分园区
    public int deleteOneSubPark(int subParkId);


}
