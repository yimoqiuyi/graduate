package com.yp.common.service.impl;

import com.yp.common.mapper.RoleMapper;
import com.yp.common.pojo.Role;
import com.yp.common.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class  RoleServiceImpl implements RoleService {
@Autowired
private RoleMapper roleMapper;

    @Override
    public Role selectRoleByName(String name) {
        return roleMapper.selectRoleByName(name);
    }

    @Override
    public Role selectOneRoleById(int roleId) {
        return roleMapper.selectOneRoleById(roleId);
    }

    @Override
    public List<Role> selectAllRoleById(int id) {
        return roleMapper.selectAllRoleById(id);
    }

    @Override
    public List<Role> selectRoleByLimit(int page, int limit) {
        return roleMapper.selectRoleByLimit(page,limit);
    }

    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }

    @Override
    public List<Role> selectRoleByUserId(int userId) {
        return roleMapper.selectRoleByUserId(userId);
    }

    @Override
    public boolean insertOneRole(Role role) {
        return roleMapper.insertOneRole(role);
    }

    @Override
    public boolean updateOneRole(Role role) {
        return roleMapper.updateOneRole(role);
    }

    @Override
    public int delectOneRoleById(int roleId) {
        return roleMapper.delectOneRoleById(roleId);
    }
}
