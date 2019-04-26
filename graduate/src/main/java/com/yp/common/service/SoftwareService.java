package com.yp.common.service;

import com.yp.common.pojo.Software;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SoftwareService {
    //根据主键选择软著
    public Software selectOneSoftwareById(@Param("softId") int softId);

    //根据团队外键选择软著数量
    public int selectSoftWaresByGroupId(@Param("groupId") int groupId);

    //根据团队外键选择软著
    public List<Software> selectAllSoftwareBygroupId(@Param("groupId") int groupId);

    //根据分园区查看软著
    public List<Software> selectAllSoftwareBysubParkId(@Param("subParkId") int subParkId);

    //根据总园区查看软著
    public List<Software> selectAllSoftwareBygeneralParkId(@Param("generalParkId") int generalParkId);

    //根据groupId与state查询软著
    public List<Software> selectSoftWareByGroupIdAndsoftwareState(@Param("groupId") int groupId, @Param("softwareState") int softwareState);

    //分页查询
    public List<Software> selectSoftwareByLimit(@Param("map") Map<String, Object> map);

    public List<Software> selectSoftwareByGroupIdandLimit(@Param("map") Map<String, Object> map);

    //录入软著
    public boolean insertOneSoftware(Software software);

    //修改软著
    public boolean updateOneSoftware(Software software);

    //删除软著
    public int deleteOneSoftwareById(@Param("softId") int softId);

    //删除软著根据achievementsId
    public int deleteSoftWareByAchievementsId(@Param("achievementsId") int achievementsId);
}
