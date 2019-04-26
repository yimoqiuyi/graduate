package com.yp.common.pojo;

import java.io.Serializable;

//绩效
public class Performance implements Serializable {
    private int performanceId; //绩效id
    private int performanceScore;  //绩效分数
    private String startTime; //开始时间
    private String endTime; //结束时间
    private String groupName;//团队名称
    private int groupId; //团队外键
    private int subParkId; //分园区外键
    private int generalParkId;  //总园区外键

    @Override
    public String toString() {
        return "Performance{" +
                "performanceId=" + performanceId +
                ", performanceScore=" + performanceScore +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupId=" + groupId +
                ", subParkId=" + subParkId +
                ", generalParkId=" + generalParkId +
                 '}';
    }

    public int getGeneralParkId() {
        return generalParkId;
    }

    public void setGeneralParkId(int generalParkId) {
        this.generalParkId = generalParkId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(int performanceId) {
        this.performanceId = performanceId;
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

}
