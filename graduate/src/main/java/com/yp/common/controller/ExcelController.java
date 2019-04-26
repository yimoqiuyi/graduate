package com.yp.common.controller;

import com.yp.common.utils.excel.ExcelView;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequestMapping("excel")
public class ExcelController {
    @RequestMapping(value = "/dcExcel", method = RequestMethod.GET)
    public ModelAndView toDcExcel(ModelMap model, HttpServletRequest request) {
        List list = new ArrayList();  //测试数据没有用到
        Map map = new HashMap();
        list.add("test1");
        list.add("test2");
        map.put("list", list);
        ModelAndView modelAndView=new ModelAndView();
         modelAndView.addObject("memberList",list);
        ExcelView viewExcel = new ExcelView();
        return new ModelAndView(viewExcel, model);
    }
}
