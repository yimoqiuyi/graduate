package com.yp.subpark.jsonUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Admissioncontract;

import java.util.List;

public class AdmissioncontractToJson {
    public static JSONArray admissioncontractInfoToJson(List<Admissioncontract> admissioncontractList) {
        JSONArray jsonArray = new JSONArray();
        if (admissioncontractList != null && admissioncontractList.size() > 0) {
            for (Admissioncontract admissioncontract : admissioncontractList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("admissionId", admissioncontract.getAdmissionId());
                jsonObject.put("admissionName", admissioncontract.getAdmissionName());
                jsonObject.put("admissionIntroduce", admissioncontract.getAdmissionIntroduce());
                jsonObject.put("filePath", admissioncontract.getFilePath());
                jsonObject.put("agreementId", admissioncontract.getAgreementId());
                jsonObject.put("signDate", admissioncontract.getSignDate());
                jsonObject.put("expirationDate", admissioncontract.getExpirationDate());
                jsonObject.put("groupId", admissioncontract.getGroupId());
                jsonObject.put("subParkId", admissioncontract.getSubParkId());
                jsonObject.put("generalParkId", admissioncontract.getGeneralParkId());
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray;
    }
}