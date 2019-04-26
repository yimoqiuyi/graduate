package com.yp.common.service.impl;

import com.yp.common.mapper.WorkPositionMapper;
import com.yp.common.pojo.WorkPosition;
import com.yp.common.service.WorkPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkPositionServiceImpl implements WorkPositionService {
    @Autowired
    private WorkPositionMapper workPositionMapper;

    @Override
    public WorkPosition selectOneWorkPositionById(int workId) {
        return workPositionMapper.selectOneWorkPositionById(workId);
    }

    @Override
    public List<WorkPosition> selectAllWorkPositionBySubparkId(int subparkId) {
        return workPositionMapper.selectAllWorkPositionBySubparkId(subparkId);
    }

    @Override
    public List<WorkPosition> selectWorkPositionByState(int state) {
        return workPositionMapper.selectWorkPositionByState(state);
    }

    @Override
    public List<WorkPosition> selectAllWorkPositionBygroupIdandState(int groupId, int workState) {
        return workPositionMapper.selectAllWorkPositionBygroupIdandState(groupId,workState);
    }


    @Override
    public List<WorkPosition> selectWorkPositionByworkStyleId(int workStyleId) {
        return workPositionMapper.selectWorkPositionByworkStyleId(workStyleId);
    }

    @Override
    public List<WorkPosition> selectAllWorkPositionBygroupId(int groupId) {
        return workPositionMapper.selectAllWorkPositionBygroupId(groupId);
    }

    @Override
    public List<WorkPosition> selectAllWorkPositionByroomId(int roomId) {
        return workPositionMapper.selectAllWorkPositionByroomId(roomId);
    }

    @Override
    public boolean insertOneWorkPosition(WorkPosition workPosition) {
        return workPositionMapper.insertOneWorkPosition(workPosition);
    }

    @Override
    public boolean updateOneWorkPosition(WorkPosition workPosition) {
        return workPositionMapper.updateOneWorkPosition(workPosition);
    }

    @Override
    public int deleteOneWorkPositionById(int workId) {
        return workPositionMapper.deleteOneWorkPositionById(workId);
    }

    @Override
    public int selectWorkPositionByRoomId(int roomId) {
        return workPositionMapper.selectWorkPositionByRoomId(roomId);
    }
}
