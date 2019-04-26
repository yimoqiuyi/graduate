package com.yp.role.controller;

import com.yp.common.pojo.Admissioncontract;
import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.Managementagreement;
import com.yp.common.pojo.User;
import com.yp.common.service.ManagementagreementService;
import com.yp.common.utils.DateUtils;
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
public class GroupManagementController {
    @Autowired
    private ManagementagreementService managementagreementService;

    @RequestMapping("ManagementagreementDownload")
    @RequiresPermissions("role:select")
    public void Download(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
        int managementId = Integer.parseInt(request.getParameter("managementId"));
        Managementagreement managementagreement = managementagreementService.selectOneManagementagreementByid(managementId);
        String fileName = managementagreement.getManagementName();
        String path = managementagreement.getFilePath();
        System.out.println("文件路径" + path);
        FileUtils fileUtils = new FileUtils();
        String s = fileUtils.downFile(fileName, path, response);
        if (s.equals("success")) {
            System.out.println("成功下载");
        } else {
            System.out.println("失败下载");
        }
    }

    @RequestMapping("selectManagementByTime")
    @RequiresPermissions("role:select")
    public ModelAndView selectManagementByTime(ModelAndView modelAndView, @RequestParam("beginTime") String beginTime,
                                                      @RequestParam("endTime") String endTime) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        DateUtils dateutile= new DateUtils();
        Dateutile dateutile1=dateutile.getDate(groupId,beginTime,endTime);
        System.out.println("tuanduiID" + groupId);
        List<Managementagreement>  managementagreementList = managementagreementService.selectAllManagementagreementByTime(dateutile1);
        modelAndView.addObject("managementagreementList", managementagreementList);
        modelAndView.setViewName("view/group/ManagementagreementUser");
        return modelAndView;
    }
}
