package com.yp.common.pojo;



import java.io.Serializable;

public class Paper implements Serializable {
    private int paperId;
    private String paperName;//论文名称
    private String authors;//作者
    private String authorUnit;//作者单位
    private String journalName;//期刊名称
    private String paperAuditTime;//论文审核时间:
    private String grade;//论文等级
    private int groupId;//团队外键
    private int achievementsId;//成果外键
    private int paperState;//审核状态
    private String paperPath;//论文路径
    private int subParkId; //分园区外键
    private int generalParkId; //总园区外键
    private Achievements achievements; //成果类型 1-1

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getAuthorUnit() {
        return authorUnit;
    }

    public void setAuthorUnit(String authorUnit) {
        this.authorUnit = authorUnit;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public String getPaperAuditTime() {
        return paperAuditTime;
    }

    public void setPaperAuditTime(String paperAuditTime) {
        this.paperAuditTime = paperAuditTime;
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

    public int getPaperState() {
        return paperState;
    }

    public void setPaperState(int paperState) {
        this.paperState = paperState;
    }

    public String getPaperPath() {
        return paperPath;
    }

    public void setPaperPath(String paperPath) {
        this.paperPath = paperPath;
    }
}
