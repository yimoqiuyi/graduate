package com.yp.common.service.impl;

import com.yp.common.mapper.PermissionMapper;
import com.yp.common.pojo.Permission;
import com.yp.common.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Permission selectOnePermissionById(int id) {
        return permissionMapper.selectOnePermissionById(id);
    }

    @Override
    public List<Permission> selectAllPermission() {
        return permissionMapper.selectAllPermission();
    }

    @Override
    public List<Permission> selectPermissionByLimit(int page, int limit) {
        return permissionMapper.selectPermissionByLimit(page,limit);
    }

    @Override
    public boolean updatePermission(Permission permission) {
        return permissionMapper.updatePermission(permission);
    }

    @Override
    public boolean insertPermission(Permission permission) {
        return permissionMapper.insertPermission(permission);
    }

    @Override
    public int delectOnePermission(int id) {
        return permissionMapper.delectOnePermission(id);
    }

    @Override
    public List<Permission> selectAllPermissionByRoleId(int roleId) {
        return permissionMapper.selectAllPermissionByRoleId(roleId);
    }

    @Override
    public List<Permission> selctAllPermissionByUserId(int userId) {
        return permissionMapper.selctAllPermissionByUserId(userId);
    }
}
