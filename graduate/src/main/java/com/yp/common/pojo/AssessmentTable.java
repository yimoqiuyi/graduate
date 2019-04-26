package com.yp.common.pojo;



import java.io.Serializable;

//任务
public class AssessmentTable implements Serializable {
    private int assessmentId;
    private int patentNum;//专利数
    private int softwareNum;//软著数
    private int paperNum;//论文数
    private int competitionNum;//获奖数
    private String assessmentStartTime;//任务开始日期
    private String assessmentEndTime;//任务结束日期
    private int groupId;//团队外键
    private  Group group=null;

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public  Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }



    public int getPatentNum() {
        return patentNum;
    }

    public void setPatentNum(int patentNum) {
        this.patentNum = patentNum;
    }

    public int getSoftwareNum() {
        return softwareNum;
    }

    public void setSoftwareNum(int softwareNum) {
        this.softwareNum = softwareNum;
    }

    public int getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(int paperNum) {
        this.paperNum = paperNum;
    }

    public int getCompetitionNum() {
        return competitionNum;
    }

    public void setCompetitionNum(int competitionNum) {
        this.competitionNum = competitionNum;
    }

    public String getAssessmentStartTime() {
        return assessmentStartTime;
    }

    public void setAssessmentStartTime(String assessmentStartTime) {
        this.assessmentStartTime = assessmentStartTime;
    }

    public String getAssessmentEndTime() {
        return assessmentEndTime;
    }

    public void setAssessmentEndTime(String assessmentEndTime) {
        this.assessmentEndTime = assessmentEndTime;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
