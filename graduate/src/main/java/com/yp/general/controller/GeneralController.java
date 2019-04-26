package com.yp.general.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.SubPark;
import com.yp.common.pojo.User;
import com.yp.common.service.GeneralParkService;
import com.yp.common.service.SubParkService;
import com.yp.common.service.UserService;
import com.yp.user.jsonUtil.UserToJson;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("general")
public class GeneralController {
    @Autowired
    private GeneralParkService generalParkService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubParkService subParkService;

    //模糊查询
    @RequestMapping("selectGeneralUser")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView selectGeneralUser(@RequestParam(value = "condition", required = false) String condition, ModelAndView modelAndView,Integer groupId) {
        modelAndView.addObject("condition", condition);
        modelAndView.addObject("groupId",groupId);
        modelAndView.setViewName("view/general/ConditionUser");
        return modelAndView;
    }

    @RequestMapping("selectGeneralGroupUser")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> checkUser(HttpServletRequest request, Integer page, Integer limit) {
        String condition = request.getParameter("condition");
        int groupId=Integer.parseInt(request.getParameter("groupId"));
        Map<String, Object> map = new HashMap<>();
        map.put("condition", condition);
        map.put("groupId",groupId);
        map.put("page", page);
        map.put("limit", limit);
        List<User> userList = userService.selectUserByCondition(map);
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

    //查看分园区信息
    @RequestMapping("checkSubpark")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView CheckSubpark(ModelAndView modelAndView,HttpServletRequest request) {
         int subParkId=Integer.parseInt(request.getParameter("subParkId"));
        SubPark subPark = subParkService.selectOneSubParkById(subParkId);
        modelAndView.addObject("subPark", subPark);
        modelAndView.addObject("subParkId",subParkId);
        modelAndView.setViewName("view/general/Subpark");
        return modelAndView;
    }

}
