package com.yp.common.service;

import com.yp.common.pojo.Workhealth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkhealthService {
    //工位卫生录入
    public boolean insertOneWorkhealth(Workhealth workhealth);

    //工位卫生修改
    public boolean updateOneWorkhealth(Workhealth workhealth);

    //工位卫生删除
    public int deleteOneWorkhealthById(@Param("whId") int whId);

    //工位-卫生删除
    public int deleteWorkHealthByUserId(@Param("userId") int userId);
}
