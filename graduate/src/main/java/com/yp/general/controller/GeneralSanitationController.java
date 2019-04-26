package com.yp.general.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Echart;
import com.yp.common.pojo.Group;
import com.yp.common.pojo.Sanitation;
import com.yp.common.pojo.User;
import com.yp.common.service.GroupService;
import com.yp.common.service.SanitationService;
import com.yp.common.service.UserService;
import com.yp.common.service.WorkhealthService;
import com.yp.subpark.jsonUtil.GroupToJson;
import com.yp.user.jsonUtil.UserToJson;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//卫生操作类

@Controller
@RequestMapping("general")
public class GeneralSanitationController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private SanitationService sanitationService;
    @Autowired
    private WorkhealthService workhealthService;
    @Autowired
    private UserService userService;

    @RequestMapping("subparkSanitation")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SubparkSanitation(ModelAndView modelAndView, HttpServletRequest request) {
        String subParkId = request.getParameter("subParkId");
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/general/SubparkSanitation");
        return modelAndView;
    }

    @RequestMapping("generalSanitation")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> checkGroup(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        List<Group> groupList = groupService.selectGroupByLimit(subParkId, page, limit);
        JSONArray groupData = GroupToJson.GroupInfoToJson(groupList);
        if (groupData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", groupData.size());
            jsonObject.put("data", groupData);
            return jsonObject;
        }
        return null;
    }

    //模糊查询
    @RequestMapping("fuzzyGroupSanitation")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView FuzzyGroupSanitation(ModelAndView modelAndView,
                                             @RequestParam("subParkId") String subParkId,
                                             @RequestParam("condition") String condition) {
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.addObject("condition", condition);
        modelAndView.setViewName("view/general/FuzzyGroupSanitation");
        return modelAndView;
    }

    @RequestMapping("fuzzyGroupSanitation1")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> checkUser(HttpServletRequest request, Integer page, Integer limit) {
        String condition = request.getParameter("condition");
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        Map<String, Object> map = new HashMap<>();
        map.put("subParkId", subParkId);
        map.put("condition", condition);
        map.put("page", page);
        map.put("limit", limit-1);
        List<Group> groupList = groupService.selectGroupByCondition(map);
        JSONArray groupDate = GroupToJson.GroupInfoToJson(groupList);
        if (groupDate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", groupDate.size());
            jsonObject.put("data", groupDate);
            return jsonObject;
        }
        return null;
    }

    //团队卫生
    @RequestMapping("groupSanitation")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView GroupSanitation(HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/general/GroupSanitation");
        return modelAndView;
    }

    @RequestMapping("checkUserSanitation")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> CheckUserSanitation(HttpServletRequest request, Integer page, Integer limit) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<User> userList = userService.selectUserBygrouIdAndPage(groupId, page, limit);
        JSONArray userData = UserToJson.UserInfoToJson(userList);
        if (userData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", userData.size());
            jsonObject.put("data", userData);
            return jsonObject;
        }
        return null;
    }
    @RequestMapping("selectUserSanitation")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView  SelectUserSanitation(ModelAndView modelAndView,HttpServletRequest request){
         int userId=Integer.parseInt(request.getParameter("userId"));
        System.out.println("所得员工工号"+userId);
        List<Sanitation> sanitationList=sanitationService.selectSanitationByUserId(userId);
        User user=userService.selectOneUserById(userId);
        modelAndView.addObject("user",user);
        modelAndView.addObject("sanitationList",sanitationList);
        modelAndView.setViewName("view/general/SubparkUserSanitation");
        return modelAndView;
    }

    //卫生柱状图
    @RequestMapping("sanitationHistogram")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SanitationHistogram(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/general/SanitationHistogram");
        return modelAndView;
    }

    @RequestMapping(value = "checkSanitationHistogram",method = RequestMethod.POST)
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> CheckUserHistogram(HttpServletRequest request, Integer page, Integer limit) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<User> users = userService.selectAllUserBygroupId(groupId); //查看所有的成员
        Echart echart = new Echart();
        List<String> categories = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (User user : users) {
            String userName = user.getUserName();
            int sanitationScore = user.getSanitationScore();
            categories.add(userName);
            data.add(sanitationScore);
        }
        echart.setCategories(categories);
        echart.setData(data);
        JSONObject jsonObj = (JSONObject) JSONArray.toJSON(echart);
        return jsonObj;
    }

    //卫生曲线图
    @RequestMapping("sanitationGraph")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SanitationGraph(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/general/SanitationGraph");
        return modelAndView;
    }

    @RequestMapping(value = "checkSanitationGraph",method = RequestMethod.POST)
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> CheckSanitationGraph(HttpServletRequest request, Integer page, Integer limit) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<User> users = userService.selectAllUserBygroupId(groupId); //查看所有的成员
        Echart echart = new Echart();
        List<String> categories = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (User user : users) {
            String userName = user.getUserName();
            int sanitationScore = user.getSanitationScore();
            categories.add(userName);
            data.add(sanitationScore);
        }
        echart.setCategories(categories);
        echart.setData(data);
        JSONObject jsonObj = (JSONObject) JSONArray.toJSON(echart);
        return jsonObj;
    }

}
