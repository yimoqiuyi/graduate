package com.yp.common.service.impl;

import com.yp.common.mapper.Role_PermissionMapper;
import com.yp.common.pojo.Role_Permission;
import com.yp.common.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;

public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private Role_PermissionMapper role_permissionMapper;
    @Override
    public Role_Permission selecteOneRole_PermissionById(int id) {
        return role_permissionMapper.selecteOneRole_PermissionById(id);
    }

    @Override
    public boolean insertOneRole_Permission(Role_Permission role_permission) {
        return role_permissionMapper.insertOneRole_Permission(role_permission);
    }

    @Override
    public int deleteOneRole_Permission(int id) {
        return role_permissionMapper.deleteOneRole_Permission(id);
    }

    @Override
    public int deleteRole_PermissionByroleIdAndId(int roleId, int id) {
        return role_permissionMapper.deleteRole_PermissionByroleIdAndId(roleId,id);
    }
}
