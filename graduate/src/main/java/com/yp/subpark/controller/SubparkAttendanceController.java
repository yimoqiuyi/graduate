package com.yp.subpark.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Attendance;
import com.yp.common.pojo.Group;
import com.yp.common.pojo.User;
import com.yp.common.service.*;
import com.yp.subpark.jsonUtil.GroupToJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.omg.PortableInterceptor.INACTIVE;
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
public class SubparkAttendanceController {
    @Autowired
    private SubParkService subParkService;  //园区
    @Autowired
    private GroupService groupService;  //团队
    @Autowired
    private UserService userService;   //队员
    @Autowired
    private AttendanceService attendanceService;  //考勤
    @Autowired
    private WorkAttendanceService workAttendanceService;
    @RequestMapping("subparkAttendance")
    @RequiresPermissions("role:insert")
    public String SubparkAttendance(){
        return "view/subpark/SubparkAttendance";
    }
    @RequestMapping("selectGroupAttendance")
    @RequiresPermissions("role:insert")
    public  @ResponseBody
    Map<String, Object> SelectGroupAttendance(Integer page,Integer limit){
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
    //考勤
    @RequestMapping("attendanceOperation")
    @RequiresPermissions("role:insert")
    public ModelAndView AttendanceOperation(ModelAndView modelAndView){
        List<Attendance> attendanceList=attendanceService.selectAllAttendance();
        modelAndView.addObject("attendanceList",attendanceList);
        modelAndView.setViewName("view/subpark/AttendanceOperation");
        return modelAndView;
    }
    //添加考勤
    @RequestMapping("addAttendance")
    @RequiresPermissions("role:insert")
    public String AddAttendance(){
        return "view/common/AddAttendance";
    }
    @RequestMapping("insertAttendacne")
    @RequiresPermissions("role:insert")
    public String InsertAttendance(Attendance attendance){
        attendanceService.insertAttendance(attendance);
        return "view/subpark/index";
    }

    //修改考勤
    @RequestMapping("updateAttendance")
    @RequiresPermissions("role:insert")
    public ModelAndView  updateAttendace(ModelAndView modelAndView,HttpServletRequest request){
        Attendance attendance=attendanceService.selectOneAttendanceById(Integer.parseInt(request.getParameter("attendanceId")));
        modelAndView.addObject("attendance",attendance);
        modelAndView.setViewName("view/common/SubparkAttendance");
        return modelAndView;
    }
    @RequestMapping("updateToAttendacne")
    @RequiresPermissions("role:insert")
    public String UpdateToAttendacne(Attendance attendance){
        attendanceService.updateAttendance(attendance);
        return "view/subpark/index";
    }
    //删除考勤
    @RequestMapping("deleteAttendance")
    @RequiresPermissions("role:insert")
    public String DeleteAttendance(HttpServletRequest request){
        attendanceService.delectOneAttendanceByid(Integer.parseInt(request.getParameter("attendanceId")));
        return "redirect:attendanceOperation.do";
    }



    //团队考勤
     @RequestMapping("groupAttendance")
    @RequiresPermissions("role:insert")
    public ModelAndView GroupAttendance(ModelAndView modelAndView,HttpServletRequest request){
         List<User> userList=userService.selectAllUserBygroupId(Integer.parseInt(request.getParameter("groupId")));
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("view/subpark/GroupAttendacne");
        return modelAndView;
    }
    //用户考勤查看操作
    @RequestMapping("selectUserAttendacne")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectUserAttendacne(HttpServletRequest request,ModelAndView modelAndView){
        int userId=Integer.parseInt(request.getParameter("userId"));
        List<Attendance> attendanceList=attendanceService.selectAttendanceByUserId(userId);
        User user=userService.selectOneUserById(userId);
        modelAndView.addObject("user",user);
        modelAndView.addObject("attendanceList",attendanceList);
        modelAndView.setViewName("view/subpark/SubparkUserAttendance");
        return modelAndView;
    }

    //用户查看考勤删除,用户考勤重新部署
    @RequestMapping("deleteUserAttendance")
    @RequiresPermissions("role:insert")
    public String DeleteUserAttendance(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        workAttendanceService.deleteWorkAttendacneByUserId(userId);
        User user=userService.selectOneUserById(userId);
        user.setAttendanceScore(100);
        user.setWorkRatio("100%");
        userService.updateOneUser(user);
        return "view/subpark/index";
    }
}
