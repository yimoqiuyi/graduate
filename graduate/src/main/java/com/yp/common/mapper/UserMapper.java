package com.yp.common.mapper;

import com.yp.common.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//用户操作
public interface UserMapper {

    //根据用户名查看用户
    public User selectOneUserByName(@Param("userName") String userName);

    //通过用户主键查看用户
    public User selectOneUserById(@Param("userId") int userId);

    //根据工位外键查询用户
    public User seletcOneUserByworkId(@Param("workId") int workId);

    //查看所有的用户
    public List<User> selectAllUser(@Param("page") int page, @Param("limit") int limit);

    //分页查询用户
    public List<User> selectUserBygrouIdAndPage(@Param(value = "groupId") int groupId, @Param("page") int page, @Param("limit") int limit);

    //根据团队外键查询用户
    public List<User> selectGroupBygroupId(int groupId);   //查找团队负责人

    //根据团队外键查看用户
    public List<User> selectAllUserBygroupId(int groupId);

    //用过状态获取用户
    public List<User> selectAllUserBystate(@Param("state") int state);

    //通过groupId与用户状态获取用户
    public List<User> selectAllUserBystateAndgroupId(@Param("state") int state, @Param(value = "groupId") int groupId);

    //通过subParkId查询用户
    public List<User> selectAllUserBySubParkId(int subParkId);

    //获取所有的团员
    public List<User> selectAllUsers();

    //模糊查询用户
    public List<User> selectUserByCondition(@Param("map") Map<String, Object> map);

    //录入用户
    public int insertOneUser(User user);

    //修改用户
    public int updateOneUser(User user);

    //删除用户
    public int deleteOneUserById(@Param("userId") int userId);

    //查找用户
    public List<User> selectUserByAttendanceId(@Param("attendanceId") int attendanceId);

    //通过角色Id查找用户
    public List<User> selectUserByroleId(@Param("roleId") int roleId);

    //通过卫生sId查看用户
    public List<User> selectUserBysId(@Param("sId") int sId);

    //通过总园区id查看负责人
    public List<User> selectUserbygeneralParkId(@Param("generalParkId") int generalParkId);

}
