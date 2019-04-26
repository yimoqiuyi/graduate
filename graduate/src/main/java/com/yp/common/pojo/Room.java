package com.yp.common.pojo;

import java.io.Serializable;

public class Room implements Serializable {
    private int roomId;
    private String roomPosition;//具体位置描述
    private String roomPicture;//房间平面图
    private int stationNumber;//工位数
    private int buildId;//栋外键
    private int subParkId;//分园区外键
    private int generalParkId;//总园区外键

    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomPosition() {
        return roomPosition;
    }

    public void setRoomPosition(String roomPosition) {
        this.roomPosition = roomPosition;
    }

    public String getRoomPicture() {
        return roomPicture;
    }

    public void setRoomPicture(String roomPicture) {
        this.roomPicture = roomPicture;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int stationNumber) {
        this.stationNumber = stationNumber;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }


    public int getGeneralParkId() {
        return generalParkId;
    }

    public void setGeneralParkId(int generalParkId) {
        this.generalParkId = generalParkId;
    }
}
