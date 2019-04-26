package com.yp.subpark.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.imageio.plugins.common.I18N;
import com.yp.common.pojo.*;
import com.yp.common.service.AdmissioncontractService;
import com.yp.common.service.GroupService;
import com.yp.common.service.ManagementagreementService;
import com.yp.common.service.ResponsibilityagreementService;
import com.yp.subpark.jsonUtil.GroupToJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("subpark")
public class SubparkAgreementController {
    @Autowired
    private AdmissioncontractService admissioncontractService; // 入园合同
    @Autowired
    private ManagementagreementService managementagreementService; //资产协议
    @Autowired
    private ResponsibilityagreementService responsibilityagreementService; //卫生协议
    @Autowired
    private GroupService groupService;

    @RequestMapping("subparkAgreement")
    @RequiresPermissions("role:insert")
    public String SubparkAgreement() {
        return "view/subpark/SubparkAgreement";
    }

    @RequestMapping("GroupAgreement")
    @RequiresPermissions("role:insert")
    public @ResponseBody
    Map<String, Object> SelectGroupAttendance(Integer page, Integer limit) {
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

    //团队入园合同
    @RequestMapping("subparkGroupAgreement")
    @RequiresPermissions("role:insert")
    public ModelAndView SubparkGroupAgreement(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<Admissioncontract> admissioncontractList = admissioncontractService.selectOneAllAdmissioncontract(groupId);
        modelAndView.addObject("admissioncontractList", admissioncontractList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/SubparkGroupAgreement");
        return modelAndView;
    }

    //合同
    @RequestMapping("selectAgreementByTime")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectAgreementByTime(ModelAndView modelAndView, @RequestParam("beginTime") String beginTime,
                                              @RequestParam("endTime") String endTime, Integer groupId) {
        Dateutile dateutile = new Dateutile();
        dateutile.setId(groupId);
        dateutile.setSignDate(beginTime);
        dateutile.setExpirationDate(endTime);
        List<Admissioncontract> admissioncontractList = admissioncontractService.selectAllAdmissioncontractBytimeandgroupID(dateutile);
        modelAndView.addObject("admissioncontractList", admissioncontractList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/SelectAgreementByTime");
        return modelAndView;
    }

    //团队资产管理协议
    @RequestMapping("subparkGroupManagementagreement")
    @RequiresPermissions("role:insert")
    public ModelAndView subparkGroupManagementagreement(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<Managementagreement> managementagreementList = managementagreementService.selectAllManagementagreementBygroupId(groupId);
        modelAndView.addObject("managementagreementList", managementagreementList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/SubparkGroupManagementagreement");
        return modelAndView;
    }

    @RequestMapping("selectManagementagreementBytime")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectManagementagreementBytime(ModelAndView modelAndView, @RequestParam("beginTime") String beginTime,
                                                        @RequestParam("endTime") String endTime, Integer groupId) {
        Dateutile dateutile = new Dateutile();
        dateutile.setId(groupId);
        dateutile.setSignDate(beginTime);
        dateutile.setExpirationDate(endTime);
        List<Managementagreement> managementagreementList = managementagreementService.selectAllManagementagreementByTime(dateutile);
        modelAndView.addObject("managementagreementList", managementagreementList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/SelectManagementagreementBytime");
        return modelAndView;
    }

    //团队卫生协议
    @RequestMapping("subparkGroupResponsibilityagreement")
    @RequiresPermissions("role:insert")
    public ModelAndView subparkGroupResponsibilityagreement(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<Responsibilityagreement> responsibilityagreementList = responsibilityagreementService.selectAllResponsibilityagreementBygroupId(groupId);
        modelAndView.addObject("responsibilityagreementList", responsibilityagreementList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/SubparkGroupResponsibilityagreement");
        return modelAndView;
    }

    @RequestMapping("selectResponsibilityagreementBytime")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectResponsibilityagreementBytime(ModelAndView modelAndView, @RequestParam("beginTime") String beginTime,
                                                            @RequestParam("endTime") String endTime, Integer groupId) {
        Dateutile dateutile = new Dateutile();
        dateutile.setId(groupId);
        dateutile.setSignDate(beginTime);
        dateutile.setExpirationDate(endTime);
        List<Responsibilityagreement> responsibilityagreementList = responsibilityagreementService.selectAllResponsibilityagreementByTimeAndgeneralParkId(dateutile);
        modelAndView.addObject("responsibilityagreementList", responsibilityagreementList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/SelectResponsibilityagreementBytime");
        return modelAndView;
    }
}
