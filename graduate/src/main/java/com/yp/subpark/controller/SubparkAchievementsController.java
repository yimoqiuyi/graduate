package com.yp.subpark.controller;

import com.yp.common.pojo.Achievements;
import com.yp.common.pojo.AchievementsNumber;
import com.yp.common.pojo.AssessmentTable;
import com.yp.common.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("subpark")
public class SubparkAchievementsController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private AchievementsService achievementsService; //成果配置表
    @Autowired
    private AssessmentTableService assessmentTableService; //任务指标表
    @Autowired
    private PaperService paperService;
    @Autowired
    private PatentService patentService;
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private SoftwareService softwareService;
    @Autowired
    private AchievementsNumberService achievementsNumberService;

    //获取成果
    @RequestMapping("getAllAchievements")
    @RequiresPermissions("role:insert")
    public ModelAndView getAllAchievements(ModelAndView modelAndView, HttpServletRequest request) {
        String groupId = request.getParameter("groupId");
        List<Achievements> achievementsList = achievementsService.getAllachievements();
        modelAndView.addObject("groupId", groupId);
        modelAndView.addObject("achievementsList", achievementsList);
        modelAndView.setViewName("view/subpark/GroupAchievements");
        return modelAndView;
    }

    //修改成果
    @RequestMapping("updateAchievement")
    @RequiresPermissions("role:insert")
    public ModelAndView UpdateAchievement(ModelAndView modelAndView, HttpServletRequest request) {
        Achievements achievements = achievementsService.selectAchievementsByachievementsId(Integer.parseInt(request.getParameter("achievementsId")));
        modelAndView.addObject("achievements", achievements);
        modelAndView.setViewName("view/subpark/UpdateAchievement");
        return modelAndView;
    }

    @RequestMapping("updateOneAchievement")
    @RequiresPermissions("role:insert")
    private String UpdateOneAchievement(Achievements achievements) {
        achievementsService.updateAchievement(achievements);
        return "view/subpark/index";
    }

    //删除成果类型
    @RequestMapping("deleteAchievement")
    @RequiresPermissions("role:insert")
    public String DeleteAchievements(HttpServletRequest request) {
        int achievementsId = Integer.parseInt(request.getParameter("achievementsId"));
        achievementsService.delectAchievements(achievementsId);  //删除所有相关文件的成果
        softwareService.deleteSoftWareByAchievementsId(achievementsId);
        paperService.deletePaperByAchievementsId(achievementsId);
        patentService.deletePatentByAchievementsId(achievementsId);
        competitionService.deleteCompitionByAchievementsId(achievementsId);
        return "view/subpark/index";
    }

    //添加成果
    @RequestMapping("insertAchievement")
    @RequiresPermissions("role:insert")
    public String InsertAchievement() {
        return "view/common/RegistAchievement";
    }



    @RequestMapping("insertOneAchievement")
    @RequiresPermissions("role:insert")
    public String InsertOneAchievement(Achievements achievements) {
        achievementsService.insertAchievements(achievements);
        return "view/subpark/index";
    }
     //获取团队成果
    @RequestMapping("getGroupAchievements")
    @RequiresPermissions("role:insert")
    public ModelAndView GetGroupAchievements(ModelAndView modelAndView, HttpServletRequest request) {
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(Integer.parseInt(request.getParameter("groupId")));
        modelAndView.addObject("achievementsNumber", achievementsNumber);
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/subpark/GetGroupAchievements");
        return modelAndView;
    }


}
