package com.yp.common.utils;

import com.mysql.jdbc.StringUtils;
import com.yp.common.service.ExcelExportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.StringUtil;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ViewExcel extends AbstractExcelView {
     //文件名
    private String fileName=null;
    //导出视图自定义接口
    private ExcelExportService excelExportService;
    //构造方法一
    public ViewExcel(ExcelExportService excelExportService){
        this.excelExportService=excelExportService;
    }
    public ViewExcel(String viewName,ExcelExportService excelExportService){
        this.setBeanName(viewName);
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook hssfWorkbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
       if(excelExportService==null){
           throw new RuntimeException("导出服务接口不能为null");
       }
       if(!StringUtils.isNullOrEmpty(fileName)){
           String reqCharset=httpServletRequest.getCharacterEncoding();
           reqCharset=reqCharset==null?"UTF-8":reqCharset;
           fileName=new String(fileName.getBytes(reqCharset),"ISO8859-1");
           httpServletResponse.setHeader("Context-disposition","attachment;fileName="+fileName);
       }
       excelExportService.markWorkBook(map,hssfWorkbook);
     }
}
