package com.yp.common.pojo;

 

import java.io.Serializable;
import java.util.Date;

public class Responsibilityagreement implements Serializable {
    private int responsibleId;
    private String responsibleName;//卫生协议名称
    private String responsibleIntroduce;//卫生协议介绍
    private String filePath;//文件路径
    private String signDate;//签订日期
    private String expirationDate;//过期日期
    private int argeementId;//合同外键
    private int groupId;//团队外键
    private int subParkId;//分园区外键
    private int generalParkId;//总园区外键
    private Agreement agreement = null;


    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public int getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(int responsibleId) {
        this.responsibleId = responsibleId;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getResponsibleIntroduce() {
        return responsibleIntroduce;
    }

    public void setResponsibleIntroduce(String responsibleIntroduce) {
        this.responsibleIntroduce = responsibleIntroduce;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }



    public int getArgeementId() {
        return argeementId;
    }

    public void setArgeementId(int argeementId) {
        this.argeementId = argeementId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }



    public int getGeneralParkId() {
        return generalParkId;
    }

    public void setGeneralParkId(int generalParkId) {
        this.generalParkId = generalParkId;
    }
}
