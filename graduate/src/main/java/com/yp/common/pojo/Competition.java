package com.yp.common.pojo;



import java.io.Serializable;

public class Competition implements Serializable {
    private int competitionId;
    private String competitionName;//竞赛名称
    private String competitionLevel;//竞赛级别
    private String sponsor;//主办方
    private String nameofMember;//队员名称
    private String awardLevel;//获奖等级
    private String competitionAuditTime;//竞赛审核时间
    private String competitionPath;//文件路径
    private int competitionState;//审核状态
    private int groupId;//团队外键
    private int achievementsId;//成果外键
    private int subParkId; //分园区外键
    private int generalParkId; //总园区外键
    private Achievements achievements; //成果类型 1-1

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionLevel() {
        return competitionLevel;
    }

    public void setCompetitionLevel(String competitionLevel) {
        this.competitionLevel = competitionLevel;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getNameofMember() {
        return nameofMember;
    }

    public void setNameofMember(String nameofMember) {
        this.nameofMember = nameofMember;
    }

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    public String getCompetitionAuditTime() {
        return competitionAuditTime;
    }

    public void setCompetitionAuditTime(String competitionAuditTime) {
        this.competitionAuditTime = competitionAuditTime;
    }

    public String getCompetitionPath() {
        return competitionPath;
    }

    public void setCompetitionPath(String competitionPath) {
        this.competitionPath = competitionPath;
    }

    public int getCompetitionState() {
        return competitionState;
    }

    public void setCompetitionState(int competitionState) {
        this.competitionState = competitionState;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getAchievementsId() {
        return achievementsId;
    }

    public void setAchievementsId(int achievementsId) {
        this.achievementsId = achievementsId;
    }

    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
    }

    public int getGeneralParkId() {
        return generalParkId;
    }

    public void setGeneralParkId(int generalParkId) {
        this.generalParkId = generalParkId;
    }

    public Achievements getAchievements() {
        return achievements;
    }

    public void setAchievements(Achievements achievements) {
        this.achievements = achievements;
    }
}
