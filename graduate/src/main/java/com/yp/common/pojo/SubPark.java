package com.yp.common.pojo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubPark implements Serializable {
    private int subParkId;//分园区主键
    private String subParkName;//分园区名称
    private String subParkIntroduce;//分园区介绍
    private String subParkPhone;//分园区联系电话
    private String subParkPicture;//分园区平面图
    private int generalParkId;//总园区外键
    private int userId;//用户外键
    private List<User> userList;//分园区负责人集合
    private ArrayList<Building> Buildings;  //栋集合
    private List<Group> groupList;//团队集合
    private List<Room> roomList; //房间集合
    private List<Building> buildingList;  //栋集合
    private List<Patent> patentList; //分园区管理的专利集合
    private List<Software> softwareList; //软著集合
    private List<Paper> paperList;  //论文集和
    private List<Competition> competitionList; //竞赛集合
    private List<Admissioncontract> admissioncontractList;//入园合同集合
    private List<Managementagreement> managementagreementList;//资产管理集合
    private List<Responsibilityagreement> responsibilityagreementList;//卫生协议集合
    private List<Performance> performanceList;//绩效集合

    @Override
    public String toString() {
        return "SubPark{" +
                "subParkId=" + subParkId +
                ", subParkName='" + subParkName + '\'' +
                ", subParkIntroduce='" + subParkIntroduce + '\'' +
                ", subParkPhone='" + subParkPhone + '\'' +
                ", subParkPicture='" + subParkPicture + '\'' +
                ", generalParkId=" + generalParkId +
                ", userId=" + userId +
                ", userList=" + userList +
                ", Buildings=" + Buildings +
                ", groupList=" + groupList +
                ", roomList=" + roomList +
                ", buildingList=" + buildingList +
                ", patentList=" + patentList +
                ", softwareList=" + softwareList +
                ", paperList=" + paperList +
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

    public String getSubParkPicture() {
        return subParkPicture;
    }

    public void setSubParkPicture(String subParkPicture) {
        this.subParkPicture = subParkPicture;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
    }

    public String getSubParkName() {
        return subParkName;
    }

    public void setSubParkName(String subParkName) {
        this.subParkName = subParkName;
    }

    public String getSubParkIntroduce() {
        return subParkIntroduce;
    }

    public void setSubParkIntroduce(String subParkIntroduce) {
        this.subParkIntroduce = subParkIntroduce;
    }

    public String getSubParkPhone() {
        return subParkPhone;
    }

    public void setSubParkPhone(String subParkPhone) {
        this.subParkPhone = subParkPhone;
    }



    public int getGeneralParkId() {
        return generalParkId;
    }

    public void setGeneralParkId(int generalParkId) {
        this.generalParkId = generalParkId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Building> getBuildings() {
        return Buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        Buildings = buildings;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
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

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
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
}
