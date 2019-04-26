package com.yp.role.controller;

import com.yp.common.pojo.*;
import com.yp.common.service.AttendanceService;
import com.yp.common.service.GroupService;
import com.yp.common.service.UserService;
import com.yp.common.service.WorkAttendanceService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//操作团队考勤情况
@Controller
@RequestMapping("group")
public class GroupattendanceController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private UserService userService;
    @Autowired
    private WorkAttendanceService workAttendanceService;

    @RequestMapping("addUserattendancetoUser")
    @RequiresRoles("group")   //只能团队操作
    public ModelAndView addUserAttendancetoUser(@RequestParam("userId") String userId, ModelAndView modelAndView,
                                                @RequestParam("attendanceId") String[] attendanceId) {
        List list = Arrays.asList(attendanceId); //考勤类型集合
        int id = Integer.parseInt(userId);
        User user = userService.selectOneUserById(id);
        WorkAttendance workAttendance = new WorkAttendance();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            int attendanceid = Integer.parseInt(iterator.next());
            workAttendance.setUserId(id);
            workAttendance.setAttendanceId(attendanceid);
            workAttendanceService.insertOneWorkAttendance(workAttendance);//向工位考勤表中添加数据
        }
        return modelAndView;
    }

    @RequestMapping("userAttendance")
    public ModelAndView userAttendance(HttpServletRequest request, ModelAndView modelAndView) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userService.selectOneUserById(userId);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("view/group/Attendance");
        return modelAndView;
    }

    @RequestMapping("selectUserAttendance")
    @RequiresPermissions("role:select")
    public ModelAndView selectUserAttendance(ModelAndView modelAndView, HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Attendance> attendanceList = attendanceService.selectAttendanceByUserId(userId);
        User user = userService.selectOneUserById(userId);
        modelAndView.addObject("user", user);
        modelAndView.addObject("attendanceList", attendanceList);
        modelAndView.setViewName("view/group/AttendanceUser");
        return modelAndView;
    }

    @RequestMapping("insertAttendance")
    @RequiresRoles("group")
    public ModelAndView insertAttendance(ModelAndView modelAndView, HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userService.selectOneUserById(userId);
        List<Attendance> attendanceList = attendanceService.selectAllAttendance();
        modelAndView.addObject("user", user);
        modelAndView.addObject("attendanceList", attendanceList);
        modelAndView.setViewName("view/group/AttendanceAddtoUser");
        return modelAndView;
    }

    @RequestMapping("insertToAttendance")
    @RequiresRoles("group")
    public String insertToAttendance(Integer userId, @Param("attendanceId") String attendanceId[]) {
        int id = 0;
        int score = 0;
        User user = userService.selectOneUserById(userId);
        WorkAttendance workAttendance = null;
        for (int i = 0; i < attendanceId.length; i++) {
            id = Integer.parseInt(attendanceId[i]);
            Attendance attendance = attendanceService.selectOneAttendanceById(id);
            workAttendance = new WorkAttendance();
            workAttendance.setUserId(userId);
            workAttendance.setAttendanceId(id);
            score += attendance.getAttendanceScore();
            workAttendanceService.insertOneWorkAttendance(workAttendance);
        }
        user.setAttendanceScore(user.getAttendanceScore() - score);
        userService.updateOneUser(user);
        return "view/group/index";
    }
}
