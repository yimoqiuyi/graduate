package com.yp.subpark.controller;

import com.yp.common.pojo.*;
import com.yp.common.service.*;
import com.yp.common.utils.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//只显示团队考勤，卫生，任务信息,园区信息操作
@Controller
@RequestMapping("subpark")
public class SubparkController {
    @Autowired
    private SubParkService subParkService;    //分园区
    @Autowired
    private GroupService groupService;    //团队
    @Autowired
    private UserService userService;     //用户
    @Autowired
    private SanitationService sanitationService; //卫生
    @Autowired
    private AttendanceService attendanceService; //考勤
    @Autowired
    private AchievementsNumberService achievementsNumberService; //团队成果表

    @RequestMapping("selectSanitation")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectSanitation(HttpServletRequest request, ModelAndView modelAndView) {
        List<User> userList = userService.selectAllUserBygroupId(Integer.parseInt(request.getParameter("groupId")));
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("view/subpark/SubparkGroupSanitation");
        return modelAndView;
    }
//
//    @RequestMapping("selectUserSanitation")
//    @RequiresPermissions("role:insert")
//    public ModelAndView SelectUserSanitation(HttpServletRequest request, ModelAndView modelAndView) {
//        int userId = Integer.parseInt(request.getParameter("userId"));
//        List<Sanitation> sanitationList = sanitationService.selectSanitationByUserId(userId);
//        User user = userService.selectOneUserById(userId);
//        modelAndView.addObject("user", user);
//        modelAndView.addObject("sanitationList", sanitationList);
//        modelAndView.setViewName("view/subpark/SubparkUserSanitation");
//        return modelAndView;
//    }

    @RequestMapping("selectAttendance")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectAttendance(HttpServletRequest request, ModelAndView modelAndView) {
        List<User> userList = userService.selectAllUserBygroupId(Integer.parseInt(request.getParameter("groupId")));
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("view/subpark/SubparkGroupAttendance");
        return modelAndView;
    }

    @RequestMapping("selectUserAttendance")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectUserAttendance(HttpServletRequest request, ModelAndView modelAndView) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Attendance> attendanceList = attendanceService.selectAttendanceByUserId(userId);
        User user = userService.selectOneUserById(userId);
        modelAndView.addObject("user", user);
        modelAndView.addObject("attendanceList", attendanceList);
        modelAndView.setViewName("view/subpark/SubparkUserAttendance");
        return modelAndView;
    }

    @RequestMapping("selectAchievementsNumber")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectAchievementsNumber(HttpServletRequest request, ModelAndView modelAndView) {
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(Integer.parseInt(request.getParameter("groupId")));
        modelAndView.addObject("achievementsNumber", achievementsNumber);
        modelAndView.setViewName("view/subpark/SubparkGroupAchievementsNumber");
        return modelAndView;
    }

    //查看分园区信息
    @RequestMapping("checkSubpark")
    @RequiresPermissions("role:insert")
    public ModelAndView CheckSubpark(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subParkId = user.getSubParkId();
        SubPark subPark = subParkService.selectOneSubParkById(subParkId);
        modelAndView.addObject("subPark", subPark);
        modelAndView.setViewName("view/subpark/Subpark");
        return modelAndView;
    }

    //修改分园区信息
    @RequestMapping("updateSubpark")
    @RequiresPermissions("role:insert")
    public ModelAndView UpdateSubpark(ModelAndView modelAndView, Integer subParkId) {
        SubPark subPark = subParkService.selectOneSubParkById(subParkId);
        modelAndView.addObject("subPark", subPark);
        modelAndView.setViewName("view/subpark/UpdateSubpark");
        return modelAndView;
    }

    @RequestMapping(value = "updateToSubpark", method = RequestMethod.POST)
    @RequiresPermissions("role:insert")
    public String UpdateToSubpark(@RequestParam(value = "file", required = false) MultipartFile multipartFile, SubPark subPark) {
        FileUtils fileUtils = new FileUtils();
        String s = fileUtils.UploadSubparkPicture(multipartFile);
        subPark.setSubParkPicture(s);
        subParkService.updateOneSubPark(subPark);
        return "redirect:checkSubpark.do";
    }
}
