package com.yp.common.utils;

import com.yp.common.pojo.Dateutile;

public class DateUtils {
    public Dateutile getDate(int id,String signDate,String expireDate){
        Dateutile dateutile=new Dateutile();
        dateutile.setId(id);
        dateutile.setSignDate(signDate);
        dateutile.setExpirationDate(expireDate);
        return dateutile;
    }
}
