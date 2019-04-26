package com.yp.role.controller;

import com.yp.common.pojo.Admissioncontract;
import com.yp.common.pojo.Managementagreement;
import com.yp.common.pojo.Responsibilityagreement;
import com.yp.common.pojo.User;
import com.yp.common.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("group")
public class GroupAgreementController {
    @Autowired
    private UserService userService; //用户
    @Autowired
    private GroupService groupService; //团队
    @Autowired
    private AgreementService agreementService; //合同类别
    @Autowired
    private AdmissioncontractService admissioncontractService; // 入园合同
    @Autowired
    private ManagementagreementService managementagreementService; //资产协议
    @Autowired
    private ResponsibilityagreementService responsibilityagreementService; //卫生协议

    @RequestMapping("agreement")
    @RequiresPermissions(value = {"role:select"})
    public String Agreement() {
        return "view/group/Agreement";
    }

    @RequestMapping("selectAdmissioncontract")
    @RequiresPermissions(value = {"role:select"})
    public ModelAndView selectAdmissioncontract(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        List<Admissioncontract> admissioncontractList = admissioncontractService.selectOneAllAdmissioncontract(groupId);
        modelAndView.addObject("admissioncontractList", admissioncontractList);
        modelAndView.setViewName("view/group/AdmissionContract");
        return modelAndView;
    }
    @RequestMapping("selectManagementagreement")
    @RequiresPermissions(value = {"role:select"})
    public ModelAndView selectManagementagreement(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        List<Managementagreement> managementagreementList=managementagreementService.selectAllManagementagreementBygroupId(groupId);
        modelAndView.addObject("managementagreementList",managementagreementList);
        modelAndView.setViewName("view/group/Managementagreement");
        return modelAndView;
    }
    @RequestMapping("selectResponsibilityagreement")
    @RequiresPermissions(value = {"role:select"})
    public ModelAndView selectResponsibilityagreement(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        List<Responsibilityagreement> responsibilityagreementList=responsibilityagreementService.selectAllResponsibilityagreementBygroupId(groupId);
        modelAndView.addObject("responsibilityagreementList",responsibilityagreementList);
        modelAndView.setViewName("view/group/Responsibilityagreement");
        return modelAndView;
    }
}
