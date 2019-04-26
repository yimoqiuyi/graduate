package com.yp.root.controlller;

import com.yp.common.pojo.Permission;
import com.yp.common.pojo.Role;
import com.yp.common.service.RoleService;
import com.yp.common.utils.ResultUtil;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("admin")
public class RootRoleController {
    @Autowired
    private RoleService roleService;  //角色管理

    @RequestMapping(value = "roleConfiguration")
    @RequiresRoles(value = "admin")  //系统管理员
    public String RoleConfiguration(Permission permission) {
        return "view/admin/RoleConfiguration";
    }

    @RequestMapping("selectRole")
    @RequiresRoles("admin")
    @ResponseBody
    public ResultUtil selectRole(Integer page, Integer limit) {
        List<Role> roleList = roleService.selectRoleByLimit(page - 1, limit);
        JsonConfig jsonConfig = new JsonConfig();  //排除json将要
        jsonConfig.setExcludes(new String[]{"userList"});
//        jsonConfig.setExcludes(new String[]{"roleList", "sanitationList", "attendanceList"});
        JSONArray jsonArray = JSONArray.fromObject(roleList, jsonConfig);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCount(roleList.size());
        resultUtil.setCode(0);
        resultUtil.setMsg("");
        resultUtil.setData(jsonArray);
        return resultUtil;
    }

    //修改角色
    @RequestMapping("updateOneRole")
    @RequiresRoles("admin")
    public ModelAndView UpdateOneRole(HttpServletRequest request, ModelAndView modelAndView) {
        Role role = roleService.selectOneRoleById(Integer.parseInt(request.getParameter("roleId")));
        modelAndView.addObject("role", role);
        modelAndView.setViewName("view/admin/Role");
        return modelAndView;
    }

    @RequestMapping("updateToRole")
    @RequiresRoles("admin")
    public String UpdateToRole(Role role) {
        roleService.updateOneRole(role);
        return "redirect:roleConfiguration.do";
    }

    //删除角色
    @RequestMapping("deleteOneRole")
    @RequiresRoles("admin")
    public String DeleteOneRole(HttpServletRequest request) {
        roleService.delectOneRoleById(Integer.parseInt(request.getParameter("roleId")));
        return "redirect:roleConfiguration.do";
    }
    //添加角色
    @RequestMapping("insertOneRole")
    @RequiresRoles("admin")
    public String InsertOneRole(){
        return "view/admin/InsertOneRole";
    }
    @RequestMapping("insertToRole")
    @RequiresRoles("admin")
    public String  InsertToRole(Role role){
        roleService.insertOneRole(role);
        return "redirect:roleConfiguration.do";
    }

}
