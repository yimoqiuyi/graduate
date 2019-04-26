package com.yp.common.service;

import com.yp.common.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {

    //根据名字查找角色
    public Role selectRoleByName(@Param("name") String name);

    //角色选择，根据角色idselectRoleByUserId
    public Role selectOneRoleById(@Param(value = "id") int id);

    //角色选择，根据id选择角色
    public List<Role> selectAllRoleById(@Param("id") int id);

    //分页查看权限列表
    public List<Role> selectRoleByLimit(@Param("page") int page, @Param("limit") int limit);

    //选择所有角色
    public List<Role> selectAllRole();

    //角色选择，根据用户Id选择角色
    public List<Role> selectRoleByUserId(@Param(value = "userId") int userId);

    //角色录入
    public boolean insertOneRole(Role role);

    //角色修改
    public boolean updateOneRole(Role role);

    //角色删除
    public int delectOneRoleById(@Param(value = "id") int id);
}
