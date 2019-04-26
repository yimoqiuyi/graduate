package com.yp.subpark.controller;

import com.yp.common.pojo.AchievementsNumber;
import com.yp.common.pojo.Competition;
import com.yp.common.pojo.Paper;
import com.yp.common.service.AchievementsNumberService;
import com.yp.common.service.CompetitionService;
import com.yp.common.utils.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.ModalExclude;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("subpark")
public class SubparkGroupCompetionController {
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private AchievementsNumberService achievementsNumberService;

    @RequestMapping("selectGroupCompetition")
    @RequiresPermissions("role:insert")
    public ModelAndView SeletGroupPaper(HttpServletRequest request, ModelAndView modelAndView) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<Competition> competitionList = competitionService.selectCompetionByGroupIdAndcompetitionState(groupId, 0); //查看未审核论文
        modelAndView.addObject("competitionList", competitionList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/GroupCompetion");
        return modelAndView;
    }

    @RequestMapping("auditCompetion")
    @RequiresPermissions("role:insert")
    public String AuditPaper(HttpServletRequest request) {
        Competition competition = competitionService.selectOneCompetitionBycompetitionId(Integer.parseInt(request.getParameter("competitionId")));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String patentAuditTime = dateFormat.format(date);
        competition.setCompetitionAuditTime(patentAuditTime);
        competition.setCompetitionState(1);
        competitionService.updateCompetition(competition); //修改竞赛状态
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(competition.getGroupId());
        achievementsNumber.setCompetitionNum(achievementsNumber.getCompetitionNum() + 1);
        achievementsNumberService.updateOneAchievementsNumber(achievementsNumber);
        return "view/subpark/index";
    }

    @RequestMapping("deleteCompetion")
    @RequiresPermissions("role:insert")
    public String DeletePaper(HttpServletRequest request) {
        Competition competition = competitionService.selectOneCompetitionBycompetitionId(Integer.parseInt(request.getParameter("competitionId")));
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(competition.getGroupId());
        achievementsNumber.setCompetitionNum(achievementsNumber.getCompetitionNum() + 1);
        achievementsNumberService.updateOneAchievementsNumber(achievementsNumber);
        competitionService.deleteComptitionById(Integer.parseInt(request.getParameter("competitionId")));
        ;
        return "view/subpark/index";
    }

    //查看已审核专利
    @RequestMapping("checkAuditCompetion")
    @RequiresPermissions("role:insert")
    public ModelAndView CheckAuditPapers(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<Competition> competitionList = competitionService.selectCompetionByGroupIdAndcompetitionState(groupId, 1);
        modelAndView.addObject("competitionList", competitionList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/CheckAuditCompetion");
        return modelAndView;
    }

    //下载单个竞赛信息
    @RequestMapping("selectCompetion")
    @RequiresPermissions("role:insert")
    public void SelectCompetion(HttpServletRequest request, HttpServletResponse response) {
        Competition competition = competitionService.selectOneCompetitionBycompetitionId(Integer.parseInt(request.getParameter("competitionId")));
        String path = competition.getCompetitionPath();
        String fileName = competition.getCompetitionName();
        FileUtils fileUtils = new FileUtils();
        String s = fileUtils.downFile(fileName, path, response);
        if (s.equals("success")) {
            System.out.println("成功下载");
        } else {
            System.out.println("失败下载");
        }
    }
}
