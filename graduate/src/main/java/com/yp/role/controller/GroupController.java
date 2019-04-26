package com.yp.role.controller;

import com.yp.common.pojo.*;
import com.yp.common.service.GroupService;
import com.yp.common.service.RolePermissionService;
import com.yp.common.service.RoleService;
import com.yp.common.service.UserRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "group")
public class GroupController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private GroupService groupService;
   @RequestMapping("groupIntroduce")
   @RequiresPermissions("role:select")
   public String groupIntroduce(){
       return "view/group/GroupIntroduce";
   }
    @RequestMapping("insertGroupIntroduce")
    @RequiresRoles("group")
    public String InsertGroupIntroduce(@RequestParam("introduce") String introduce) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        Group group = groupService.selectOneGroupById(groupId);
        group.setGroupIntroduce(introduce);
        boolean f = groupService.updateOneGroup(group);
        System.out.println("添加是否成功" + f);
        return "view/group/index";
    }

    @RequestMapping(value = "viewRoleById")
    @RequiresPermissions(value = "role:select")
    public String viewRoleByRoleId(@RequestParam("roleId") String roleId) {
        int roleId1 = Integer.parseInt(roleId);
        Role role = roleService.selectOneRoleById(roleId1);
        return "view/role/";
    }

    @RequestMapping(value = "insertRole")
    @RequiresPermissions(value = "role:select")
    public String viewAllRoleById(Role role) {
        roleService.insertOneRole(role);
        return "view/";
    }

    //添加角色与用户的关联
    @RequestMapping(value = "insertRoleAndUser")
    @RequiresPermissions(value = {"role:select"})
    public String insertOneRole_Permission(@RequestParam("userId") String userId,
                                           @RequestParam("roleId") String roleId,
                                           @RequestParam("userRoleName") String userRoleName) {
        int userId1 = Integer.parseInt(userId);
        int roleId1 = Integer.parseInt(roleId);
        User_Role user_role = new User_Role();
        user_role.setRoleId(roleId1);
        user_role.setUserId(userId1);
        user_role.setUserRoleName(userRoleName);
        userRoleService.insertOneUserRole(user_role);
        return "view/";
    }
}
