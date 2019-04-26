package com.yp.root.controlller;

import com.github.pagehelper.PageHelper;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.yp.common.pojo.Permission;
import com.yp.common.pojo.User;
import com.yp.common.pojo.WorkPosition;
import com.yp.common.service.UserService;
import com.yp.common.service.WorkPositionService;
import com.yp.common.utils.ResultUtil;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("admin")
public class RootUserController {
    @Autowired
    private UserService userService;  //用户管理
    @Autowired
    private WorkPositionService workPositionService;

    @RequestMapping(value = "userConfiguration")
    @RequiresRoles(value = "admin")  //系统管理员
    public String permissionConfiguration(Permission permission) {
        return "view/admin/UserConfiguration";
    }

    @RequestMapping("selectUser")
    @RequiresRoles("admin")
    @ResponseBody
    public ResultUtil SelectUser(Integer page, Integer limit) {
         List<User> users=userService.selectAllUsers(); //查看所有的成员
         PageHelper.startPage(page,limit);
        List<User> userList=userService.selectAllUsers(); //分页查看成员
        JsonConfig jsonConfig = new JsonConfig();  //排除json将要
        jsonConfig.setExcludes(new String[]{"workPosition"});
        jsonConfig.setExcludes(new String[]{"roleList", "sanitationList", "attendanceList"});
        JSONArray jsonArray = JSONArray.fromObject(userList, jsonConfig);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCount(users.size());
        resultUtil.setCode(0);
        resultUtil.setMsg("");
        resultUtil.setData(jsonArray);
        return resultUtil;
    }

    //选择人员
    @RequestMapping("selectOneUser")
    @RequiresRoles("admin")
    public ModelAndView SelectOneUser(ModelAndView modelAndView, HttpServletRequest request) {
        User user = userService.selectOneUserById(Integer.parseInt(request.getParameter("userId")));
        modelAndView.addObject("user", user);
        modelAndView.setViewName("view/admin/User");
        return modelAndView;
    }

    //删除用户
    @RequestMapping("deleteOneUser")
    @RequiresRoles("admin")
    public String DeleteOneUser(HttpServletRequest request) {
        userService.deleteOneUserById(Integer.parseInt(request.getParameter("userId")));
        return "redirect:userConfiguration.do";
    }

    //添加人员
    @RequestMapping("insertOneUser")
    @RequiresRoles("admin")
    public ModelAndView InsertOneUser(ModelAndView modelAndView) {
        List<WorkPosition> workPositionList = workPositionService.selectWorkPositionByState(0);
        modelAndView.addObject("workPositionList", workPositionList);
        modelAndView.setViewName("view/admin/InsertUser");
        return modelAndView;
    }

    @RequestMapping("insertToUser")
    @RequiresRoles("admin")
    public String InsertToUser(User user) {
        user.setGroupId(1);  //管理员创建都为1
        user.setWorkId(1);//管理员创建都为1
        user.setSubParkId(1); //管理员创建都为1
        user.setState(1);
        userService.insertOneUser(user);
        return "view/admin/index";
    }

    //查看自己资料
    @RequestMapping("select")
    @RequiresRoles("admin")
    public ModelAndView select(ModelAndView modelAndView, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        Session session = (Session) subject.getSession();
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("view/admin/UpdateUser");
        return modelAndView;
    }

    @RequestMapping("updateOneUser")
    @RequiresRoles("admin")
    public String updateOneUser(User user) {
        userService.updateOneUser(user);
        return "view/admin/index";
    }
}
