package com.yp.role.controller;

import com.yp.common.pojo.Permission;
import com.yp.common.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("role")
public class GroupPermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("selectPermission")
    @RequiresPermissions(value="permission:select")
    public String viewAllPermission(ModelAndView modelAndView){
        ArrayList list= (ArrayList) permissionService.selectAllPermission();
        modelAndView.addObject("permissionlist",list);
        return "view/";
    }

}
