package com.yp.general.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yp.common.pojo.Parkassets;
import com.yp.common.pojo.Room;
import com.yp.common.service.ParkassetsService;
import com.yp.common.service.RoomService;
import com.yp.subpark.jsonUtil.RoomToJson;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("general")
public class GeneralBuildingController {
    @Autowired
    private RoomService roomService; //房间
    @Autowired
    private ParkassetsService parkassetsService;//资产表

    @RequestMapping("selectBuildings")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView selectBuildings(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("subParkId", request.getParameter("subParkId"));
        modelAndView.setViewName("view/general/BuildingRoom");
        return modelAndView;
    }

    @RequestMapping("selectBuildingRoom")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> SelectBuildingRoom(HttpServletRequest request, Integer page, Integer limit) {
        int subparkId = Integer.parseInt(request.getParameter("subParkId"));
        List<Room> rooms=roomService.selectAllRoomBysubParkId(subparkId); //查看所有的成员
        PageHelper.startPage(page,limit);
        List<Room> roomList=roomService.selectAllRoomBysubParkId(subparkId); //分页查看成员
        JSONArray roomdate = RoomToJson.RoomInfoToJson(roomList);
        if (roomdate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", rooms.size());
            jsonObject.put("data", roomdate);
            return jsonObject;
        }
        return null;
    }

    @RequestMapping("selectRoomParkassets")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectRoomParkassets(ModelAndView modelAndView, HttpServletRequest request) {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        Parkassets parkassets=parkassetsService.selectOneParkassetsByroomId(roomId);
        modelAndView.addObject("parkassets",parkassets);
        modelAndView.setViewName("view/general/SelectRoomParkassets");
        return modelAndView;
    }

}
