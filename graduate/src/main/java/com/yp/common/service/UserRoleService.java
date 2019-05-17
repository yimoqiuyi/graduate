package com.yp.common.service;

import com.yp.common.pojo.User_Role;
import org.apache.ibatis.annotations.Param;

public interface UserRoleService {
    public User_Role selectOneUserRole(@Param("id") int id);

    public boolean insertOneUserRole(User_Role user_role);

    public int deleteOneUserRoleById(@Param("id") int id);

    public int updateUserRole(User_Role user_role);

    public User_Role selectUserRoleByUserId(@Param("userId") int userId);

    public int deleteUserroleByUserId(@Param("userId") int userId);
}
