package com.yp.common.pojo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Patent implements Serializable {
    private int patentId;//
    private String patentCategory;//专利类型
    private String patentName;//专利名称
    private String patentPeopleName;//专利权人
    private String patentCreatePeopleName;//专利发明人
    private String patentApplyTime;//申请日
    private String patentApplyNumber;//申请号
    private String dateofAuthorization;//授权日期
    private String authorizedPatentNumber;//授权专利号
    private String patentAuditTime;//专利审核时间
    private int patentState;//审核状态
    private int achievementsId;//成果外键
    private int groupId;//团队外键
    private int subParkId; //分园区外键
    private int generalParkId; //总园区外键
    private Achievements achievements; //成果类型 1-1
    private List<PatentFile>  patentFileList; //专利文件集合

    public String getAuthorizedPatentNumber() {
        return authorizedPatentNumber;
    }

    public void setAuthorizedPatentNumber(String authorizedPatentNumber) {
        this.authorizedPatentNumber = authorizedPatentNumber;
    }

    public List<PatentFile> getPatentFileList() {
        return patentFileList;
    }

    public void setPatentFileList(List<PatentFile> patentFileList) {
        this.patentFileList = patentFileList;
    }

    public int getGroupId() {
        return groupId;

    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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

    public int getPatentId() {
        return patentId;
    }

    public void setPatentId(int patentId) {
        this.patentId = patentId;
    }

    public String getPatentCategory() {
        return patentCategory;
    }

    public void setPatentCategory(String patentCategory) {
        this.patentCategory = patentCategory;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPatentPeopleName() {
        return patentPeopleName;
    }

    public void setPatentPeopleName(String patentPeopleName) {
        this.patentPeopleName = patentPeopleName;
    }

    public String getPatentCreatePeopleName() {
        return patentCreatePeopleName;
    }

    public void setPatentCreatePeopleName(String patentCreatePeopleName) {
        this.patentCreatePeopleName = patentCreatePeopleName;
    }

    public String getPatentApplyTime() {
        return patentApplyTime;
    }

    public void setPatentApplyTime(String patentApplyTime) {
        this.patentApplyTime = patentApplyTime;
    }

    public String getPatentApplyNumber() {
        return patentApplyNumber;
    }

    public void setPatentApplyNumber(String patentApplyNumber) {
        this.patentApplyNumber = patentApplyNumber;
    }

    public String getDateofAuthorization() {
        return dateofAuthorization;
    }

    public void setDateofAuthorization(String dateofAuthorization) {
        this.dateofAuthorization = dateofAuthorization;
    }


    public String getPatentAuditTime() {
        return patentAuditTime;
    }

    public void setPatentAuditTime(String patentAuditTime) {
        this.patentAuditTime = patentAuditTime;
    }

    public int getPatentState() {
        return patentState;
    }

    public void setPatentState(int patentState) {
        this.patentState = patentState;
    }

    public int getAchievementsId() {
        return achievementsId;
    }

    public void setAchievementsId(int achievementsId) {
        this.achievementsId = achievementsId;
    }




}
