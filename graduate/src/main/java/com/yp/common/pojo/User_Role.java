package com.yp.common.pojo;

import java.io.Serializable;
import java.util.List;

public class User_Role implements Serializable {
    private int id;
    private String userRoleName;
    private int userId;
    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "id=" + id +
                ", userRoleName='" + userRoleName + '\'' +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
