package com.yp.common.service.impl;

import com.yp.common.mapper.PatentFileMapper;
import com.yp.common.pojo.PatentFile;
import com.yp.common.service.PatentFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatentFileServiceImpl implements PatentFileService {
    @Autowired
    private PatentFileMapper patentFileMapper;

    @Override
    public PatentFile selectOnePatentFileById(int id) {
        return patentFileMapper.selectOnePatentFileById(id);
    }

    @Override
    public boolean insertPatentFile(PatentFile patentFile) {
        return patentFileMapper.insertPatentFile(patentFile);
    }

    @Override
    public List<PatentFile> seletcAllPatentFileBypatent_id(int patentId) {
        return patentFileMapper.seletcAllPatentFileBypatent_id(patentId);
    }

    @Override
    public int deletePatentFileByPatentId(int patentId) {
        return patentFileMapper.deletePatentFileByPatentId(patentId);
    }
}
