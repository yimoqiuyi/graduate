package com.yp.role.controller;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.yp.common.pojo.Sanitation;
import com.yp.common.pojo.User;
import com.yp.common.pojo.Workhealth;
import com.yp.common.service.GroupService;
import com.yp.common.service.SanitationService;
import com.yp.common.service.UserService;
import com.yp.common.service.WorkhealthService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


//操作团队用户的卫生情况
@Controller
@RequestMapping("group")
public class GroupsanitationController {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private SanitationService sanitationService;
    @Autowired
    private WorkhealthService workhealthService;

    @RequestMapping("userSanitation")
    public ModelAndView userSanitation(HttpServletRequest request, ModelAndView modelAndView, Integer userId) {
//        int userId=Integer.parseInt(request.getParameter("userId"));
        User user = userService.selectOneUserById(userId);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("view/group/Sanitation");
        return modelAndView;
    }

    @RequestMapping("selectSanitation")
    @RequiresPermissions("role:select")
    public ModelAndView selectUserSanitation(ModelAndView modelAndView, HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Sanitation> sanitationList = sanitationService.selectSanitationByUserId(userId);
        User user = userService.selectOneUserById(userId);
        modelAndView.addObject("user", user);
        modelAndView.addObject("sanitationList", sanitationList);
        modelAndView.setViewName("view/group/SanitationUser");
        return modelAndView;
    }

    //添加用户卫生
    @RequestMapping("insertsanitation")
    @RequiresRoles("group")
    public ModelAndView insertSanitation(ModelAndView modelAndView, HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userService.selectOneUserById(userId);
        List<Sanitation> sanitationList = sanitationService.selectAllSanitation();
        modelAndView.addObject("user", user);
        modelAndView.addObject("sanitationList", sanitationList);
        modelAndView.setViewName("view/group/SanitationAddtoUser");
        return modelAndView;
    }

    @RequestMapping("insertToSanitation")
    @RequiresRoles("group")
    public String insertToSanitation(Integer userId, @Param("sId") String sId[]) {
        int id = 0;
        int score = 0;
        User user = userService.selectOneUserById(userId);
        Workhealth workhealth = null;
        for (int i = 0; i < sId.length; i++) {
            id = Integer.parseInt(sId[i]);
            Sanitation sanitation = sanitationService.selectOneSanitationById(id);
            workhealth = new Workhealth();
            workhealth.setUserId(userId);
            workhealth.setsId(id);
            score += sanitation.getSanitationScore();
            workhealthService.insertOneWorkhealth(workhealth);
        }
        user.setSanitationScore(user.getSanitationScore() - score);
        userService.updateOneUser(user);
        return "view/group/index";
    }
}
