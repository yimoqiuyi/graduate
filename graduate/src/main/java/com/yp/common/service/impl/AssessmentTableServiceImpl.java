package com.yp.common.service.impl;

import com.yp.common.mapper.AssessmentTableMapper;
import com.yp.common.pojo.AssessmentTable;
import com.yp.common.service.AssessmentTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AssessmentTableServiceImpl implements AssessmentTableService {
@Autowired
private AssessmentTableMapper assessmentTableMapper;


    @Override
    public AssessmentTable selectOneAssessmentTableByassessmentId(int assessmentId) {
        return assessmentTableMapper.selectOneAssessmentTableByassessmentId(assessmentId);
    }

    @Override
    public AssessmentTable selectOneAssessmentTableByid(int groupId) {
        return assessmentTableMapper.selectOneAssessmentTableByid(groupId);
    }

    @Override
    public List selectAllAssessmentTable() {
        return assessmentTableMapper.selectAllAssessmentTable();
    }

    @Override
    public boolean insertOneAssessmentTable(AssessmentTable assessmentTable) {
        return assessmentTableMapper.insertOneAssessmentTable(assessmentTable);
    }

    @Override
    public boolean updateOneAssessmentTableByid(AssessmentTable assessmentTable) {
        return assessmentTableMapper.updateOneAssessmentTableByid(assessmentTable);
    }

    @Override
    public int deleteOneAssessmentTableById(int assessmentId) {
        return assessmentTableMapper.deleteOneAssessmentTableById(assessmentId);
    }

    @Override
    public int delectOneAssessmentTableByid(int groupId) {
        return assessmentTableMapper.delectOneAssessmentTableByid(groupId);
    }

    @Override
    public int delectAllAssessmentTable() {
        return assessmentTableMapper.delectAllAssessmentTable();
    }
}
