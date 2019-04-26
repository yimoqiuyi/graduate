package com.yp.subpark.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Attendance;
import com.yp.common.pojo.Group;
import com.yp.common.pojo.Sanitation;
import com.yp.common.pojo.User;
import com.yp.common.service.GroupService;
import com.yp.common.service.SanitationService;
import com.yp.common.service.UserService;
import com.yp.common.service.WorkhealthService;
import com.yp.subpark.jsonUtil.GroupToJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("subpark")
public class SubparkSanitationController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private SanitationService sanitationService;
    @Autowired
    private UserService userService;
    @Autowired
    private WorkhealthService workhealthService;

    @RequestMapping("subparkSanitation")
    @RequiresPermissions("role:insert")
    public String SubparkAttendance() {
        return "view/subpark/SubparkSanitation";
    }

    @RequestMapping("selectGroupSanitation")
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

    //卫生查看
    @RequestMapping("sanitationOperation")
    @RequiresPermissions("role:insert")
    public ModelAndView AttendanceOperation(ModelAndView modelAndView){
        List<Sanitation> sanitationList=sanitationService.selectAllSanitation();
        modelAndView.addObject("sanitationList",sanitationList);
        modelAndView.setViewName("view/subpark/SanitationOperation");
        return modelAndView;
    }
    //添加卫生
    @RequestMapping("addSanitation")
    @RequiresPermissions("role:insert")
    public String AddAttendance(){
        return "view/common/AddSanitation";
    }
    @RequestMapping("insertSanitation")
    @RequiresPermissions("role:insert")
    public String InsertAttendance(Sanitation sanitation){
        sanitationService.insertOneSanitation(sanitation);
        return "view/subpark/index";
    }

    //修改卫生
    @RequestMapping("updateSanitation")
    @RequiresPermissions("role:insert")
    public ModelAndView updateAttendace(ModelAndView modelAndView, HttpServletRequest request){
        Sanitation sanitation=sanitationService.selectOneSanitationById(Integer.parseInt(request.getParameter("sId")));
        modelAndView.addObject("sanitation",sanitation);
        modelAndView.setViewName("view/common/SubparkSanitation");
        return modelAndView;
    }
    @RequestMapping("updateToSanitation")
    @RequiresPermissions("role:insert")
    public String UpdateToAttendacne(Sanitation sanitation){
        sanitationService.updateOneSanitation(sanitation);
        return "view/subpark/index";
    }
    //删除卫生
    @RequestMapping("deleteSanitation")
    @RequiresPermissions("role:insert")
    public String DeleteAttendance(HttpServletRequest request){
        sanitationService.deleteOneSanitationById(Integer.parseInt(request.getParameter("sId")));
        return "redirect:sanitationOperation.do";
    }


    //团队卫生
     @RequestMapping("groupSanitation")
    @RequiresPermissions("role:insert")
    public ModelAndView GroupAttendance(ModelAndView modelAndView,HttpServletRequest request){
        List<User> userList=userService.selectAllUserBygroupId(Integer.parseInt(request.getParameter("groupId")));
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("view/subpark/GroupSanitation");
        return modelAndView;
    }
    //用户卫生查看操作
    @RequestMapping("selectUserSanitation")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectUserAttendacne(HttpServletRequest request,ModelAndView modelAndView){
        int userId=Integer.parseInt(request.getParameter("userId"));
        List<Sanitation> sanitationList=sanitationService.selectSanitationByUserId(userId);
        User user=userService.selectOneUserById(userId);
        modelAndView.addObject("user",user);
        modelAndView.addObject("sanitationList",sanitationList);
        modelAndView.setViewName("view/subpark/SubparkUserSanitation");
        return modelAndView;
    }

    //用户查看卫生删除,用户卫生重新部署
    @RequestMapping("deleteUserSanitation")
    @RequiresPermissions("role:insert")
    public String DeleteUserAttendance(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        workhealthService.deleteWorkHealthByUserId(userId);
        User user=userService.selectOneUserById(userId);
        user.setAttendanceScore(100);
        user.setWorkRatio("100%");
        userService.updateOneUser(user);
        return "view/subpark/index";
    }
}
