package com.yp.common.pojo;

import java.io.Serializable;

public class PatentFile implements Serializable {
    private int id;
    private String pfName;   //专利文件名字
    private String pfPath; //专利文件路径
    private int patentId;//专利外键

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPfName() {
        return pfName;
    }

    public void setPfName(String pfName) {
        this.pfName = pfName;
    }

    public String getPfPath() {
        return pfPath;
    }

    public void setPfPath(String pfPath) {
        this.pfPath = pfPath;
    }

    public int getPatentId() {
        return patentId;
    }

    public void setPatentId(int patentId) {
        this.patentId = patentId;
    }
}
