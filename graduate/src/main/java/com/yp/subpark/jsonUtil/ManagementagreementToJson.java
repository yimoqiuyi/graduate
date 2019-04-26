package com.yp.subpark.jsonUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Managementagreement;

import java.util.List;

public class ManagementagreementToJson {
    public static JSONArray managementagreementInfoToJson(List<Managementagreement> managementagreementList) {
        JSONArray jsonArray = new JSONArray();
        if (managementagreementList != null && managementagreementList.size() > 0) {
            for (Managementagreement managementagreement : managementagreementList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("managementId", managementagreement.getManagementId());
                jsonObject.put("managementName", managementagreement.getManagementName());
                jsonObject.put("managementIntroduce", managementagreement.getManagementIntroduce());
                jsonObject.put("filePath", managementagreement.getFilePath());
                jsonObject.put("signDate", managementagreement.getSignDate());
                jsonObject.put("expirationDate", managementagreement.getExpirationDate());
                jsonObject.put("groupId", managementagreement.getGroupId());
                jsonObject.put("subParkId", managementagreement.getSubParkId());
                jsonObject.put("generalParkId", managementagreement.getGeneralParkId());
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray;
    }
}
