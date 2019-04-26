package com.yp.common.pojo;

import java.io.Serializable;
import java.util.List;

public class Echart implements Serializable {
    private List<String> categories; //类型
    private List<Integer> data;   // 数据

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
