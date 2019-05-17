package com.yp.root.controlller;

import com.github.pagehelper.PageHelper;
import com.yp.common.pojo.*;
import com.yp.common.service.*;
import com.yp.common.utils.ResultUtil;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//系统管理员权限操作
@Controller
@RequestMapping("admin")
public class RootPermissionController {
    @Autowired
    private PermissionService permissionService; //权限管理
    @Autowired
    private RolePermissionService rolePermissionService; //角色权限管理
    @Autowired
    private UserRoleService userRoleService;//角色用户管理
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "permissionConfiguration")
    @RequiresRoles(value = "admin")  //系统管理员
    public String permissionConfiguration(Permission permission) {
        return "view/admin/PermissionConfiguration";
    }

    @RequestMapping("selectPermission")
    @RequiresRoles("admin")
    @ResponseBody
    public ResultUtil SelectPermission(Integer page, Integer limit) {
        List<Permission> permissionList = permissionService.selectPermissionByLimit(page, limit);
        JsonConfig jsonConfig = new JsonConfig();  //排除json将要
//        jsonConfig.setExcludes(new String[]{"workPosition"});
//        jsonConfig.setExcludes(new String[]{"roleList", "sanitationList", "attendanceList"});
        JSONArray jsonArray = JSONArray.fromObject(permissionList, jsonConfig);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCount(permissionList.size());
        resultUtil.setCode(0);
        resultUtil.setMsg("");
        resultUtil.setData(jsonArray);
        return resultUtil;
    }

    //修改权限配置
    @RequestMapping("selectOnePermission")
    @RequiresRoles("admin")
    public ModelAndView SelectOnePermission(HttpServletRequest request, ModelAndView modelAndView) {
        Permission permission = permissionService.selectOnePermissionById(Integer.parseInt(request.getParameter("id")));
        modelAndView.addObject("permission", permission);
        modelAndView.setViewName("view/admin/Permission");
        return modelAndView;
    }

    @RequestMapping("updateToPermission")
    @RequiresRoles("admin")
    public String UpdateToPermission(Permission permission) {
        permissionService.updatePermission(permission);
        return "redirect:permissionConfiguration.do";
    }

    //.删除权限
    @RequestMapping("deleteOnePermission")
    @RequiresRoles("admin")
    public String DeleteOnePermission(HttpServletRequest request) {
        permissionService.delectOnePermission(Integer.parseInt(request.getParameter("id")));
        return "redirect:permissionConfiguration.do";
    }

    //添加权限
    @RequestMapping("insertOnePermission")
    @RequiresRoles("admin")
    public String insertOnePermission() {
        return "view/admin/InsertOnePermission";
    }

    @RequestMapping("insertToPermission")
    @RequiresRoles("admin")
    public String InsertToPermission(Permission permission) {
        permissionService.insertPermission(permission);
        return "view/admin/InsertOnePermission";
    }


    //权限角色操作
    @RequestMapping("permissionAssignment")
    @RequiresRoles("admin")
    public String permissionAssignment() {
        return "view/admin/RolePermissionConfiguration";
    }

    @RequestMapping("selectRoles")
    @RequiresRoles("admin")
    @ResponseBody
    public ResultUtil selectRoles(Integer page, Integer limit) {
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

    //角色
    @RequestMapping("rolePermissionDistribution")
    @RequiresRoles("admin")
    public ModelAndView RolePermissionDistribution(ModelAndView modelAndView, HttpServletRequest request) {
        List<Permission> permissionList = permissionService.selectAllPermission();
        Role role = roleService.selectOneRoleById(Integer.parseInt(request.getParameter("roleId")));
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("view/admin/RolePermissionDistribution");
        return modelAndView;
    }

    //添加角色权限关系
    @RequestMapping("rolePermission")
    @RequiresRoles("admin")
    public String RolePermission(Integer roleId, @RequestParam("pId") String pId[]) {
        Role_Permission rolePermission = new Role_Permission();
        rolePermission.setRoleId(roleId);
        for (String id : pId) {
            rolePermission.setPermissionId(Integer.parseInt(id));
            rolePermissionService.insertOneRole_Permission(rolePermission);
        }
        return "redirect:permissionAssignment.do";
    }

    //查看角色权限
    @RequestMapping("checkRolePermission")
    @RequiresRoles("admin")
    public ModelAndView CheckRolePermission(ModelAndView modelAndView, HttpServletRequest request) {
        List<Permission> permissionList = permissionService.selectAllPermissionByRoleId(Integer.parseInt(request.getParameter("roleId")));
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.addObject("roleId", request.getParameter("roleId"));
        modelAndView.setViewName("view/admin/RolePermission");
        return modelAndView;
    }

    //删除角色权限
    @RequestMapping("deleteRolePermission")
    @RequiresRoles("admin")
    public String DeleteRolePermission(HttpServletRequest request, Integer roleId) {
        rolePermissionService.deleteRole_PermissionByroleIdAndId(roleId, Integer.parseInt(request.getParameter("id")));
        return "redirect:permissionAssignment.do";
    }


    //角色用户操作
    @RequestMapping("roleAssignment")
    @RequiresRoles("admin")
    public String RoleAssignment() {
        return "view/admin/RoleAssignment";
    }

    @RequestMapping("selectAllUser")
    @RequiresRoles("admin")
    @ResponseBody
    public ResultUtil SelectUser(Integer page, Integer limit) {
        List<User> users = userService.selectAllUsers(); //查看所有的成员
        PageHelper.startPage(page, limit);
        List<User> userList = userService.selectAllUsers(); //分页查看成员
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

    @RequestMapping("userRoleDistribution")
    @RequiresRoles("admin")
    public ModelAndView UserRoleDistribution(ModelAndView modelAndView, HttpServletRequest request) {
        User user = userService.selectOneUserById(Integer.parseInt(request.getParameter("userId")));
        List<Role> roleList = roleService.selectAllRole();
        modelAndView.addObject("user", user);
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("view/admin/UserRoleDistribution");
        return modelAndView;
    }

    @RequestMapping("userRole")
    @RequiresRoles("admin")
    public String UserRole(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int roleId = Integer.parseInt(request.getParameter("rId"));
        User_Role user_Role = userRoleService.selectUserRoleByUserId(userId);
        Role role = roleService.selectOneRoleById(roleId);
        System.out.println("roleId" + roleId);
        System.out.println("userId" + userId);
//        System.out.println("jue" + user_Role.getId());
        if (user_Role == null) {
            User_Role user_role = new User_Role();
            user_role.setRoleId(roleId);
            user_role.setUserId(userId);
            user_role.setUserRoleName(role.getIntroduce());
            userRoleService.insertOneUserRole(user_role);
        }
        else {
            user_Role.setUserRoleName(user_Role.getUserRoleName());
            user_Role.setRoleId(roleId);
            user_Role.setUserId(userId);
            int k=userRoleService.updateUserRole(user_Role);
            System.out.println("k0"+k);
        }
        return "view/admin/RoleAssignment";
    }

    //查看用户角色checkUserRole
    @RequestMapping("checkUserRole")
    @RequiresRoles("admin")
    public ModelAndView CheckUserRole(HttpServletRequest request, ModelAndView modelAndView) {
        List<Role> roleList = roleService.selectRoleByUserId(Integer.parseInt(request.getParameter("userId")));
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("view/admin/UserRole");
        return modelAndView;
    }
}
