package com.yp.general.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yp.common.pojo.Group;
import com.yp.common.pojo.User;
import com.yp.common.service.GroupService;
import com.yp.common.service.SubParkService;
import com.yp.common.service.UserService;
import com.yp.subpark.jsonUtil.GroupToJson;
import com.yp.user.jsonUtil.UserToJson;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("general")
public class GeneralGroupController {
    @Autowired
    private SubParkService subParkService;  //分园区操作
    @Autowired
    private GroupService groupService; //团队操作
    @Autowired
    private UserService userService; //用户
    @RequestMapping("GroupManagement")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView GroupManagement(ModelAndView modelAndView, HttpServletRequest request) {
        String subParkId = request.getParameter("subParkId");
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/general/SubparkGroup");
        return modelAndView;
    }

    @RequestMapping("checkGroup")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> checkGroup(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        List<Group> groups=groupService.selectAllGroupBysubParkId(subParkId); //查看所有的成员
        PageHelper.startPage(page,limit);
        List<Group> groupList=groupService.selectAllGroupBysubParkId(subParkId);  //分页查看成员
         JSONArray groupData = GroupToJson.GroupInfoToJson(groupList);
        if (groupData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", groups.size());
            jsonObject.put("data", groupData);
            return jsonObject;
        }
        return null;
    }
    @RequestMapping("selectGroup")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView GroupUser(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId=Integer.parseInt(request.getParameter("groupId"));
         modelAndView.addObject("groupId", groupId);
         modelAndView.setViewName("view/general/GroupUser");
         return modelAndView;
    }
   @RequestMapping("checkUser")
   @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
   Map<String, Object> checkUser(HttpServletRequest request, Integer page, Integer limit) {
       int groupId = Integer.parseInt(request.getParameter("groupId"));
       List<User> users=userService.selectAllUserBygroupId(groupId); //查看所有的成员
       PageHelper.startPage(page,limit);
       List<User> userList=userService.selectAllUserBygroupId(groupId); //分页查看成员
       JSONArray userData = UserToJson.UserInfoToJson(userList);
       if (userData != null) {
           JSONObject jsonObject = new JSONObject();
           jsonObject.put("code", 0);
           jsonObject.put("msg", "");
           jsonObject.put("count", users.size());
           jsonObject.put("data", userData);
           return jsonObject;
       }
       return null;
   }
   @RequestMapping("selectUser")
   @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView selectUser(HttpServletRequest request, ModelAndView modelAndView){
        User user=userService.selectOneUserById(Integer.parseInt(request.getParameter("userId")));
        modelAndView.addObject("user",user);
        modelAndView.setViewName("view/general/User");
        return modelAndView;
   }
 }
