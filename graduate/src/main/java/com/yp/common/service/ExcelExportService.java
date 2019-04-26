package com.yp.common.service;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

public interface ExcelExportService {
  public void markWorkBook(Map<String, Object> model, Workbook workbook);
}
