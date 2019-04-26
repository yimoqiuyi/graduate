package com.yp.subpark.controller;

import com.sun.tools.doclets.formats.html.markup.HtmlAttr;
import com.yp.common.pojo.AchievementsNumber;
import com.yp.common.pojo.Paper;
import com.yp.common.pojo.Patent;
import com.yp.common.service.AchievementsNumberService;
import com.yp.common.service.GroupService;
import com.yp.common.service.PaperService;
import com.yp.common.utils.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.omg.PortableInterceptor.INACTIVE;
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
public class SubparkGroupPaperController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private AchievementsNumberService achievementsNumberService;

    @RequestMapping("selectGroupPaper")
    @RequiresPermissions("role:insert")
    public ModelAndView SeletGroupPaper(HttpServletRequest request, ModelAndView modelAndView) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<Paper> paperList = paperService.selectPaperByGroupIdAndState(groupId, 0); //查看未审核论文
        modelAndView.addObject("paperList", paperList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/GroupPaper");
        return modelAndView;
    }

    @RequestMapping("auditPaper")
    @RequiresPermissions("role:insert")
    public String AuditPaper(HttpServletRequest request) {
        Paper paper = paperService.selectOnePaper(Integer.parseInt(request.getParameter("paperId")));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String patentAuditTime = dateFormat.format(date);
        paper.setPaperAuditTime(patentAuditTime);
        paper.setPaperState(1);
        paperService.updatePaper(paper);
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(paper.getGroupId());
        achievementsNumber.setPaperNum(achievementsNumber.getPaperNum() + 1);
        achievementsNumberService.updateOneAchievementsNumber(achievementsNumber);
        return "view/subpark/index";
    }

    @RequestMapping("deletePaper")
    @RequiresPermissions("role:insert")
    public String DeletePaper(HttpServletRequest request) {
        Paper paper = paperService.selectOnePaper(Integer.parseInt(request.getParameter("paperId")));
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(paper.getGroupId());
        achievementsNumber.setPaperNum(achievementsNumber.getPaperNum() - 1);
        achievementsNumberService.updateOneAchievementsNumber(achievementsNumber);
        paperService.delectOnePaper(Integer.parseInt(request.getParameter("paperId")));
        return "view/subpark/index";
    }

    //查看已审核论文
    @RequestMapping("checkAuditPaper")
    @RequiresPermissions("role:insert")
    public ModelAndView CheckAuditPapers(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<Paper> paperList = paperService.selectPaperByGroupIdAndState(groupId, 1);
        modelAndView.addObject("paperList", paperList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/CheckAuditPapers");
        return modelAndView;
    }

    //下载论文
    @RequestMapping("downLoadPaper")
    @RequiresPermissions("role:insert")
    public void DownLoadPaper(HttpServletRequest request, HttpServletResponse response) {
        Paper paper = paperService.selectOnePaper(Integer.parseInt(request.getParameter("paperId")));
        String path = paper.getPaperPath();
        String name = paper.getPaperName();
        FileUtils fileUtils = new FileUtils();
        String s = fileUtils.downFile(name, path, response);
        if (s.equals("success")) {
            System.out.println("下载成功");
        } else {
            System.out.println("下载失败");
        }
    }

}
