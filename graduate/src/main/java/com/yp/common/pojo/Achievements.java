package com.yp.common.pojo;

import java.io.Serializable;

//设置成果的类
public class Achievements implements Serializable {
    private int achievementsId;
    private String achievementsName;//成果名字
    private String achievementsIntroduction;//成果简介
    private String achievementsCategory;//成果类别
    private int achievementsScore;//类别对应分数

    public int getAchievementsId() {
        return achievementsId;
    }

    public void setAchievementsId(int achievementsId) {
        this.achievementsId = achievementsId;
    }

    public String getAchievementsName() {
        return achievementsName;
    }

    public void setAchievementsName(String achievementsName) {
        this.achievementsName = achievementsName;
    }

    public String getAchievementsIntroduction() {
        return achievementsIntroduction;
    }

    public void setAchievementsIntroduction(String achievementsIntroduction) {
        this.achievementsIntroduction = achievementsIntroduction;
    }

    public String getAchievementsCategory() {
        return achievementsCategory;
    }

    public void setAchievementsCategory(String achievementsCategory) {
        this.achievementsCategory = achievementsCategory;
    }

    public int getAchievementsScore() {
        return achievementsScore;
    }

    public void setAchievementsScore(int achievementsScore) {
        this.achievementsScore = achievementsScore;
    }
}
