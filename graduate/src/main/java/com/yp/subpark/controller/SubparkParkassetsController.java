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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("subpark")
public class SubparkParkassetsController {
    @Autowired
    private SubParkService subParkService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private ParkassetsService parkassetsService;//×Ê²úserviceÀà

    @RequestMapping("selectBuildings")
    @RequiresPermissions("role:insert")
    public String selectBuildings() {
        return "view/subpark/BuildingRoom";
    }

    @RequestMapping("selectBuildingRoom")
    @RequiresPermissions("role:insert")
    public @ResponseBody
    Map<String, Object> SelectBuildingRoom(Integer page, Integer limit) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subparkId = user.getSubParkId();
        List<Room> roomList = roomService.seletctRoomByLimit(subparkId, page, limit);
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

    @RequestMapping("selectRoomParkassets")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectRoomParkassets(ModelAndView modelAndView, HttpServletRequest request){
        int roomId=Integer.parseInt(request.getParameter("roomId"));
        Parkassets parkassets=parkassetsService.selectOneParkassetsByroomId(roomId);
        modelAndView.addObject("roomId",roomId);
         if(parkassets==null){
            modelAndView.setViewName("view/subpark/insertParkassets");
        }else{
            modelAndView.addObject("parkassets",parkassets);
            modelAndView.setViewName("view/subpark/parkassets");
        }
        return modelAndView;
    }
    @RequestMapping("checkSubparkinsertParkassets")
    @RequiresPermissions("role:insert")
    public String InsertParkassets(Integer roomId,Parkassets parkassets){
        parkassets.setRoomId(roomId);
        parkassetsService.insertOneParkassets(parkassets);
        return "view/subpark/index";
    }
    @RequestMapping("updateRoomParkassets")
    @RequiresPermissions("role:insert")
    public ModelAndView UpdateRoomParkassets(ModelAndView modelAndView,HttpServletRequest request){
        Parkassets parkassets=parkassetsService.selectOneParkassetsByroomId(Integer.parseInt(request.getParameter("roomId")));
        modelAndView.addObject("parkassets",parkassets);
        modelAndView.setViewName("view/subpark/parkassets");
        return modelAndView;
    }
    @RequestMapping(value = "updateParkassets",method = RequestMethod.POST)
    @RequiresPermissions("role:insert")
    public String UpdateParkassets(Parkassets parkassets){
        parkassetsService.updateOneParkassets(parkassets);
        return "view/subpark/index";
    }
}
