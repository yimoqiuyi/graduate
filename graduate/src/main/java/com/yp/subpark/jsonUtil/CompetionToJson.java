package com.yp.subpark.jsonUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Competition;

import java.util.List;

public class CompetionToJson {
    public static JSONArray CompetionInfoToJson(List<Competition> competitionList) {
        JSONArray jsonArray = new JSONArray();
        if (competitionList != null && competitionList.size() > 0) {
            for (Competition competition : competitionList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("competitionId", competition.getCompetitionId());
                jsonObject.put("competitionName", competition.getCompetitionName());
                jsonObject.put("competitionLevel", competition.getCompetitionLevel());
                jsonObject.put("sponsor", competition.getSponsor());
                jsonObject.put("nameofMember", competition.getNameofMember());
                jsonObject.put("awardLevel", competition.getAwardLevel());
                jsonObject.put("competitionAuditTime", competition.getCompetitionAuditTime());
                jsonObject.put("competitionPath", competition.getCompetitionPath());
                jsonObject.put("competitionState", competition.getCompetitionState());
                jsonObject.put("groupId", competition.getGroupId());
                jsonObject.put("achievementsId", competition.getAchievementsId());
                jsonObject.put("subParkId", competition.getSubParkId());
                jsonObject.put("generalParkId", competition.getGeneralParkId());
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray;
    }
}