package com.yp.general.controller;

import com.yp.common.pojo.GeneralPark;
import com.yp.common.pojo.SubPark;
import com.yp.common.pojo.User;
import com.yp.common.service.GeneralParkService;
import com.yp.common.service.SubParkService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("general")
public class GeneralSubparkController {
    @Autowired
    private SubParkService subParkService;
    @Autowired
    private GeneralParkService generalParkService;

    //分园区添加
    @RequestMapping("creeateSubpark")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView creeateSubpark(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        GeneralPark generalPark = generalParkService.selectGeneralParkByid(user.getUserId());
        int generalParkId = generalPark.getGeneralParkId();
        modelAndView.addObject("generalParkId", generalParkId);
        modelAndView.setViewName("view/general/CreeateSubpark");
        return modelAndView;
    }

    //添加分园区
    @RequestMapping("insertSubpark")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public String InsertSubpark(SubPark subPark) {
        subParkService.insertOneSubPark(subPark);
        return "view/general/index";
    }

    //操作分园区
    @RequestMapping("selectAllSubpark")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectAllSubpark(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        GeneralPark generalPark = generalParkService.selectGeneralParkByid(user.getUserId());
        List<SubPark> subParkList = subParkService.selectAllSubParkBygeneralParkId(generalPark.getGeneralParkId());
        modelAndView.addObject("subParkList", subParkList);
        modelAndView.setViewName("view/general/SelectAllSubpark");
        return modelAndView;
    }

    @RequestMapping("subparkOperation")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SubparkOperation(HttpServletRequest request, ModelAndView modelAndView) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/general/SubparkOperation");
        return modelAndView;
    }
}
