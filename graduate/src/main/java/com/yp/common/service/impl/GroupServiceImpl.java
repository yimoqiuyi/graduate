package com.yp.common.service.impl;

import com.yp.common.mapper.GroupMapper;
import com.yp.common.pojo.Group;
import com.yp.common.service.GroupService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GroupServiceImpl implements GroupService {
@Autowired
private GroupMapper groupMapper;
    @Override
    public Group selectOneGroupById(int groupId) {
        return groupMapper.selectOneGroupById(groupId);
    }

    @Override
    public Group selectOneGroupByuserId(int userId) {
        return groupMapper.selectOneGroupByuserId(userId);
    }

    @Override
    public List<Group> selectAllGroupBysubParkId(int subParkId) {
        return groupMapper.selectAllGroupBysubParkId(subParkId);
    }
    @Override
    public List<Group> selectGroupByCondition(Map<String,Object> map){
        return groupMapper.selectGroupByCondition(map);
    }
    @Override
    public List<Group> selectAllGroup() {
        return groupMapper.selectAllGroup();
    }

    @Override
    public List<Group> selectAllGroupByState(int state) {
        return groupMapper.selectAllGroupByState(state);
    }

    @Override
    public List<Group> selectAllGroupBystateAndsubParkId(int state, int subParkId) {
        return groupMapper.selectAllGroupBystateAndsubParkId(state,subParkId);
    }

    @Override
    public boolean insertOneGroup(Group group) {
        return groupMapper.insertOneGroup(group);
    }

    @Override
    public boolean updateOneGroup(Group group) {
        return groupMapper.updateOneGroup(group);
    }

    @Override
    public int delectOneGroupByid(int groupId) {
        return groupMapper.delectOneGroupByid(groupId);
    }

    @Override
    public List<Group> selectGroupByLimit(int subParkId, int page, int limit) {
        return groupMapper.selectGroupByLimit(subParkId,page,limit);
    }
}
