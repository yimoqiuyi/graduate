package com.yp.common.service;

import com.yp.common.pojo.AssessmentReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssessmentReportService {
    //根据主键选择报告
    public AssessmentReport selectAssessmentReportById(@Param("reportId") int reportId);

    //根据团队Id选择团队考核报告
    public AssessmentReport selectOneAssessmentReportByid(@Param("groupId") int groupId);

    //选择所有团队报表
    public List selectAllAssessmentReport();

    //录入团队报表
    public boolean insertAssessmentReport(AssessmentReport assessmentReport);

    //根据团队id进行团队报表的修改
    public boolean updateAssessmentReport(AssessmentReport assessmentReport);

    //根据团队id删除团队报表
    public int delectAssessmentReportByid(@Param("reportId") int reportId);

    //删除所有的报表
    public int delectAllAssessmentReport();
}
