package com.yp.user.jsonUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.User;

import java.util.List;


public class UserToJson {
    public static JSONArray UserInfoToJson(List<User> userList){
        JSONArray jsonArray = new JSONArray();
        if(userList!=null&& userList.size()>0) {
            for (User user : userList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("userId", user.getUserId());
                jsonObject.put("userName", user.getUserName());
                jsonObject.put("joinTime",user.getJoinTime());
                jsonObject.put("awayTime",user.getAwayTime());
                jsonObject.put("sex",user.getSex());
                jsonObject.put("age",user.getAge());
                jsonObject.put("phone",user.getPhone());
                jsonObject.put("cardNumber",user.getCardNumber());
                jsonObject.put("email",user.getEmail());
                jsonObject.put("address",user.getAddress());
                jsonObject.put("sanitationScore",user.getSanitationScore());
                jsonObject.put("attendanceScore",user.getAttendanceScore());
                jsonObject.put("workRatio",user.getWorkRatio());
                jsonObject.put("workSanitation",user.getWorkSanitation());
                jsonObject.put("state",user.getState());
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray;
    }
}
