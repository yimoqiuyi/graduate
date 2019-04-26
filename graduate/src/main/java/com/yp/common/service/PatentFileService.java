package com.yp.common.service;

import com.yp.common.pojo.PatentFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatentFileService {
    //查看专利文件单个路径
    public PatentFile selectOnePatentFileById(@Param("id") int id);

    //录入专利文件路径
    public boolean insertPatentFile(PatentFile patentFile);

    //提出专利文件路径根据专利外键patent_id
    public List<PatentFile> seletcAllPatentFileBypatent_id(@Param("patentId") int patentId);

    public int deletePatentFileByPatentId(@Param("patentId") int patentId);
}
