package com.yp.common.pojo;

import java.io.Serializable;

public class WorkPosition implements Serializable {
    private int workId;//
    private int workState;//工位状态
    private String workCreateTime;//工位创建时间
    private String workPosition;//工位位置
    private int groupId;//负责人ID
    private int roomId;//房间外键
    private int workStyleId;//工位样式图外键

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public int getWorkState() {
        return workState;
    }

    public void setWorkState(int workState) {
        this.workState = workState;
    }

    public String getWorkCreateTime() {
        return workCreateTime;
    }

    public void setWorkCreateTime(String workCreateTime) {
        this.workCreateTime = workCreateTime;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getWorkStyleId() {
        return workStyleId;
    }

    public void setWorkStyleId(int workStyleId) {
        this.workStyleId = workStyleId;
    }


}
