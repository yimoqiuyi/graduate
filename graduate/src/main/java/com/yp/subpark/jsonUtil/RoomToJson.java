package com.yp.subpark.jsonUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Room;

import java.util.List;

public class RoomToJson {
    public static JSONArray RoomInfoToJson(List<Room> roomList){
        JSONArray jsonArray = new JSONArray();
        if (roomList != null && roomList.size() > 0){
            for(Room room:roomList){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("roomId",room.getRoomId());
                jsonObject.put("roomPosition",room.getRoomPosition());
                jsonObject.put("roomPicture",room.getRoomPicture());
                jsonObject.put("stationNumber",room.getStationNumber());
                jsonObject.put("buildId",room.getBuildId());
                jsonObject.put("subparkId",room.getSubParkId());
                jsonObject.put("generalParkId",room.getGeneralParkId());
                jsonArray.add(jsonObject);
            }
         }
        return jsonArray;
    }
}
