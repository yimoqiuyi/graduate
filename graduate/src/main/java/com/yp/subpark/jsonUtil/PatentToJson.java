package com.yp.subpark.jsonUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Group;
import com.yp.common.pojo.Patent;

import java.util.List;

public class PatentToJson {
    public static JSONArray PatentInfoToJson(List<Patent> patentList){
        JSONArray jsonArray = new JSONArray();
        if(patentList!=null&& patentList.size()>0) {
            for (Patent patent : patentList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("patentId", patent.getPatentId());
                jsonObject.put("patentCategory", patent.getPatentCategory());
                jsonObject.put("patentName",patent.getPatentName());
                jsonObject.put("patentPeopleName",patent.getPatentPeopleName());
                jsonObject.put("patentCreatePeopleName",patent.getPatentCreatePeopleName());
                jsonObject.put("patentApplyTime",patent.getPatentApplyTime());
                jsonObject.put("patentApplyNumber",patent.getPatentApplyNumber());
                jsonObject.put("dateofAuthorization",patent.getDateofAuthorization());
                jsonObject.put("patentState",patent.getPatentState());
                jsonObject.put("subParkId", patent.getSubParkId());
                jsonObject.put("groupId", patent.getGroupId());
                jsonObject.put("generalParkId", patent.getGeneralParkId());
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray;
    }
}
