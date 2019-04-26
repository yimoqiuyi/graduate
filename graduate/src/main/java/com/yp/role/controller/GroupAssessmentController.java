package com.yp.role.controller;

import com.yp.common.pojo.AssessmentReport;
import com.yp.common.pojo.Group;
import com.yp.common.pojo.User;
import com.yp.common.service.AssessmentReportService;
import com.yp.common.service.AssessmentTableService;
import com.yp.common.service.GroupService;
import com.yp.common.service.UserService;
import com.yp.common.utils.ResultUtil;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//团队考核报表

@Controller
@RequestMapping("group")
public class GroupAssessmentController {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private AssessmentReportService assessmentReportService;

    //团队报告跳转页
    @RequestMapping("select")
    @RequiresRoles(value = {"group", "subpark", "general", "admin"}, logical = Logical.OR)
    public String select() {
        return "view/group/groupAssessment";
    }

    //选择团队考核报告
    @RequestMapping("selectAssessment")
    @RequiresPermissions("role:select")
    public ModelAndView selectGroupassessmentReport(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = (Session) subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        AssessmentReport assessmentReport = assessmentReportService.selectOneAssessmentReportByid(groupId);
        modelAndView.addObject("assessmentReport", assessmentReport);
        modelAndView.setViewName("view/group/Assessment");
        return modelAndView;
    }

    //选择用户跳转页
    @RequestMapping("selectUser")
    @RequiresPermissions("role:select")
    public String selectUser() {
        return "view/group/AssessmentUser";
    }

//    //选择用户
//    @RequestMapping("selectUserAssessment")
//    @RequiresPermissions("role:select")
//    public ResultUtil selectUserAssessment(ModelAndView modelAndView,Integer page,Integer limit) {
//        Subject subject = SecurityUtils.getSubject();
//        Session session = subject.getSession();
//        User user = (User) session.getAttribute("user");
//        int id = user.getUserId();
//        Group group = groupService.selectOneGroupByuserId(id);
//        int groupId = group.getGroupId();
//        List list = userService.selectUserBygrouIdAndPage(groupId, page, limit);
//        JsonConfig jsonConfig = new JsonConfig();  //排除json将要
//        jsonConfig.setExcludes(new String[]{"workPosition"});
//        jsonConfig.setExcludes(new String[]{"roleList", "sanitationList", "attendanceList"});
//        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
//        ResultUtil resultUtil = new ResultUtil();
//        resultUtil.setCode(0);
//        resultUtil.setCount(list.size());
//        resultUtil.setData(jsonArray);
//        return resultUtil;
//    }

    @RequestMapping("insertassessment")
    @RequiresRoles(value = "group")
    public ModelAndView insertGroupassessmentReport(ModelAndView modelAndView, AssessmentReport assessmentReport) {
        assessmentReportService.insertAssessmentReport(assessmentReport);
        return modelAndView;
    }
}
