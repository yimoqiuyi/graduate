package com.yp.subpark.jsonUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Paper;
import com.yp.common.pojo.Performance;

import java.util.List;

public class PaperToJson {
    public static JSONArray PaperInfoToJson(List<Paper> paperList) {
        JSONArray jsonArray = new JSONArray();
        if (paperList != null && paperList.size() > 0) {
            for (Paper paper : paperList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("paperId", paper.getPaperId());
                jsonObject.put("paperName", paper.getPaperName());
                jsonObject.put("authors", paper.getAuthors());
                jsonObject.put("authorUnit", paper.getAuthorUnit());
                jsonObject.put("journalName", paper.getJournalName());
                jsonObject.put("paperAuditTime", paper.getPaperAuditTime());
                jsonObject.put("grade", paper.getGrade());
                jsonObject.put("paperState", paper.getPaperState());
                jsonObject.put("subParkId", paper.getSubParkId());
                jsonObject.put("groupId", paper.getGroupId());
                jsonObject.put("generalParkId", paper.getGeneralParkId());
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray;
    }
}
