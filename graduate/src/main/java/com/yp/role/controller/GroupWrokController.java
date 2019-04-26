package com.yp.role.controller;

import com.yp.common.pojo.*;
import com.yp.common.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//团队工位
@Controller
@RequestMapping("group")
public class GroupWrokController {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private WorkPositionService workPositionService;
    @Autowired
    private WorkstylePictureService workstylePictureService;
    @Autowired
    private SubParkService subParkService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private RoomService roomService;

    @RequestMapping("userPosition")
    @RequiresPermissions("role:select")
    public String UserPosition() {
        return "view/group/PositionUser";
    }

    @RequestMapping("checkUserPosition")
    @RequiresPermissions("role:select")
    public ModelAndView checkUserPosition(ModelAndView modelAndView, HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userService.selectOneUserById(userId);  //用户
        int workId = user.getWorkId();
        WorkPosition workPosition = workPositionService.selectOneWorkPositionById(workId); //工位所在
        WorkstylePicture workstylePicture = workstylePictureService.selectWorkstylePictureByworkId(workId); //工位样式
        int roomId = workPosition.getRoomId();
        Room room = roomService.selectOneRoomById(roomId);
        modelAndView.addObject("user", user);
        modelAndView.addObject("workPosition", workPosition);
        modelAndView.addObject("workstylePicture", workstylePicture);
        modelAndView.addObject("room", room);
        modelAndView.setViewName("view/group/Position");
        return modelAndView;
    }

    @RequestMapping("checkAllWorkPosition")
    public String AddworkPositionToGroup(User user) {
        int groupId = user.getUserId();
        Group group = groupService.selectOneGroupById(groupId);
        List<WorkPosition> positionList = workPositionService.selectAllWorkPositionBygroupId(groupId);

        return "view/group/";

    }

    @RequestMapping("addworkPosition")
    public String AddworkPositionToGroup(User user, WorkPosition[] workPositions) {
        int groupId = user.getGroupId();
        for (int i = 0; i < workPositions.length; i++) {
            WorkPosition workPosition = workPositions[i];
            workPosition.setGroupId(groupId);
        }
        return "view/group/";
    }

}
