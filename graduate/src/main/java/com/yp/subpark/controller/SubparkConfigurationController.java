package com.yp.subpark.controller;

import com.yp.common.pojo.*;
import com.yp.common.service.*;
import com.yp.common.utils.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("subpark")
public class SubparkConfigurationController {
    @Autowired
    private GeneralParkService generalParkService;
    @Autowired
    private SubParkService subParkService;    //分园区
    @Autowired
    private GroupService groupService;    //团队
    @Autowired
    private UserService userService;     //用户
    @Autowired
    private BuildingService buildingService;  //栋
    @Autowired
    private RoomService roomService; //房间
    @Autowired
    private WorkPositionService workPositionService;  //工位
    @Autowired
    private WorkstylePictureService workstylePictureService;  //工位样式图

    @RequestMapping("insertConfiguration")
    @RequiresPermissions("role:insert")  //只允许分园区以及root能操作
    public ModelAndView insertConfiguration(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subparkId = user.getSubParkId();
        String userName = user.getUserName();
        SubPark subPark = subParkService.selectOneSubParkById(subparkId);
        modelAndView.addObject("subPark", subPark);
        modelAndView.addObject("userName", userName);
        modelAndView.setViewName("view/subpark/SubparkConfiguration");
        return modelAndView;
    }

    //修改分园区信息
    @RequestMapping("updateSubPark")
    @RequiresPermissions("role:insert")
    public String insertsubPark(SubPark subPark) {
        subParkService.updateOneSubPark(subPark);
        return "redirect:insertConfiguration.do";
    }

    @RequestMapping("selectBuilding")
    @RequiresPermissions("role:insert")
    public ModelAndView insertBuilding(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subparkId = user.getSubParkId();
         List<Building> buildingList = buildingService.selectAllBuildingBysubParkId(subparkId);
        modelAndView.addObject("buildingList", buildingList);
        modelAndView.setViewName("view/subpark/BuildingConfiguration");
        return modelAndView;
    }

    @RequestMapping("AddRoom")
    @RequiresPermissions("role:insert")
    public ModelAndView AddRoom(ModelAndView modelAndView, HttpServletRequest request) {
        int buildId = Integer.parseInt(request.getParameter("buildId"));
        modelAndView.addObject("buildId", buildId);
        modelAndView.setViewName("view/subpark/AddRoom");
        return modelAndView;
    }

    @RequestMapping(value = "insertRoom", method = RequestMethod.POST)
    @RequiresPermissions("role:insert")
    public String InsertRoom(Room room, Integer buildId, @RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        FileUtils fileUtils = new FileUtils();
        String path = fileUtils.UploadRoomPicture(multipartFile);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subparkId = user.getSubParkId();
         SubPark subPark = subParkService.selectOneSubParkById(subparkId); //分园区
        int generalId = subPark.getGeneralParkId();
        room.setGeneralParkId(generalId);
        room.setSubParkId(subparkId);
        room.setBuildId(buildId);
        room.setRoomPicture(path); //保存房间图片路径
        roomService.insertOneRoom(room);   //添加房间
        int roomNum=roomService.selectRoomNumberByBuildId(buildId);// 房间总数
        Building building=buildingService.selectOneBuildingBybuildId(buildId);
        building.setRoomNumber(roomNum);
        buildingService.updateOneBuildingById(building);
        return "view/subpark/index";
    }
    //删出整栋的房间
    @RequestMapping("deleteRoom")
    @RequiresPermissions("role:insert")
    public void DeleteRoom(HttpServletRequest request) {
        int buildId = Integer.parseInt(request.getParameter("buildId"));
        roomService.deleteOneRoomBybuildId(buildId);   //删出整栋的房间
    }

}
