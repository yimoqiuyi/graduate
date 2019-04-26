package com.yp.common.pojo;



import java.io.Serializable;


public class Admissioncontract implements Serializable {
    private int admissionId;//
    private String admissionName;//合同名称
    private String admissionIntroduce;//合同介绍
    private String filePath;//文件路径
    private int agreementId;//合同外键
    private String signDate;//签订日期
    private String expirationDate;//过期日期
    private int groupId;//团队外键
    private int subParkId;//分园区外键
    private int generalParkId;//总园区外键
    private Agreement agreement = null;

    public  Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public int getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(int admissionId) {
        this.admissionId = admissionId;
    }

    public String getAdmissionName() {
        return admissionName;
    }

    public void setAdmissionName(String admissionName) {
        this.admissionName = admissionName;
    }

    public String getAdmissionIntroduce() {
        return admissionIntroduce;
    }

    public void setAdmissionIntroduce(String admissionIntroduce) {
        this.admissionIntroduce = admissionIntroduce;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(int agreementId) {
        this.agreementId = agreementId;
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

    public int getGroupId() {
        return groupId;
    }

    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
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
