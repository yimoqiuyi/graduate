package com.yp.user.controller;

import com.yp.common.pojo.Group;
import com.yp.common.pojo.User;
import com.yp.common.pojo.WorkPosition;
import com.yp.common.service.GroupService;
import com.yp.common.service.UserService;
import com.yp.common.service.WorkPositionService;
import com.yp.common.utils.ResultUtil;
import com.yp.user.util.UpdateUser;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private WorkPositionService workPositionService;


    //员工选择
    @RequestMapping(value = "select")
    @RequiresPermissions(value = {"user:select"})
    public ModelAndView viewOneuser(ModelAndView modelAndView, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        Session session = (Session) subject.getSession();
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("user", user); //相当于session的addAttribute
        modelAndView.setViewName("view/user/Personaldetails");
        return modelAndView;
    }

    //通过groupId查看团队界面
    @RequestMapping(value = "viewUser")
    @RequiresPermissions(value = "user:insert")
    public ModelAndView viewUserBygroupId(ModelAndView modelAndView) {
        //        modelAndView.addObject("group",group);
        modelAndView.setViewName("view/group/GroupUser");
        return modelAndView;
    }

    //跳转查看成员
    @RequestMapping("check")
//    @ResponseBody
    public ModelAndView check(ModelAndView modelAndView) {

        modelAndView.setViewName("view/group/User");

        return modelAndView;
    }

    //查看团队成员
    @RequestMapping("checkUser")
    @RequiresPermissions(value = "user:insert")
    @ResponseBody
    public ResultUtil viewGroupUser(ModelAndView modelAndView, Integer page, Integer limit) {
        Subject subject = SecurityUtils.getSubject();
        Session session = (Session) subject.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getUserId();
        Group group = groupService.selectOneGroupByuserId(id);
        int groupId = group.getGroupId();
        List list = userService.selectUserBygrouIdAndPage(groupId, page, limit);
        JsonConfig jsonConfig = new JsonConfig();  //排除json将要
        jsonConfig.setExcludes(new String[]{"workPosition"});
        jsonConfig.setExcludes(new String[]{"roleList", "sanitationList", "attendanceList"});
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(list.size());
        resultUtil.setData(jsonArray);
        return resultUtil;
    }

    //避免成员通过id查看总园区成员
    @RequestMapping(value = "viewUserByGeneralParkId")
    @RequiresPermissions(value = "role:select")
    public String viewUserByGeneralParkId(ModelAndView modelAndView) {

        ArrayList list = (ArrayList) userService.selectUserbygeneralParkId(1);
        modelAndView.addObject("userlist", list);
        return "view/general/ViewUsers";
    }

    //员工录入界面
    @RequestMapping(value = "insert")
    @RequiresPermissions(value = {"user:insert"})
    public ModelAndView insert(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        int workState = 0;
        List<WorkPosition> workPositionList = workPositionService.selectAllWorkPositionBygroupIdandState(groupId, workState);
        modelAndView.addObject("workPositionList", workPositionList);
        modelAndView.setViewName("view/common/insertUser");
        return modelAndView;
    }

    //员工录入
    @RequestMapping("insertUser")
    @RequiresPermissions(value = {"user:insert"})
    public String insertOneUser(ModelAndView modelAndView, User user, @RequestParam("workId") String workId) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user1 = (User) session.getAttribute("user");
        int groupId = user1.getGroupId();
        Group group = groupService.selectOneGroupById(groupId);
        int subParkId = group.getSubParkId();
        user.setGroupId(groupId);
        user.setSanitationScore(100);
        user.setAttendanceScore(100);
        user.setWorkRatio(user.getWorkRatio());
        user.setWorkSanitation(user.getWorkSanitation());
        user.setSubParkId(subParkId);
//     user.setWorkRatio("100%");
//     user.setWorkSanitation("100%");
        user.setState(1); //表示已激活员工
        userService.insertOneUser(user);
        int wId = Integer.parseInt(workId);
        WorkPosition workPosition = workPositionService.selectOneWorkPositionById(wId);
        workPosition.setWorkState(1);
        workPositionService.updateOneWorkPosition(workPosition);
        return "view/group/index";
    }

    //普通用户修改
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @RequiresPermissions(value = {"user:update"})
    public String updateOneUser(@RequestParam("id") String userId,
                                @RequestParam("userName") String userName,
                                @RequestParam("userPwd") String userPwd,
                                @RequestParam("sex") String sex,
                                @RequestParam("phone") String phone,
                                @RequestParam("cardNumber") String cardNumber,
                                @RequestParam("email") String email,
                                @RequestParam("address") String address,
                                @RequestParam("age") String age,
                                ModelAndView modelAndView, HttpServletRequest request) {
        int id = Integer.parseInt(userId);
        User user1 = userService.selectOneUserById(id);
        System.out.print("用户Id是" + id);
        UpdateUser updateUser = new UpdateUser();
        user1 = updateUser.update(user1, id, userName, userPwd, sex, age, phone,
                cardNumber, email, address);
        System.out.print("用户名" + user1.getUserName() + "用户密码" + user1.getUserPwd());
        userService.updateOneUser(user1);  //到前端只显示规定的数据
        return "view/user/index";
    }

    @RequestMapping("delete")
    @RequiresPermissions(value = {"user:delete"})
    public String deleteOneUserById(@RequestParam("userId") String userId) {
        int id = Integer.parseInt(userId);
        userService.deleteOneUserById(id);
        return "view/";
    }

    @RequestMapping("state")
    @RequiresPermissions(value = {"role:select"})
    public String selectAllUserBystate(@RequestParam("state") String state, ModelAndView modelAndView) {
        int state1 = Integer.parseInt(state);
        ArrayList list = (ArrayList) userService.selectAllUserBystate(state1);
        modelAndView.addObject("userlist", list);
        return "view/";
    }

    @RequestMapping("viewUserByAttendance")
    @RequiresPermissions(value = {"user:select"})
    public String viewUserByAttendanceId(@RequestParam("attendanceId") String attendanceId, ModelAndView modelAndView) {
        int attendanceId1 = Integer.parseInt("attendanceId");
        ArrayList list = (ArrayList) userService.selectUserByAttendanceId(attendanceId1);
        modelAndView.addObject("userlist", list);
        return "view/";
    }

    @RequestMapping(value = "viewUserBystateAndgroupId")
    @RequiresPermissions(value = {"user:insert"})
    public String viewAllUserBystateAndgroupId(@RequestParam("state") String state,
                                               @RequestParam("groupId") String groupId,
                                               ModelAndView modelAndView) {
        int state1 = Integer.parseInt(state);
        int groupId1 = Integer.parseInt(groupId);
        ArrayList list = (ArrayList) userService.selectAllUserBystateAndgroupId(state1, groupId1);
        modelAndView.addObject("userlist", list);
        return "view/";
    }
}
