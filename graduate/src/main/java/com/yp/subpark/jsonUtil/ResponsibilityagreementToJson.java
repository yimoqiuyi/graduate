package com.yp.subpark.jsonUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
 import com.yp.common.pojo.Responsibilityagreement;

import java.util.List;

public class ResponsibilityagreementToJson {
    public static JSONArray responsibilityagreementInfoToJson(List<Responsibilityagreement> responsibilityagreementList) {
        JSONArray jsonArray = new JSONArray();
        if (responsibilityagreementList != null && responsibilityagreementList.size() > 0) {
            for (Responsibilityagreement responsibilityagreement : responsibilityagreementList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("responsibleId", responsibilityagreement.getResponsibleId());
                jsonObject.put("responsibleName", responsibilityagreement.getResponsibleName());
                jsonObject.put("responsibleIntroduce", responsibilityagreement.getResponsibleIntroduce());
                jsonObject.put("filePath", responsibilityagreement.getFilePath());
                jsonObject.put("signDate", responsibilityagreement.getSignDate());
                jsonObject.put("argeementId", responsibilityagreement.getArgeementId());
                jsonObject.put("expirationDate", responsibilityagreement.getExpirationDate());
                jsonObject.put("groupId", responsibilityagreement.getGroupId());
                jsonObject.put("subParkId", responsibilityagreement.getSubParkId());
                jsonObject.put("generalParkId", responsibilityagreement.getGeneralParkId());
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray;
    }
}
