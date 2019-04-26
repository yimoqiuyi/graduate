package com.yp.common.service;

import com.yp.common.pojo.Sanitation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SanitationService {
    //根据id选择卫生配置
    public Sanitation selectOneSanitationById(@Param(value="sId") int sId);

    //根据用户id选择触犯的卫生
    public List<Sanitation> selectSanitationByUserId(@Param(value="userId")int userId);

    //选择所有卫生种类
    public List<Sanitation> selectAllSanitation();

    //录入卫生配置
    public boolean insertOneSanitation(Sanitation sanitation);

    //修改卫生配置
    public boolean updateOneSanitation(Sanitation sanitation);

    //删除卫生配置
    public int deleteOneSanitationById(@Param(value="sId")int sId);
}
