package com.yp.common.service.impl;

import com.yp.common.mapper.User_RoleMapper;
import com.yp.common.pojo.User_Role;
import com.yp.common.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private User_RoleMapper user_roleMapper;
    @Override
    public User_Role selectOneUserRole(int id) {
        return user_roleMapper.selectOneUserRole(id);
    }

    @Override
    public boolean insertOneUserRole(User_Role user_role) {
        return user_roleMapper.insertOneUserRole(user_role);
    }

    @Override
    public int deleteOneUserRoleById(int id) {
        return user_roleMapper.deleteOneUserRoleById(id);
    }

    @Override
    public boolean updateUserRole(User_Role user_role) {
        return user_roleMapper.updateUserRole(user_role);
    }

    @Override
    public User_Role selectUserRoleByUserId(int userId) {
        return user_roleMapper.selectUserRoleByUserId(userId);
    }
}
