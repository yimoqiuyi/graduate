package com.yp.common.pojo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GeneralPark  implements Serializable {
    private int generalParkId;     //总园区主键
    private String generalName;//总园区名称
    private String generalIntroduce;//总园区介绍
    private String generalPicture;//总园区平面图
    private String generalPhone;//总园区电话
    private int userId;//总园区负责人
    private List<SubPark> subParkList;//分园区集合
    private List<Room> roomList; //房间结合
    private List<Building> buildingList; //栋结合
    private List<Patent> patentList; //总园区管理的专利集合
    private List<Software> softwareList; //软著集合
    private List<Paper> paperList;  //论文集和
    private List<Competition> competitionList; //竞赛集合
    private List<Admissioncontract> admissioncontractList;//入园合同集合
    private List<Managementagreement> managementagreementList;//资产管理集合
    private List<Responsibilityagreement> responsibilityagreementList;//卫生协议集合
    private  List<User> userList;//总园区负责人集合
    private List<Performance> performanceList;//绩效集合

    @Override
    public String toString() {
        return "GeneralPark{" +
                "generalParkId=" + generalParkId +
                ", generalName='" + generalName + '\'' +
                ", generalIntroduce='" + generalIntroduce + '\'' +
                ", generalPicture='" + generalPicture + '\'' +
                ", generalPhone='" + generalPhone + '\'' +
                ", userId=" + userId +
                ", subParkList=" + subParkList +
                ", roomList=" + roomList +
                ", buildingList=" + buildingList +
                ", patentList=" + patentList +
                ", softwareList=" + softwareList +
                ", paperList=" + paperList +
                ", competitionList=" + competitionList +
                ", admissioncontractList=" + admissioncontractList +
                ", managementagreementList=" + managementagreementList +
                ", responsibilityagreementList=" + responsibilityagreementList +
                ", userList=" + userList +
                ", performanceList=" + performanceList +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Performance> getPerformanceList() {
        return performanceList;
    }

    public void setPerformanceList(List<Performance> performanceList) {
        this.performanceList = performanceList;
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

    public List<SubPark> getSubParkList() {
        return subParkList;
    }

    public void setSubParkList(List<SubPark> subParkList) {
        this.subParkList = subParkList;
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

    public int getGeneralParkId() {
        return generalParkId;
    }

    public void setGeneralParkId(int generalParkId) {
        this.generalParkId = generalParkId;
    }

    public String getGeneralName() {
        return generalName;
    }

    public void setGeneralName(String generalName) {
        this.generalName = generalName;
    }

    public String getGeneralIntroduce() {
        return generalIntroduce;
    }

    public void setGeneralIntroduce(String generalIntroduce) {
        this.generalIntroduce = generalIntroduce;
    }

    public String getGeneralPicture() {
        return generalPicture;
    }

    public void setGeneralPicture(String generalPicture) {
        this.generalPicture = generalPicture;
    }

    public String getGeneralPhone() {
        return generalPhone;
    }

    public void setGeneralPhone(String generalPhone) {
        this.generalPhone = generalPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
