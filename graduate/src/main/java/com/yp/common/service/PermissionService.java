package com.yp.common.service;

import com.yp.common.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionService {
    //选择单个权限
    public Permission selectOnePermissionById(@Param("id") int id);

    //选择权限
    public List<Permission> selectAllPermission();

    public List<Permission> selectPermissionByLimit(@Param("page") int page, @Param("limit") int limit);

    //修改权限
    public boolean updatePermission(Permission permission);

    //通过用户id选择权限
    public List<Permission> selctAllPermissionByUserId(@Param("userId") int userId);

    //录入权限配置
    public boolean insertPermission(Permission permission);

    //删除权限配置
    public int delectOnePermission(@Param("id") int id);

    //通过role选择permission
    public List<Permission> selectAllPermissionByRoleId(@Param("id") int id);
}
