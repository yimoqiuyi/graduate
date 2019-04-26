package com.yp.general.controller;

import com.yp.common.pojo.Competition;
import com.yp.common.pojo.Paper;
import com.yp.common.pojo.PatentFile;
import com.yp.common.pojo.Software;
import com.yp.common.service.*;
import com.yp.common.utils.FileUtils;
 import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("general")
public class GeneraldownLoadCerficateController {
    @Autowired
    private PatentService patentService;  //专利
    @Autowired
    private SoftwareService softwareService; //软著
    @Autowired
    private PaperService paperService;  //论文
    @Autowired
    private CompetitionService competitionService; //竞赛
    @Autowired
    private GroupService groupService;
    @Autowired
    private PatentFileService patentFileService;

    //专利下载
    @RequestMapping("downLoadPatent")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public void DownLoadPatent(HttpServletResponse response, HttpServletRequest request) {
        List<PatentFile> patentFileList = patentFileService.seletcAllPatentFileBypatent_id(Integer.parseInt(request.getParameter("patentId")));
        FileUtils fileUtils=new FileUtils();
        for(PatentFile patentFile:patentFileList){
            String path=patentFile.getPfPath();
            String name=patentFile.getPfName();
            String s=fileUtils.downFile(name,path,response);
            if(s.equals("success")){
                System.out.println("下载成功");
            }else{
                System.out.println("下载失败");
            }
        }
    }
    //论文下载
    @RequestMapping("downLoadPaper")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public void DownLoadPaper(HttpServletRequest request, HttpServletResponse response){
        Paper paper=paperService.selectOnePaper(Integer.parseInt(request.getParameter("paperId")));
        String path=paper.getPaperPath();
        String name=paper.getPaperName();
        FileUtils fileUtils=new FileUtils();
        String s=fileUtils.downFile(name,path,response);
        if(s.equals("success")){
            System.out.println("下载成功");
        }else{
            System.out.println("下载失败");
        }
    }
    //软著下载
    @RequestMapping("downLoadSoftware")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public void DownLoadSoftware(HttpServletRequest request, HttpServletResponse response){
        Software software=softwareService.selectOneSoftwareById(Integer.parseInt(request.getParameter("softId")));
        String name=software.getSoftName();
        String path=software.getSoftDocument();
        FileUtils fileUtils=new FileUtils();
        String s=fileUtils.downFile(name,path,response);
        if(s.equals("success")){
            System.out.println("下载成功");
        }else{
            System.out.println("下载失败");
        }
    }
    //竞赛下载
    @RequestMapping("downLoadCompetion")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public void DownLoadCompetion(HttpServletRequest request, HttpServletResponse response) {
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
