package com.yp.common.utils.excel;


import com.yp.common.pojo.AchievementsNumber;
import com.yp.common.utils.Myutils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class ExcelView extends AbstractExcelView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<AchievementsNumber> list = (List<AchievementsNumber>) map.get("memberList");
        HSSFSheet sheet = workbook.createSheet("list");//list
        sheet.setDefaultColumnWidth((short) 12);
        HSSFCell cell = getCell(sheet, 0, 0);
        setText(cell, "Spring Excel test");
        HSSFCellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
        cell = getCell(sheet, 1, 0);
        cell.setCellStyle(dateStyle);
        getCell(sheet, 2, 0).setCellValue("专利数量");
        getCell(sheet, 2, 1).setCellValue("软件数量");
        getCell(sheet, 2, 2).setCellValue("论文数量");
        getCell(sheet, 2, 3).setCellValue("竞赛数量");
        HSSFRow sheetRow = sheet.createRow(3);
        for (AchievementsNumber achievementsNumber : list) {
            sheetRow.createCell(0).setCellValue(achievementsNumber.getPatentNum());
            sheetRow.createCell(1).setCellValue(achievementsNumber.getSoftwareNum());
            sheetRow.createCell(2).setCellValue(achievementsNumber.getPaperNum());
            sheetRow.createCell(3).setCellValue(achievementsNumber.getCompetitionNum());
        }
        String filename = "测试.xls";//设置下载时客户端Excel的名称
        filename = Myutils.encodeFilename(filename, request);//处理中文文件名
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + filename);
        OutputStream ouputStream = response.getOutputStream();
        workbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }
  }


