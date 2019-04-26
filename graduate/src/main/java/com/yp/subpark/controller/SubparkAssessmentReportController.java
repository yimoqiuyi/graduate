package com.yp.subpark.controller;

import com.yp.common.pojo.AssessmentReport;
import com.yp.common.pojo.AssessmentTable;
import com.yp.common.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
 //团队考核报告
@Controller
@RequestMapping("subpark")
public class SubparkAssessmentReportController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private AssessmentReportService assessmentReportService;   //考核报告
    @Autowired
    private AchievementsNumberService achievementsNumberService; //团队成果表
    @Autowired
    private AssessmentTableService assessmentTableService;  //团队任务表
    @Autowired
    private UserService userService;   //通过组员的卫生以及考勤利用率记行填写考核中卫生考勤的描述

    @RequestMapping("checkAssessmentReport")
    @RequiresPermissions("role:insert")
    public ModelAndView CheckAssessmentReport(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        AssessmentReport assessmentReport=assessmentReportService.selectOneAssessmentReportByid(groupId);
        modelAndView.addObject("assessmentReport",assessmentReport);
        modelAndView.setViewName("view/subpark/SubparkAssessmentReport");
        return modelAndView;
    }
    //修改团队考核报告信息
   @RequestMapping("updateAssessmentReport")
   @RequiresPermissions("role:insert")
     public String UpdateAssessmentReport(AssessmentReport assessmentReport){
      assessmentReportService.updateAssessmentReport(assessmentReport);
      return "view/subpark/index";
   }
}
