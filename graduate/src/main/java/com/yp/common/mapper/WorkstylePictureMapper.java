package com.yp.common.mapper;

import com.yp.common.pojo.WorkstylePicture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//工位样式操作
public interface WorkstylePictureMapper {
    //工位样式查看
    public WorkstylePicture selectOneWorkstylePictureById(@Param("workStyleId") int workStyleId);

    //查看所有工位样式
    public List<WorkstylePicture> selectAllWorkstylePicture();

    //录入工位样式
    public boolean insertOneWorkstylePicture(WorkstylePicture workstylePicture);

    //修改工位样式
    public boolean updateOneWorkstylePicture(WorkstylePicture workstylePicture);

    //删除工位样式根据id
    public int deleteOneWorkstylePictureById(@Param("workStyleId")int workStyleId);

    //根据用户工位id选择作为样式图
    public WorkstylePicture selectWorkstylePictureByworkId(@Param("workId") int workId );
}
