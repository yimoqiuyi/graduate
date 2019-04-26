package com.yp.role.controller;

import com.yp.common.pojo.*;
import com.yp.common.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//团队成员，角色
@Controller
@RequestMapping("role")
public class GroupRoleUserController {
    @Autowired
    private WorkPositionService workPositionService;
    @Autowired
    private SanitationService sanitationService;  //卫生
    @Autowired
    private AttendanceService attendanceService; //考勤
    @Autowired
    private WorkstylePictureService workstylePictureService;
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;

    @RequestMapping("person")
    @RequiresPermissions(value = "user:insert")
    public ModelAndView ViewOneSelfPositionById(ModelAndView modelAndView, HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("userId"));
        System.out.print("从GroupUser获得的Id是" + id);
        User user = userService.selectOneUserById(id);
        int workId = user.getWorkId();
        int userId = user.getUserId();
//        List<Sanitation> sanitationList = sanitationService.selectSanitationByUserId(userId);
//        List<Attendance> attendanceList = attendanceService.selectAttendanceByUserId(userId);
//        WorkPosition workPosition = workPositionService.selectOneWorkPositionById(workId);
//        WorkstylePicture workstylePicture = workstylePictureService.selectWorkstylePictureByworkId(workId);
        modelAndView.addObject("user", user); //用户
        modelAndView.setViewName("view/group/viewGroupUser");
        return modelAndView;
    }

    @RequestMapping("updateUser")
    @RequiresPermissions(value = "user:insert")
    public String updateUser(User user) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user1 = (User) session.getAttribute("user");
        int groupId = user1.getGroupId();
        Group group = groupService.selectOneGroupById(groupId);
        user.setGroupId(groupId);
        user.setSubParkId(group.getSubParkId());
        userService.updateOneUser(user);
        return "view/group/index";
    }

    //注册
    @RequestMapping("insert")
    @RequiresPermissions(value = "user:insert")
    public String Insert(HttpServletRequest request) {
        return "view/group/RegistUser";
    }

    @RequestMapping("regist")
    @RequiresPermissions(value = "user:insert")
    public String Regist(User user) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user1 = (User) session.getAttribute("user");
        int groupId = user1.getGroupId();
        user.setAwayTime("0");
        user.setSanitationScore(100);
        user.setAttendanceScore(100);
        user.setWorkSanitation("100%");
        user.setWorkRatio("100%");
        user.setState(1);
        user.setGroupId(groupId);
        user.setSubParkId(1);  //注册队员都为同队同分园区的人
         userService.insertOneUser(user);
        return "view/user/index";
    }

    @RequestMapping("updateuser")
    @RequiresPermissions(value = "user:insert")
    public ModelAndView UpdateUser(ModelAndView modelAndView, HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectOneUserById(userId);
        modelAndView.addObject("user", user); //用户
        modelAndView.setViewName("view/group/updateUser");
        return modelAndView;
    }

    @RequestMapping("deleteuser")
    @RequiresPermissions(value = "user:delete")
    public String DeleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userService.selectOneUserById(userId);
        user.setState(0);
        userService.updateOneUser(user);
        return "view/group/index";
     }
}
