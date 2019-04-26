package com.yp.common.service.impl;

import com.yp.common.mapper.WorkstylePictureMapper;
import com.yp.common.pojo.WorkstylePicture;
import com.yp.common.service.WorkstylePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkstylePictureServiceImpl implements WorkstylePictureService {
    @Autowired
    private WorkstylePictureMapper workstylePictureMapper;

    @Override
    public WorkstylePicture selectOneWorkstylePictureById(int workStyleId) {
        return workstylePictureMapper.selectOneWorkstylePictureById(workStyleId);
    }

    @Override
    public List<WorkstylePicture> selectAllWorkstylePicture() {
        return workstylePictureMapper.selectAllWorkstylePicture();
    }

    @Override
    public boolean insertOneWorkstylePicture(WorkstylePicture workstylePicture) {
        return workstylePictureMapper.insertOneWorkstylePicture(workstylePicture);
    }

    @Override
    public boolean updateOneWorkstylePicture(WorkstylePicture workstylePicture) {
        return workstylePictureMapper.updateOneWorkstylePicture(workstylePicture);
    }

    @Override
    public int deleteOneWorkstylePictureById(int workStyleId) {
        return workstylePictureMapper.deleteOneWorkstylePictureById(workStyleId);
    }

    @Override
    public WorkstylePicture selectWorkstylePictureByworkId(int workId) {
        return workstylePictureMapper.selectWorkstylePictureByworkId(workId);
    }
}
