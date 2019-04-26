package com.yp.subpark.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Group;
import com.yp.common.pojo.User;
import com.yp.common.service.GroupService;
import com.yp.common.service.RoomService;
import com.yp.common.service.UserService;
import com.yp.common.service.WorkPositionService;
import com.yp.subpark.jsonUtil.GroupToJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("subpark")
public class SubparkGroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private WorkPositionService workPositionService;

    @RequestMapping("GroupManagement")
    @RequiresPermissions("role:insert")
    public String GroupManagement() {
        return "view/subpark/SubparkGroup";
    }

    @RequestMapping("checkGroup")
    @RequiresPermissions("role:insert")
    public @ResponseBody
    Map<String, Object> checkGroup(ModelAndView modelAndView, Integer page, Integer limit) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subParkId = user.getSubParkId();
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
     @RequestMapping("selectGroup")
    @RequiresPermissions("role:insert")
    public ModelAndView GroupUser(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<User> userList = userService.selectAllUserBygroupId(groupId);
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("view/subpark/GroupUser");
        return modelAndView;
    }

    //注册团队
    @RequestMapping("registGroup")
    @RequiresPermissions("role:insert")
    public ModelAndView RegistGroup(ModelAndView modelAndView, HttpServletRequest request) {
        String subParkId = request.getParameter("subParkId");
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/subpark/RegistGroup");
        return modelAndView;
    }

    //添加团队
    @RequestMapping("insertGroup")
    @RequiresPermissions("role:insert")
    public String InsertGroup(Group group) {
        groupService.insertOneGroup(group);
        return "view/subpark/index";
    }

    @RequestMapping("deleteGroup")
    @RequiresPermissions("role:insert")

    public String DeleteGroup(HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        groupService.delectOneGroupByid(groupId);
        return "view/subpark/index";
    }
}
