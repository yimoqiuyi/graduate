package com.yp.subpark.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.*;
import com.yp.common.service.*;
import com.yp.subpark.jsonUtil.RoomToJson;
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
public class SubparkRoomController {
    @Autowired
    private GeneralParkService generalParkService;
    @Autowired
    private SubParkService subParkService;    //分园区
    @Autowired
    private RoomService roomService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private WorkPositionService workPositionService;
    @Autowired
    private ParkassetsService parkassetsService;//资产service类

    @RequestMapping("selectRoom")
    @RequiresPermissions("role:insert")
    public String SelectRoom() {
        return "view/subpark/SubparkRoom";
    }

    @RequestMapping("checkRoom")
    @RequiresPermissions("role:insert")
    public @ResponseBody
    Map<String, Object> checkRoom(ModelAndView modelAndView, Integer page, Integer limit) {
        Subject subject = SecurityUtils.getSubject();
        Session session = (Session) subject.getSession();
        User user = (User) session.getAttribute("user");
        int subParkId = user.getSubParkId();
        List<Room> roomList = roomService.seletctRoomByLimit(subParkId, page, limit);
        JSONArray roomdate = RoomToJson.RoomInfoToJson(roomList);
        if (roomdate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", roomdate.size());
            jsonObject.put("data", roomdate);
            return jsonObject;
        }
        return null;
    }

    //选择房间查看
    @RequestMapping("selectOneRoom")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectOneRoom(ModelAndView modelAndView, HttpServletRequest request) {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        Room room = roomService.selectOneRoomById(roomId);
        modelAndView.addObject("room", room);
        modelAndView.setViewName("view/subpark/CheckOneRoom");
        return modelAndView;
    }

    //选择更改房间
    @RequestMapping("updateRoom")
    @RequiresPermissions("role:insert")
    public ModelAndView UpdateRoom(ModelAndView modelAndView, HttpServletRequest request) {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        Room room = roomService.selectOneRoomById(roomId);
        int subparkId = room.getSubParkId();
        SubPark subPark = subParkService.selectOneSubParkById(subparkId);
        int generalId = room.getGeneralParkId();
        GeneralPark generalPark = generalParkService.selectOneGeneralParkBygeneralParkId(generalId);
        modelAndView.addObject("generalPark", generalPark);
        modelAndView.addObject("subPark", subPark);
        modelAndView.addObject("room", room);
        modelAndView.setViewName("view/subpark/UpdateRoom");
        return modelAndView;
    }

    @RequestMapping("updateToinsert")
    @RequiresPermissions("role:insert")
    public String UpdateToInsert(Room room) {
        roomService.updateOneRoom(room);
        return "view/subpark/index";
    }

    @RequestMapping("deleteRooms")
    @RequiresPermissions("role:insert")
    public String DeleteRooms(HttpServletRequest request) {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        roomService.deleteOneRoomById(roomId);
        parkassetsService.deleteParkassetsByRoomId(roomId);
        return "view/subpark/index";
    }
}
