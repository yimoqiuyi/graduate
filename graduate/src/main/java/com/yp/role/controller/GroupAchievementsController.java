package com.yp.role.controller;

import com.yp.common.pojo.*;
import com.yp.common.service.*;
import com.yp.common.utils.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
 //团队成果操作
@Controller
@RequestMapping("group")
public class GroupAchievementsController {
    @Autowired
    private AchievementsNumberService achievementsNumberService; //团队成果表
    @Autowired
    private AssessmentTableService assessmentTableService;  //团队任务表
    @Autowired
    private PatentFileService patentFileService; //专利表存放路径
    @Autowired
    private PatentService patentService; //专利存放
    @Autowired
    private SoftwareService softwareService; //软著存放
    @Autowired
    private PaperService paperService; //论文存放
    @Autowired
    private CompetitionService competitionService; //竞赛存放
    @Autowired
    private AchievementsService achievementsService;
    @Autowired
    private SubParkService subParkService;
    @Autowired
    private GeneralParkService generalParkService;
    @Autowired
    private GroupService groupService;

    @RequestMapping("selectAchievements")
    @RequiresRoles(value = "group")
    public ModelAndView selectGroupAchievements(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(groupId); //团队成果类
        AssessmentTable assessmentTable = assessmentTableService.selectOneAssessmentTableByid(groupId);//团队成果配置类
        modelAndView.addObject("assessmentTable", assessmentTable);
        modelAndView.addObject("achievementsNumber", achievementsNumber);
        modelAndView.setViewName("view/group/AchievemnetNumber");
        return modelAndView;
    }

    @RequestMapping(value = "insertGroupachievement")
    @RequiresRoles(value = "group")
    public String insertGroupAchievements(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        int patentNum = patentService.selectPatentsByGroupId(groupId);
        int paperNum = paperService.selectPapersbyGroupId(groupId);
        int softwareNum = softwareService.selectSoftWaresByGroupId(groupId);
        int comprtitionNum = competitionService.selctCompetitionsBygroupId(groupId);
        AchievementsNumber achievementsNumber = new AchievementsNumber();
        achievementsNumber.setCompetitionNum(comprtitionNum);
        achievementsNumber.setGroupId(groupId);
        achievementsNumber.setPaperNum(paperNum);
        achievementsNumber.setPatentNum(patentNum);
        achievementsNumber.setSoftwareNum(softwareNum); //添加团队所获得奖项数量
        achievementsNumberService.insertAchievementsNumber(achievementsNumber);
        return "redirect:selectAchievements.do";
    }

    @RequestMapping("Achievementoperation")
    public String operation() {
        return "view/common/index";
    }

    @RequestMapping("insertAchievement")
    @RequiresRoles(value = "group")
    public ModelAndView insertAchievement(ModelAndView modelAndView, HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Achievements> achievementsList = achievementsService.getAllachievements();
        if (id == 1) {
            modelAndView.setViewName("view/common/patentConfiguration");
        } else if (id == 2) {
            modelAndView.setViewName("view/common/softwareConfiguration");
        } else if (id == 3) {
            modelAndView.setViewName("view/common/competitionConfiguration");
        } else if (id == 4) {
            modelAndView.setViewName("view/common/paperConfiguration");
        } else if(id==5){
            modelAndView.setViewName("view/group/index");
        }
        modelAndView.addObject("achievementsList", achievementsList);

        return modelAndView;
    }

    @RequestMapping(value = "insertPatent", method = RequestMethod.POST)
    @RequiresRoles(value = "group")
    public String insertPatentFile(ModelAndView modelAndView, Patent patent, @RequestParam(value = "file", required = false) MultipartFile[] file) throws IOException {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        String achievementsName = patent.getPatentCategory(); //获取成果类型：名字
        Achievements achievements = achievementsService.selectAchievementsByName(achievementsName);//查看成果类型
        int groupId = user.getGroupId(); //团队外键
        Group group = groupService.selectOneGroupById(groupId);
        FileUtils fileUtils = new FileUtils();
        List filepathlist = fileUtils.UploadFiles(file);
        int subparkId = group.getSubParkId(); //分园区外键
        SubPark subPark = subParkService.selectOneSubParkById(subparkId);
        int generalId = subPark.getGeneralParkId(); //总园区外键
        patent.setPatentState(0);//设置为0表示未审核
        patent.setAchievementsId(achievements.getAchievementsId());//设置成果外键
        patent.setGroupId(groupId);
        patent.setSubParkId(subparkId);
        patent.setGeneralParkId(generalId);
        patent.setPatentAuditTime("0"); //未审核,审核日期为0
        patentService.insertOnePatent(patent);
        PatentFile patentFile = new PatentFile();
        Iterator<String> iterator = filepathlist.iterator();//路径集合
        while (iterator.hasNext()) {
            String path = iterator.next();  //iterator取出字符串
            patentFile.setPatentId(patent.getPatentId());
            patentFile.setPfName(patent.getPatentName());
            patentFile.setPfPath(path);
            patentFileService.insertPatentFile(patentFile);//添加专利路径类
        }
        return "redirect:Achievementoperation.do";
    }

    @RequestMapping(value = "insertSoftware", method = RequestMethod.POST)
    @RequiresRoles(value = "group")
    public String insertSoftware(Software software, @RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        String softGradeName = software.getSoftGrade(); //获取成果类型：名字
        Achievements achievements = achievementsService.selectAchievementsByName(softGradeName);//查看成果类型
        int groupId = user.getGroupId(); //团队外键
        Group group = groupService.selectOneGroupById(groupId);
        int subparkId = group.getSubParkId(); //分园区外键
        SubPark subPark = subParkService.selectOneSubParkById(subparkId);
        int generalId = subPark.getGeneralParkId(); //总园区外键
        FileUtils fileUtils = new FileUtils();
        String filePath = fileUtils.UploadFile(multipartFile);//返回地址
        software.setSoftwareState(0);//设置为0表示未审核
        software.setSoftwareAuditTime("0"); //表示未审核
        software.setAchievementsId(achievements.getAchievementsId()); //设置成果外键
        software.setGroupId(groupId); //团队外键
        software.setSubParkId(subparkId); //分园区外键
        software.setGeneralParkId(generalId); //总园区外键
        software.setSoftDocument(filePath);//软著路径
        softwareService.insertOneSoftware(software);
        return "redirect:Achievementoperation.do"; //返回文件主页
    }

    @RequestMapping("insertPaper")
    @RequiresRoles(value = "group")
    public String insertPaper(Paper paper,@RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        String softGradeName = paper.getGrade(); //获取成果类型：名字
        Achievements achievements = achievementsService.selectAchievementsByName(softGradeName);//查看成果类型
        int groupId = user.getGroupId(); //团队外键
        Group group = groupService.selectOneGroupById(groupId);
        int subparkId = group.getSubParkId(); //分园区外键
        SubPark subPark = subParkService.selectOneSubParkById(subparkId);
        int generalId = subPark.getGeneralParkId(); //总园区外键
        FileUtils fileUtils = new FileUtils();
        String  paperPath = fileUtils.UploadFile(multipartFile);
        paper.setPaperState(0);//设置为0表示未审核
        paper.setPaperAuditTime("0");
        paper.setGroupId(groupId);
        paper.setSubParkId(subparkId);
        paper.setGeneralParkId(generalId);
        paper.setPaperPath(paperPath);
        paper.setAchievementsId(achievements.getAchievementsId());
        paperService.insertOnePaper(paper);
        return "redirect:Achievementoperation.do";
    }

    @RequestMapping("insertCompetition")
    @RequiresRoles(value = "group")
    public String insertCompetition(Competition competition, @RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        String softGradeName = competition.getAwardLevel(); //获取成果类型：名字
        Achievements achievements = achievementsService.selectAchievementsByName(softGradeName);//查看成果类型
        int groupId = user.getGroupId(); //团队外键
        Group group = groupService.selectOneGroupById(groupId);
        int subparkId = group.getSubParkId(); //分园区外键
        SubPark subPark = subParkService.selectOneSubParkById(subparkId);
        int generalId = subPark.getGeneralParkId(); //总园区外键
        FileUtils fileUtils = new FileUtils();
        String competitionPath = fileUtils.UploadFile(multipartFile);
        competition.setAchievementsId(achievements.getAchievementsId());
        competition.setCompetitionState(0); //设置为0表示未审核
        competition.setCompetitionAuditTime("0");
        competition.setCompetitionPath(competitionPath);
        competition.setGroupId(groupId);
        competition.setSubParkId(subparkId);
        competition.setGeneralParkId(generalId);
        competitionService.insertCompetition(competition);
        return "redirect:Achievementoperation.do";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ModelAndView uploadFile(ModelAndView modelAndView, @RequestParam(value = "file", required = false) MultipartFile[] multipartFiles) throws IOException {
        FileUtils fileUtils = new FileUtils();
        List filepathlist = fileUtils.UploadFiles(multipartFiles);
        modelAndView.addObject("filepathlist", filepathlist);
        modelAndView.setViewName("view/common/Patentupload");
        return modelAndView;
    }
}
