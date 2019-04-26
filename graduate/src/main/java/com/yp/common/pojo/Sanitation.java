package com.yp.common.pojo;



import java.io.Serializable;
import java.util.List;

public class Sanitation implements Serializable {
    private int sId;
    private String sanitationCategory;//卫生类别
    private int sanitationScore;//类别对应卫生分数
    private List< User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getSanitationCategory() {
        return sanitationCategory;
    }

    public void setSanitationCategory(String sanitationCategory) {
        this.sanitationCategory = sanitationCategory;
    }

    public int getSanitationScore() {
        return sanitationScore;
    }

    public void setSanitationScore(int sanitationScore) {
        this.sanitationScore = sanitationScore;
    }
}
