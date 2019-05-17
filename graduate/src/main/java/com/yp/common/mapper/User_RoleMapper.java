package com.yp.common.mapper;

import com.yp.common.pojo.User_Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface User_RoleMapper {

    public User_Role selectOneUserRole(@Param("id") int id);

    public boolean insertOneUserRole(User_Role user_role);

    public int deleteOneUserRoleById(@Param("id") int id);

    public int updateUserRole(User_Role user_role);

    public User_Role selectUserRoleByUserId(@Param("userId") int userId);

    public int deleteUserroleByUserId(@Param("userId") int userId);
}
