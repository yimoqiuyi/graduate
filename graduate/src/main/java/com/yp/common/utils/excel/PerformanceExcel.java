package com.yp.common.utils.excel;

import com.yp.common.pojo.AchievementsNumber;
import com.yp.common.pojo.Performance;
import com.yp.common.utils.Myutils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class PerformanceExcel extends AbstractExcelView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook hssfWorkbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<Performance> performanceList= (List<Performance>) map.get("performanceList");
        HSSFSheet sheet = hssfWorkbook.createSheet("performanceList");//list
        sheet.setDefaultColumnWidth((short) 12);
        HSSFCell cell = getCell(sheet, 0, 0);
        setText(cell, "团队绩效表");
        HSSFCellStyle dateStyle = hssfWorkbook.createCellStyle();
        dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
        cell = getCell(sheet, 1, 0);
        cell.setCellStyle(dateStyle);
        getCell(sheet, 2, 0).setCellValue("绩效分数");
        getCell(sheet, 2, 1).setCellValue("开始时间");
        getCell(sheet, 2, 2).setCellValue("结束时间");
        getCell(sheet, 2, 3).setCellValue("团队名称");
        HSSFRow sheetRow = sheet.createRow(3);
        for (Performance performance : performanceList) {
            sheetRow.createCell(0).setCellValue(performance.getPerformanceScore());
            sheetRow.createCell(1).setCellValue(performance.getStartTime());
            sheetRow.createCell(2).setCellValue(performance.getEndTime());
            sheetRow.createCell(3).setCellValue(performance.getGroupName());
        }
        String filename = "团队绩效表.xls";//设置下载时客户端Excel的名称
        filename = Myutils.encodeFilename(filename, httpServletRequest);//处理中文文件名
        httpServletResponse.setContentType("application/vnd.ms-excel");
        httpServletResponse.setHeader("Content-disposition", "attachment;filename=" + filename);
        OutputStream ouputStream =httpServletResponse.getOutputStream();
        hssfWorkbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }
}
