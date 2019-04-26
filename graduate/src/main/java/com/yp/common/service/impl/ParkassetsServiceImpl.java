package com.yp.common.service.impl;

import com.yp.common.mapper.ParkassetsMapper;
import com.yp.common.pojo.Parkassets;
import com.yp.common.service.ParkassetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParkassetsServiceImpl implements ParkassetsService {
    @Autowired
    private ParkassetsMapper parkassetsMapper;

    @Override
    public Parkassets selectOneParkassetsByid(int assetId) {
        return parkassetsMapper.selectOneParkassetsByid(assetId);
    }

    @Override
    public Parkassets selectOneParkassetsByroomId(int roomId) {
        return parkassetsMapper.selectOneParkassetsByroomId(roomId);
    }

    @Override
    public List<Parkassets> selectAllParkassets() {
        return parkassetsMapper.selectAllParkassets();
    }

    @Override
    public boolean insertOneParkassets(Parkassets parkassets) {
        return parkassetsMapper.insertOneParkassets(parkassets);
    }

    @Override
    public boolean updateOneParkassets(Parkassets parkassets) {
        return parkassetsMapper.updateOneParkassets(parkassets);
    }

    @Override
    public int delectOneParkassetsByid(int assetId) {
        return parkassetsMapper.delectOneParkassetsByid(assetId);
    }

    @Override
    public int deleteParkassetsByRoomId(int roomId) {
        return parkassetsMapper.deleteParkassetsByRoomId(roomId);
    }
}
