package com.yp.subpark.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.*;
import com.yp.common.service.*;
import com.yp.common.utils.FileUtils;
import com.yp.subpark.jsonUtil.GroupToJson;
import jdk.nashorn.internal.ir.IdentNode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("subpark")
public class SubparkCertificateController {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private AchievementsService achievementsService;//成果配置
    @Autowired
    private PatentService patentService; //专利
    @Autowired
    private PaperService paperService; //论文
    @Autowired
    private SoftwareService softwareService; //软著
    @Autowired
    private CompetitionService competitionService; //竞赛
    @Autowired
    private PatentFileService patentFileService;//专利文件
    @Autowired
    private AchievementsNumberService achievementsNumberService;

    @RequestMapping("checkCertificate")
    @RequiresPermissions("role:insert")
    public String Certificate() {
        return "view/subpark/GroupCertificate";
    }

    @RequestMapping("selectGroupCertificate")
    @RequiresPermissions("role:insert")
    public @ResponseBody
    Map<String, Object> selectGroupCertificate(Integer page, Integer limit) {
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

    //操作成果
    @RequestMapping("achievementsOperation")
    @RequiresPermissions("role:insert")
    public ModelAndView AchievementsOperation(ModelAndView modelAndView) {
        List<Achievements> achievementsList = achievementsService.getAllachievements();
        modelAndView.addObject("achievementsList", achievementsList);
        modelAndView.setViewName("view/subpark/AchievementsOperation");
        return modelAndView;
    }

    //添加成果
    @RequestMapping("addAchievements")
    @RequiresPermissions("role:insert")
    public String AddAttendance() {
        return "view/subpark/AddAchievements";
    }

    @RequestMapping("insertAchievements")
    @RequiresPermissions("role:insert")
    public String InsertAttendance(Achievements achievements) {
        achievementsService.insertAchievements(achievements);
        return "view/subpark/index";
    }

    //修改成果
    @RequestMapping("updateAchievements")
    @RequiresPermissions("role:insert")
    public ModelAndView updateAttendace(ModelAndView modelAndView, HttpServletRequest request) {
        Achievements achievements = achievementsService.selectAchievementsByachievementsId(Integer.parseInt(request.getParameter("achievementsId")));
        modelAndView.addObject("achievements", achievements);
        modelAndView.setViewName("view/subpark/SubparkAchievements");
        return modelAndView;
    }

    @RequestMapping("updateToAchievements")
    @RequiresPermissions("role:insert")
    public String UpdateToAttendacne(Achievements achievements) {
        achievementsService.updateAchievement(achievements);
        return "view/subpark/index";
    }

    //删除成果
    @RequestMapping("deleteAchievements")
    @RequiresPermissions("role:insert")
    public String DeleteAttendance(HttpServletRequest request) {
        achievementsService.delectAchievements(Integer.parseInt(request.getParameter("achievementsId")));
        return "redirect:achievementsOperation.do";
    }

    //专利操作`
    @RequestMapping("selectGroupPatent")
    @RequiresPermissions("role:insert")
    public ModelAndView SeletGroupPatent(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        Group group = groupService.selectOneGroupById(groupId);
        List<Patent> patentList = patentService.selectPatentByGroupIdAndState(groupId, 0);
        modelAndView.addObject("patentList", patentList);
        modelAndView.addObject("group", group);
        modelAndView.setViewName("view/subpark/GroupPatents");
        return modelAndView;
    }

    //审核专利
    @RequestMapping("auditPatent")
    @RequiresPermissions("role:insert")
    public String AuditPatent(HttpServletRequest request) {
        Patent patent = patentService.selectOnePatentByid(Integer.parseInt(request.getParameter("patentId")));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String patentAuditTime = dateFormat.format(date);
        patent.setPatentAuditTime(patentAuditTime);
        patent.setPatentState(1);
        patentService.updateOnePatent(patent);
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(patent.getGroupId());
        achievementsNumber.setPatentNum(achievementsNumber.getPatentNum() + 1);
        achievementsNumberService.updateOneAchievementsNumber(achievementsNumber);
        return "view/subpark/index";
    }

    //删除专利
    @RequestMapping("deletePatent")
    @RequiresPermissions("role:insert")
    public String DeletePatent(HttpServletRequest request) {
        Patent patent = patentService.selectOnePatentByid(Integer.parseInt(request.getParameter("patentId")));
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(patent.getGroupId());
        achievementsNumber.setPatentNum(achievementsNumber.getPatentNum() - 1);
        achievementsNumberService.updateOneAchievementsNumber(achievementsNumber);
        patentFileService.deletePatentFileByPatentId(Integer.parseInt(request.getParameter("patentId")));
        patentService.delectOnePatentByid(Integer.parseInt(request.getParameter("patentId")));

        return "view/subpark/index";
    }

    //查看已审核专利
    @RequestMapping("checkAuditPatents")
    @RequiresPermissions("role:insert")
    public ModelAndView CheckAuditPatents(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<Patent> patentList = patentService.selectPatentByGroupIdAndState(groupId, 1);
        modelAndView.addObject("patentList", patentList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/CheckAuditPatents");
        return modelAndView;
    }

    @RequestMapping("downLoadPatent")
    @RequiresPermissions("role:insert")
    public void DownLoadPatent(HttpServletResponse response, HttpServletRequest request) {
        List<PatentFile> patentFileList = patentFileService.seletcAllPatentFileBypatent_id(Integer.parseInt(request.getParameter("patentId")));
        FileUtils fileUtils = new FileUtils();
        for (PatentFile patentFile : patentFileList) {
            String path = patentFile.getPfPath();
            String name = patentFile.getPfName();
            String s = fileUtils.downFile(name, path, response);
            if (s.equals("success")) {
                System.out.println("下载成功");
            } else {
                System.out.println("下载失败");
            }
        }
    }
}
