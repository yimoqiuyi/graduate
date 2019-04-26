package com.yp.subpark.jsonUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Performance;

import java.util.List;
//¼¨Ð§json
public class PerformacneToJson {
    public static JSONArray PerformacneInfoToJson(List<Performance> performanceList) {
        JSONArray jsonArray = new JSONArray();
        if (performanceList != null && performanceList.size() > 0) {
            for (Performance performance : performanceList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("performanceId", performance.getPerformanceId());
                jsonObject.put("groupName", performance.getGroupName());
                jsonObject.put("performanceScore", performance.getPerformanceScore());
                jsonObject.put("startTime", performance.getStartTime());
                jsonObject.put("endTime", performance.getEndTime());
                jsonObject.put("groupId", performance.getGroupId());
                jsonObject.put("subParkId", performance.getSubParkId());
                jsonObject.put("generalParkId", performance.getGeneralParkId());
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray;
    }
}
