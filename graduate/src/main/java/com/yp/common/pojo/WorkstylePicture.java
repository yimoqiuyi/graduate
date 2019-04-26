package com.yp.common.pojo;

import java.io.Serializable;
import java.util.List;

public class WorkstylePicture implements Serializable {
    private int workStyleId;//工位样式主键
    private String workStyleName;//工位样式名称
    private String workStylePicture;//工位样式图片
    private List<WorkPosition> workPositionList;

    public List<WorkPosition> getWorkPositionList() {
        return workPositionList;
    }

    public void setWorkPositionList(List<WorkPosition> workPositionList) {
        this.workPositionList = workPositionList;
    }

    public int getWorkStyleId() {
        return workStyleId;
    }

    public void setWorkStyleId(int workStyleId) {
        this.workStyleId = workStyleId;
    }

    public String getWorkStyleName() {
        return workStyleName;
    }

    public void setWorkStyleName(String workStyleName) {
        this.workStyleName = workStyleName;
    }

    public String getWorkStylePicture() {
        return workStylePicture;
    }

    public void setWorkStylePicture(String workStylePicture) {
        this.workStylePicture = workStylePicture;
    }
}
