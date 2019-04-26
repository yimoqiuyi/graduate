package com.yp.role.controller;

import com.yp.common.pojo.Admissioncontract;
import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.User;
import com.yp.common.service.AdmissioncontractService;
import com.yp.common.utils.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("group")
public class GroupAdmissioncontractController {
    @Autowired
    private AdmissioncontractService admissioncontractService; // 入园合同

    @RequestMapping("AdmissioncontractDownload")
    @RequiresPermissions("role:select")
    public String Download(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
        int admissionId = Integer.parseInt(request.getParameter("admissionId"));
        Admissioncontract admissioncontract = admissioncontractService.selectOneAdmissioncontract(admissionId);
        String fileName = admissioncontract.getAdmissionName();
        String path = admissioncontract.getFilePath();
        System.out.println("文件路径"+path);
        FileUtils fileUtils = new FileUtils();
        String s = fileUtils.downFile(fileName, path, response);
        if (s.equals("success")) {
         return "view/group/index";
        } else {
            return "view/group/index";
        }
    }

    @RequestMapping("selectByTime")
    @RequiresPermissions("role:select")
    public ModelAndView selectAdmissioncontractByTime(ModelAndView modelAndView, @RequestParam("beginTime") String beginTime,
                                                      @RequestParam("endTime") String endTime) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        Dateutile dateutile=new Dateutile();
        dateutile.setId(groupId);
        dateutile.setSignDate(beginTime);
        dateutile.setExpirationDate(endTime);
        System.out.println("tuanduiID"+groupId);
        List<Admissioncontract> admissioncontractList = admissioncontractService.selectAllAdmissioncontractBytimeandgroupID(dateutile);
        modelAndView.addObject("admissioncontractList", admissioncontractList);
        modelAndView.setViewName("view/group/AdmissionContractUser");
        return modelAndView;
    }
}
