package com.yp.common.service;

import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.Managementagreement;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ManagementagreementService {
    //根据协议id查看协议
    public Managementagreement selectOneManagementagreementByid(@Param("managementId") int managementId);

    //根据团队id查看协议
    public List<Managementagreement> selectAllManagementagreementBygroupId(@Param("groupId") int groupId);

    //查看所有分园区协议
    public List<Managementagreement> selectAllManagementagreementBysubParkId(int subParkId);

    //查看所有总园区的协议
    public List<Managementagreement> selectAllManagementagreementBygeneralParkId(@Param("generalParkId") int generalParkId);

    //根据时间与团队id查看
    public List<Managementagreement> selectAllManagementagreementByTime(Dateutile dateutile);

    //根据分园区与时间进行查看
    public List<Managementagreement> selectAllManagementagreementBytimeAndsubParkId(Dateutile dateutile);

    public List<Managementagreement> selectManagementagreementByMap(@Param("map") Map<String, Object> map);

    //根据条件查看
    public List<Managementagreement> selectManagementagreementByCondition(@Param("map") Map<String, Object> map);

    //根据总园区与时间查看
    public List<Managementagreement> selectAllManagementagreementByTimeAndgeneralParkId(Dateutile dateutile);

    //查看所有的协议
    public List<Managementagreement> selectAllManagementagreement();

    //录入协议
    public boolean insertOneManagementagreement(Managementagreement managementagreement);

    //修改协议
    public boolean updateOneManagementagreement(Managementagreement managementagreement);

    //删除协议
    public int delectOneManagementagreement(@Param("managementId") int managementId);
}
