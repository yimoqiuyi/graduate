package com.yp.common.service;

import com.yp.common.pojo.Parkassets;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkassetsService {
    //根据id查看资产
    public Parkassets selectOneParkassetsByid(@Param("assetId") int assetId);

    //根据房间id查看资产
    public Parkassets selectOneParkassetsByroomId(@Param("roomId") int roomId);

    //查看所有资产表
    public List<Parkassets> selectAllParkassets();

    //录入资产
    public boolean insertOneParkassets(Parkassets parkassets);

    //修改资产
    public boolean updateOneParkassets(Parkassets parkassets);

    //根据id删除资产
    public int delectOneParkassetsByid(@Param("assetId") int assetId);

    //根据roomId删除资产表
    public int deleteParkassetsByRoomId(@Param("roomId") int roomId);
}
