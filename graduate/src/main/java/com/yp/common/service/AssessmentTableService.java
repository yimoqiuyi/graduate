package com.yp.common.service;

import com.yp.common.pojo.AssessmentTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssessmentTableService {
    //根据id查看任务指标
    public AssessmentTable selectOneAssessmentTableByassessmentId(@Param("assessmentId") int assessmentId);

    //根据团队id选择查看团队任务指标
    public AssessmentTable selectOneAssessmentTableByid(@Param("groupId") int groupId);

    //查看所有任务指标
    public List selectAllAssessmentTable();

    //录入团队任务
    public boolean insertOneAssessmentTable(AssessmentTable assessmentTable);

    //修改团队任务根据团队id
    public boolean updateOneAssessmentTableByid(AssessmentTable assessmentTable);

    //删除团队任务
    public int deleteOneAssessmentTableById(@Param("assessmentId")int assessmentId);

    //根据团队id删除团队任务
    public int delectOneAssessmentTableByid(@Param("groupId")int groupId);

    //删除所有团队任务
    public int delectAllAssessmentTable();
}
