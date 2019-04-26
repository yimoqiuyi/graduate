package com.yp.subpark.controller;

import com.yp.common.pojo.AchievementsNumber;
import com.yp.common.pojo.Paper;
import com.yp.common.pojo.Software;
import com.yp.common.service.AchievementsNumberService;
import com.yp.common.service.SoftwareService;
import com.yp.common.utils.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("subpark")
public class SubparkGroupSoftwareController {
    @Autowired
    private SoftwareService softwareService;
    @Autowired
    private AchievementsNumberService achievementsNumberService;

    @RequestMapping("selectGroupSoftware")
    @RequiresPermissions("role:insert")
    public ModelAndView SeletGroupSoftware(HttpServletRequest request, ModelAndView modelAndView) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<Software> softwareList = softwareService.selectSoftWareByGroupIdAndsoftwareState(groupId, 0); //查看未审核论文
        modelAndView.addObject("softwareList", softwareList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/GroupSoftware");
        return modelAndView;
    }

    @RequestMapping("auditSoftware")
    @RequiresPermissions("role:insert")
    public String AuditPaper(HttpServletRequest request) {
        Software software = softwareService.selectOneSoftwareById(Integer.parseInt(request.getParameter("softId")));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String patentAuditTime = dateFormat.format(date);
        software.setSoftwareAuditTime(patentAuditTime);
        software.setSoftwareState(1);
        softwareService.updateOneSoftware(software);
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(software.getGroupId());
        achievementsNumber.setPaperNum(achievementsNumber.getPaperNum() + 1);
        achievementsNumberService.updateOneAchievementsNumber(achievementsNumber);
        return "view/subpark/index";
    }

    @RequestMapping("deleteSoftware")
    @RequiresPermissions("role:insert")
    public String DeletePaper(HttpServletRequest request) {
        Software software=softwareService.selectOneSoftwareById(Integer.parseInt(request.getParameter("softId")));
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(software.getGroupId());
        achievementsNumber.setPaperNum(achievementsNumber.getPaperNum() -1);
        achievementsNumberService.updateOneAchievementsNumber(achievementsNumber);
        softwareService.deleteOneSoftwareById(Integer.parseInt(request.getParameter("softId")));
         return "view/subpark/index";
    }

    //查看已审核专利
    @RequestMapping("checkAuditSoftwares")
    @RequiresPermissions("role:insert")
    public ModelAndView CheckAuditPapers(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<Software> softwareList = softwareService.selectSoftWareByGroupIdAndsoftwareState(groupId, 1);
        modelAndView.addObject("softwareList", softwareList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/CheckAuditSoftwares");
        return modelAndView;
    }

    @RequestMapping("downLoadSoftware")
    @RequiresPermissions("role:insert")
    public void DownLoadSoftware(HttpServletRequest request, HttpServletResponse response) {
        Software software = softwareService.selectOneSoftwareById(Integer.parseInt(request.getParameter("softId")));
        String name = software.getSoftName();
        String path = software.getSoftDocument();
        FileUtils fileUtils = new FileUtils();
        String s = fileUtils.downFile(name, path, response);
        if (s.equals("success")) {
            System.out.println("下载成功");
        } else {
            System.out.println("下载失败");
        }
    }

}
