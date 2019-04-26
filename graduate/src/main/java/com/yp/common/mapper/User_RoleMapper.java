package com.yp.common.mapper;

import com.yp.common.pojo.User_Role;
import org.apache.ibatis.annotations.Param;

public interface User_RoleMapper {

    public User_Role selectOneUserRole(@Param("id") int id);

    public boolean insertOneUserRole(User_Role user_role);

    public int deleteOneUserRoleById(@Param("id") int id);

    public boolean updateUserRole(User_Role user_role);

    public User_Role selectUserRoleByUserId(@Param("userId") int userId);
}
