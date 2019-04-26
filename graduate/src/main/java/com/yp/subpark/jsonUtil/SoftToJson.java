package com.yp.subpark.jsonUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Paper;
import com.yp.common.pojo.Software;

import java.util.List;

public class SoftToJson {
    public static JSONArray SoftWareInfoToJson(List<Software> softwareList) {
        JSONArray jsonArray = new JSONArray();
        if (softwareList != null && softwareList.size() > 0) {
            for (Software software : softwareList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("softId", software.getSoftId());
                jsonObject.put("softName", software.getSoftName());
                jsonObject.put("softPeopleMame", software.getSoftPeopleMame());
                jsonObject.put("softGrade", software.getSoftGrade());
                jsonObject.put("dateofAuthorization", software.getDateofAuthorization());
                jsonObject.put("certificateNumber", software.getCertificateNumber());
                jsonObject.put("registrationNumber", software.getRegistrationNumber());
                jsonObject.put("softDocument", software.getSoftDocument());
                jsonObject.put("softwareAuditTime", software.getSoftwareAuditTime());
                jsonObject.put("softwareState", software.getSoftwareState());
                jsonObject.put("groupId", software.getGroupId());
                jsonObject.put("achievementsId", software.getAchievementsId());
                jsonObject.put("subParkId", software.getSubParkId());
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray;
    }
}
