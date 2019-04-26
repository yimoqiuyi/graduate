package com.yp.general.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.*;
import com.yp.common.service.AdmissioncontractService;
import com.yp.common.service.GroupService;
import com.yp.common.service.ManagementagreementService;
import com.yp.common.service.ResponsibilityagreementService;
import com.yp.common.utils.FileUtils;
import com.yp.subpark.jsonUtil.AdmissioncontractToJson;
import com.yp.subpark.jsonUtil.ManagementagreementToJson;
import com.yp.subpark.jsonUtil.ResponsibilityagreementToJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("general")
public class GeneralSubparkAgreementController {
    @Autowired
    private AdmissioncontractService admissioncontractService; // 入园合同
    @Autowired
    private ManagementagreementService managementagreementService; //资产协议
    @Autowired
    private ResponsibilityagreementService responsibilityagreementService; //卫生协议
    @Autowired
    private GroupService groupService;

    //入园合同
    @RequestMapping("selectSubparkAgreement")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView GroupManagement(ModelAndView modelAndView, HttpServletRequest request) {
        String subParkId = request.getParameter("subParkId");
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/general/SelectSubparkAdmissioncontract");
        return modelAndView;
    }

    @RequestMapping("subparkAdmissioncontract")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> SubparkAgreement(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        List<Admissioncontract> admissioncontractList = admissioncontractService.selectAdmissioncontractByLimit(subParkId, page - 1, limit);
        JSONArray admissioncontractData = AdmissioncontractToJson.admissioncontractInfoToJson(admissioncontractList);
        if (admissioncontractData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", admissioncontractData.size());
            jsonObject.put("data", admissioncontractData);
            return jsonObject;
        }
        return null;
    }

//资产管理协议表

    @RequestMapping("selectSubparkManagementagreement")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SubparkManagementagreement(ModelAndView modelAndView, HttpServletRequest request) {
        String subParkId = request.getParameter("subParkId");
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/general/SelectSubparkManagementagreement");
        return modelAndView;
    }

    @RequestMapping("subparkManagementagreement")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> SubparkManagementagreement(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        Map<String, Object> map = new HashMap<>();
        map.put("subParkId", subParkId);
        map.put("page", page - 1);
        map.put("limit", limit);
        List<Managementagreement> managementagreementList = managementagreementService.selectManagementagreementByMap(map);
        JSONArray managementagreementData = ManagementagreementToJson.managementagreementInfoToJson(managementagreementList);
        if (managementagreementData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", managementagreementData.size());
            jsonObject.put("data", managementagreementData);
            return jsonObject;
        }
        return null;
    }

    //卫生责任协议表
    @RequestMapping("selectSubparkResponsibilityagreement")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SubparkResponsibilityagreement(ModelAndView modelAndView, HttpServletRequest request) {
        String subParkId = request.getParameter("subParkId");
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/general/SelectSubparkResponsibilityagreement");
        return modelAndView;
    }

    @RequestMapping("subparkResponsibilityagreement")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> SubparkResponsibilityagreement(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        Map<String, Object> map = new HashMap<>();
        map.put("subParkId", subParkId);
        map.put("page", page - 1);
        map.put("limit", limit);
        List<Responsibilityagreement> responsibilityagreementList = responsibilityagreementService.selectResponsibilityagreementBymap(map);
        JSONArray responsibilityagreementData = ResponsibilityagreementToJson.responsibilityagreementInfoToJson(responsibilityagreementList);
        if (responsibilityagreementData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", responsibilityagreementData.size());
            jsonObject.put("data", responsibilityagreementData);
            return jsonObject;
        }
        return null;
    }


    //根据时间进行查看入园合同
    @RequestMapping("selectAdmissioncontractByTime")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectAgreementByTime(ModelAndView modelAndView, @RequestParam("beginTime") String beginTime,
                                              @RequestParam("endTime") String endTime, Integer subParkId) {
        modelAndView.addObject("beginTime", beginTime);
        modelAndView.addObject("endTime", endTime);
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/general/SelectAdmissioncontractByTime");
        return modelAndView;
    }

    @RequestMapping("subparkAdmissioncontractByTime")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> SubparkAgreementByTime(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        Map<String, Object> map = new HashMap<>();
        map.put("subParkId", subParkId);
        map.put("signDate", beginTime);
        map.put("expirationDate", endTime);
        map.put("page", page - 1);
        map.put("limit", limit);
        List<Admissioncontract> admissioncontractList = admissioncontractService.selectAdmissioncontractByCondition(map);
        JSONArray admissioncontractData = AdmissioncontractToJson.admissioncontractInfoToJson(admissioncontractList);
        if (admissioncontractData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", admissioncontractData.size());
            jsonObject.put("data", admissioncontractData);
            return jsonObject;
        }
        return null;
    }

    //根据时间查看资产管理协议
    @RequestMapping("selectManagementagreementByTime")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectManagementagreementByTime(ModelAndView modelAndView, @RequestParam("beginTime") String beginTime,
                                                        @RequestParam("endTime") String endTime, Integer subParkId) {
        modelAndView.addObject("beginTime", beginTime);
        modelAndView.addObject("endTime", endTime);
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/general/SelectManagementagreementByTime");
        return modelAndView;
    }

    @RequestMapping("subparkManagementagreementByTime")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> SubparkManagementagreementByTime(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        Map<String, Object> map = new HashMap<>();
        map.put("subParkId", subParkId);
        map.put("signDate", beginTime);
        map.put("expirationDate", endTime);
        map.put("page", page - 1);
        map.put("limit", limit);
        List<Managementagreement> managementagreementList = managementagreementService.selectManagementagreementByCondition(map);
        JSONArray managementagreementData = ManagementagreementToJson.managementagreementInfoToJson(managementagreementList);
        if (managementagreementData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", managementagreementData.size());
            jsonObject.put("data", managementagreementData);
            return jsonObject;
        }
        return null;
    }

    //根据时间分页查看卫生责任协议表
    @RequestMapping("selectResponsibilityagreementByTime")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectResponsibilityagreementByTime(ModelAndView modelAndView, @RequestParam("beginTime") String beginTime,
                                                            @RequestParam("endTime") String endTime, Integer subParkId) {
        modelAndView.addObject("beginTime", beginTime);
        modelAndView.addObject("endTime", endTime);
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/general/SelectResponsibilityagreementByTime");
        return modelAndView;
    }

    @RequestMapping("subparkResponsibilityagreementByTime")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> SubparkResponsibilityagreementByTime(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        Map<String, Object> map = new HashMap<>();
        map.put("subParkId", subParkId);
        map.put("signDate", beginTime);
        map.put("expirationDate", endTime);
        map.put("page", page - 1);
        map.put("limit", limit);
        List<Responsibilityagreement> responsibilityagreementList = responsibilityagreementService.selectResponsibilityagreementByCondition(map);
        JSONArray responsibilityagreementDate = ResponsibilityagreementToJson.responsibilityagreementInfoToJson(responsibilityagreementList);
        if (responsibilityagreementDate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", responsibilityagreementDate.size());
            jsonObject.put("data", responsibilityagreementDate);
            return jsonObject;
        }
        return null;
    }

    //下载入园合同表
    @RequestMapping("downLoadAdmissioncontract")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView DownLoadAdmissioncontract(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
        Admissioncontract admissioncontract = admissioncontractService.selectOneAdmissioncontract(Integer.parseInt(request.getParameter("admissionId")));
        String path = admissioncontract.getFilePath();
        String name = admissioncontract.getAdmissionName();
        FileUtils fileUtils = new FileUtils();
        String s = fileUtils.downFile(name, path, response);
        if (s.equals("success")) {
            System.out.println("下载成功");
        } else {
            System.out.println("下载失败");
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("subParkId", user.getSubParkId());
        modelAndView.setViewName("view/general/SelectSubparkAdmissioncontract");
        return modelAndView;
    }

    //下载资产管理协议表
    @RequestMapping("downLoadManagementagreement")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView DownLoadManagementagreement(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
        Managementagreement managementagreement = managementagreementService.selectOneManagementagreementByid(Integer.parseInt(request.getParameter("managementId")));
        String path = managementagreement.getFilePath();
        String name = managementagreement.getManagementName();
        FileUtils fileUtils = new FileUtils();
        String s = fileUtils.downFile(name, path, response);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("subParkId", user.getSubParkId());
        modelAndView.setViewName("view/general/SelectSubparkManagementagreement");
        return modelAndView;
    }

    @RequestMapping("downLoadResponsibilityagreement")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView DownLoadResponsibilityagreement(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
        Responsibilityagreement responsibilityagreement = responsibilityagreementService.selectOneResponsibilityagreementById(Integer.parseInt(request.getParameter("responsibleId")));
        String path = responsibilityagreement.getFilePath();
        String name = responsibilityagreement.getResponsibleName();
        FileUtils fileUtils = new FileUtils();
        String s = fileUtils.downFile(name, path, response);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("subParkId", user.getSubParkId());
        modelAndView.setViewName("view/general/SelectSubparkResponsibilityagreement");
        return modelAndView;
    }
}
