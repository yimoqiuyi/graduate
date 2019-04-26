package com.yp.common.service.impl;

import com.yp.common.pojo.ExcelBean;
import com.yp.common.pojo.Performance;
import com.yp.common.utils.excel.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SalaryDao {
    public XSSFWorkbook exportExcelInfo(List<Performance> performanceList) throws InvocationTargetException, ClassNotFoundException, IllegalAccessException, IntrospectionException, ParseException {
         List<ExcelBean> excel=new ArrayList<>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook=null;
        //设置标题栏
        excel.add(new ExcelBean("Id","performanceId",0));
        excel.add(new ExcelBean("performanceScore","performanceScore",0));
        excel.add(new ExcelBean("startTime","startTime",0));
        excel.add(new ExcelBean("endTime","endTime",0));
        excel.add(new ExcelBean("groupName","groupName",0));
        excel.add(new ExcelBean("groupId","groupId",0));
         map.put(0, excel);
        String sheetName ="团队绩";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(Performance.class, performanceList, map, sheetName);
        return xssfWorkbook;
    }
}
