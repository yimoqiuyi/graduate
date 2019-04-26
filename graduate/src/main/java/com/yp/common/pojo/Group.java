package com.yp.common.pojo;

 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    private int groupId;     //团队主键
    private String groupName; //团队名称
    private String groupIntroduce;//团队介绍
    private int attendancePass; //考核任务是否通过
    private int groupWorkHealthPass;//考核卫生是否通过
    private int groupWorkAttendancePass;//考核考勤是否通过
    private int userId;//团队负责人
    private int state;//团队状态
    private int subParkId;// 分园区外键
    private List<User> userList;//团队与用户关系集合
    private List<WorkPosition> workPositionList;//工位集合
    private List<Paper> paperList;//论文集合
    private List<Patent> patentList;//专利集合
    private List<Software> softwareList;//软著集合
    private List<Competition> competitionList;//竞赛集合
    private List<Admissioncontract> admissioncontractList;//入园合同集合
    private List<Managementagreement> managementagreementList;//资产管理集合
    private List<Responsibilityagreement> responsibilityagreementList;//卫生协议集合
    private List<Performance> performanceList;//绩效集合

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupIntroduce='" + groupIntroduce + '\'' +
                ", attendancePass=" + attendancePass +
                ", groupWorkHealthPass=" + groupWorkHealthPass +
                ", groupWorkAttendancePass=" + groupWorkAttendancePass +
                ", userId=" + userId +
                ", state=" + state +
                ", subParkId=" + subParkId +
                ", userList=" + userList +
                ", workPositionList=" + workPositionList +
                ", paperList=" + paperList +
                ", patentList=" + patentList +
                ", softwareList=" + softwareList +
                ", competitionList=" + competitionList +
                ", admissioncontractList=" + admissioncontractList +
                ", managementagreementList=" + managementagreementList +
                ", responsibilityagreementList=" + responsibilityagreementList +
                ", performanceList=" + performanceList +
                '}';
    }

    public List<Performance> getPerformanceList() {
        return performanceList;
    }

    public void setPerformanceList(List<Performance> performanceList) {
        this.performanceList = performanceList;
    }

    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<WorkPosition> getWorkPositionList() {
        return workPositionList;
    }

    public void setWorkPositionList(List<WorkPosition> workPositionList) {
        this.workPositionList = workPositionList;
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }

    public List<Patent> getPatentList() {
        return patentList;
    }

    public void setPatentList(List<Patent> patentList) {
        this.patentList = patentList;
    }

    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public void setSoftwareList(List<Software> softwareList) {
        this.softwareList = softwareList;
    }

    public List<Competition> getCompetitionList() {
        return competitionList;
    }

    public void setCompetitionList(List<Competition> competitionList) {
        this.competitionList = competitionList;
    }

    public List<Admissioncontract> getAdmissioncontractList() {
        return admissioncontractList;
    }

    public void setAdmissioncontractList(List<Admissioncontract> admissioncontractList) {
        this.admissioncontractList = admissioncontractList;
    }

    public List<Managementagreement> getManagementagreementList() {
        return managementagreementList;
    }

    public void setManagementagreementList(List<Managementagreement> managementagreementList) {
        this.managementagreementList = managementagreementList;
    }

    public List<Responsibilityagreement> getResponsibilityagreementList() {
        return responsibilityagreementList;
    }

    public void setResponsibilityagreementList(List<Responsibilityagreement> responsibilityagreementList) {
        this.responsibilityagreementList = responsibilityagreementList;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupIntroduce() {
        return groupIntroduce;
    }

    public void setGroupIntroduce(String groupIntroduce) {
        this.groupIntroduce = groupIntroduce;
    }

    public int getAttendancePass() {
        return attendancePass;
    }

    public void setAttendancePass(int attendancePass) {
        this.attendancePass = attendancePass;
    }

    public int getGroupWorkHealthPass() {
        return groupWorkHealthPass;
    }

    public void setGroupWorkHealthPass(int groupWorkHealthPass) {
        this.groupWorkHealthPass = groupWorkHealthPass;
    }

    public int getGroupWorkAttendancePass() {
        return groupWorkAttendancePass;
    }

    public void setGroupWorkAttendancePass(int groupWorkAttendancePass) {
        this.groupWorkAttendancePass = groupWorkAttendancePass;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
