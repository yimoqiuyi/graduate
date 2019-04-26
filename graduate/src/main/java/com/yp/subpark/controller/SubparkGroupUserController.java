package com.yp.subpark.controller;

import com.yp.common.pojo.User;
import com.yp.common.service.GroupService;
import com.yp.common.service.RoomService;
import com.yp.common.service.UserService;
import com.yp.common.service.WorkPositionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("subpark")
public class SubparkGroupUserController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private WorkPositionService workPositionService;

    @RequestMapping("selectGroupUser")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectGroupUser(ModelAndView modelAndView, HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userService.selectOneUserById(userId);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("view/subpark/User");
        return modelAndView;
    }

    @RequestMapping("updateGroupUser")
    @RequiresPermissions("role:insert")
    public String UpdateGroupUser(User user) {
        userService.updateOneUser(user);
        return "view/subpark/index";
    }

    @RequestMapping("deleteGroupUser")
    @RequiresPermissions("role:insert")
    public String DeleteGroupUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        userService.deleteOneUserById(userId);
        return "view/subpark/index";
    }
}
