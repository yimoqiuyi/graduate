package com.yp.subpark.jsonUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Group;

import java.util.List;

public class GroupToJson {
    public static JSONArray GroupInfoToJson(List<Group> groupList){
      JSONArray jsonArray = new JSONArray();
      if(groupList!=null&& groupList.size()>0) {
          for (Group group : groupList) {
              JSONObject jsonObject = new JSONObject();
              jsonObject.put("groupId", group.getGroupId());
              jsonObject.put("groupName", group.getGroupName());
              jsonObject.put("groupIntroduce",group.getGroupIntroduce());
              jsonObject.put("attendancePass",group.getAttendancePass());
              jsonObject.put("groupWorkHealthPass",group.getGroupWorkHealthPass());
              jsonObject.put("groupWorkAttendancePass",group.getGroupWorkAttendancePass());
              jsonObject.put("userId",group.getUserId());
              jsonObject.put("state",group.getState());
              jsonObject.put("subParkId",group.getSubParkId());
              jsonArray.add(jsonObject);
          }
      }
      return jsonArray;
    }
}
