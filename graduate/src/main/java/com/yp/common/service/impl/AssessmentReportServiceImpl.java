package com.yp.common.service.impl;

import com.yp.common.mapper.AssessmentReportMapper;
import com.yp.common.pojo.AssessmentReport;
import com.yp.common.service.AssessmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssessmentReportServiceImpl implements AssessmentReportService {
    @Autowired
    private AssessmentReportMapper assessmentReportMapper;

    //根据主键选择报告
    public AssessmentReport selectAssessmentReportById(int reportId) {
        return assessmentReportMapper.selectAssessmentReportById(reportId);
    }

    @Override
    public AssessmentReport selectOneAssessmentReportByid(int groupId) {
        return assessmentReportMapper.selectOneAssessmentReportByid(groupId);
    }

    @Override
    public List selectAllAssessmentReport() {
        return assessmentReportMapper.selectAllAssessmentReport();
    }

    @Override
    public boolean insertAssessmentReport(AssessmentReport assessmentReport) {
        return assessmentReportMapper.insertAssessmentReport(assessmentReport);
    }

    @Override
    public boolean updateAssessmentReport(AssessmentReport assessmentReport) {
        return assessmentReportMapper.updateAssessmentReport(assessmentReport);
    }

    @Override
    public int delectAssessmentReportByid(int reportId) {
        return assessmentReportMapper.delectAssessmentReportByid(reportId);
    }

    @Override
    public int delectAllAssessmentReport() {
        return assessmentReportMapper.delectAllAssessmentReport();
    }
}
