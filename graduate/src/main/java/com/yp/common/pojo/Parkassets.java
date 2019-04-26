package com.yp.common.pojo;

 

import java.io.Serializable;

public class Parkassets implements Serializable {
    private int assetId;
    private int tableNum;//桌子数量
    private int chairNum; //椅子数量
    private int airconditioningNum; //空调数量
    private int curtainNum;  //窗帘数量
    private int WaterdispenserNum;  //饮水机数量
    private int electricboardNum; //电插板数量
    private int roomId;  //房间外键
    private Room room=null;//房间与资产对应

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public int getChairNum() {
        return chairNum;
    }

    public void setChairNum(int chairNum) {
        this.chairNum = chairNum;
    }

    public int getAirconditioningNum() {
        return airconditioningNum;
    }

    public void setAirconditioningNum(int airconditioningNum) {
        this.airconditioningNum = airconditioningNum;
    }

    public int getCurtainNum() {
        return curtainNum;
    }

    public void setCurtainNum(int curtainNum) {
        this.curtainNum = curtainNum;
    }

    public int getWaterdispenserNum() {
        return WaterdispenserNum;
    }

    public void setWaterdispenserNum(int waterdispenserNum) {
        WaterdispenserNum = waterdispenserNum;
    }

    public int getElectricboardNum() {
        return electricboardNum;
    }

    public void setElectricboardNum(int electricboardNum) {
        this.electricboardNum = electricboardNum;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
