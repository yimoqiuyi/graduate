package com.yp.common.pojo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Building implements Serializable {
    private int buildId;
    private String floorPicture;//楼层平面图
    private int roomNumber;//房间总数
    private String buildStation;//栋所在位置
    private int subParkId;//分园区外键
    private int generalParkId;//总园区外键
    private List<Room> roomList;

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    public String getFloorPicture() {
        return floorPicture;
    }

    public void setFloorPicture(String floorPicture) {
        this.floorPicture = floorPicture;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuildStation() {
        return buildStation;
    }

    public void setBuildStation(String buildStation) {
        this.buildStation = buildStation;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildId=" + buildId +
                ", floorPicture='" + floorPicture + '\'' +
                ", roomNumber=" + roomNumber +
                ", buildStation='" + buildStation + '\'' +
                ", subParkId=" + subParkId +
                ", generalParkId=" + generalParkId +
                ", roomList=" + roomList +
                ", Rooms=" + Rooms +
                '}';
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

    public ArrayList<Room> getRooms() {
        return Rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        Rooms = rooms;
    }

    private ArrayList<Room> Rooms;   //房间集合




}
