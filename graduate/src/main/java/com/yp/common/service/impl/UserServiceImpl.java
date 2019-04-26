package com.yp.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.yp.common.mapper.UserMapper;
import com.yp.common.pojo.User;
import com.yp.common.service.PasswordHelper;
import com.yp.common.service.UserService;
import com.yp.common.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    private PasswordHelper passwordHelper;

    public void setPasswordHelper(PasswordHelper passwordHelper) {
        this.passwordHelper = passwordHelper;
    }

    @Override
    @Cacheable(value = "redisCacheManager", key = "'redis_user_'+#userId")
    public User selectOneUserByName(String userName) {
        return userMapper.selectOneUserByName(userName);
    }

    @Override
    public User selectOneUserById(int userId) {
        return userMapper.selectOneUserById(userId);
    }

    @Override
    public User seletcOneUserByworkId(int workId) {
        return userMapper.seletcOneUserByworkId(workId);
    }

    @Override
    public List<User> selectGroupBygroupId(int groupId) {
        return userMapper.selectGroupBygroupId(groupId);
    }

    @Override
    public List selectUserBygrouIdAndPage(int groupId, int page, int limit) {
        List<User> list = userMapper.selectUserBygrouIdAndPage(groupId, page, limit);
        ResultUtil resultUtil = new ResultUtil();
         return list;
    }

    @Override
    public List<User> selectAllUserBystate(int state) {
        return userMapper.selectAllUserBystate(state);
    }

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    //查看所有的用户
    public List<User> selectAllUser(int page, int limit){
        return userMapper.selectAllUser(page,limit);
    }

    @Override
    public List<User> selectAllUserBystateAndgroupId(int state, int groupId) {
        return userMapper.selectAllUserBystateAndgroupId(state, groupId);
    }

    @Override
    public List<User> selectAllUserBySubParkId(int subParkId) {
        return userMapper.selectAllUserBySubParkId(subParkId);
    }

    @Override
    public List<User> selectAllUserBygroupId(int groupId) {
        return userMapper.selectAllUserBygroupId(groupId);
    }

    @Override
    public List<User> selectUserByCondition(Map<String, Object> map) {
        return userMapper.selectUserByCondition(map);
    }

    @Override
    public int insertOneUser(User user) {
        passwordHelper.encryptPassword(user);
        return userMapper.insertOneUser(user);
    }

    @Override
    public int updateOneUser(User user) {
//        User user1=userMapper.selectOneUserById(id);
//         user1.setUserPassword(password);
        passwordHelper.encryptPassword(user);
        return userMapper.updateOneUser(user);
    }


    @Override
    public int deleteOneUserById(int userId) {
        return userMapper.deleteOneUserById(userId);
    }

    @Override
    public List<User> selectUserByAttendanceId(int attendanceId) {
        return userMapper.selectUserByAttendanceId(attendanceId);
    }

    @Override
    public List<User> selectUserByroleId(int roleId) {
        return userMapper.selectUserByroleId(roleId);
    }

    @Override
    public List<User> selectUserBysId(int sId) {
        return userMapper.selectUserBysId(sId);
    }

    @Override
    public List<User> selectUserbygeneralParkId(int generalParkId) {
        return userMapper.selectUserbygeneralParkId(generalParkId);
    }


}
