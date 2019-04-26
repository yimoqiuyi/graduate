package com.yp.common.pojo;



import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private int roleId;
    private String name; //½ÇÉ«Ãû×Ö
    private String introduce;  //½ÇÉ«½éÉÜ
    private List<User> userList;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
