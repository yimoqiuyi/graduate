package com.yp.user.util;

import com.yp.common.pojo.User;

public class UpdateUser {
    public User update(User user1, int id, String userName, String userPassword, String sex, String age, String phone,
                       String cardNumber, String email, String address) {
        User user = new User();
        user.setUserId(id);
        user.setUserName(userName);
        user.setUserPwd(userPassword);
        user.setJoinTime(user1.getJoinTime());
        user.setAwayTime(user1.getAwayTime());
        user.setSex(sex);
        user.setAge(age);
        user.setPhone(phone);
        user.setCardNumber(cardNumber);
        user.setEmail(email);
        user.setAddress(address);
        user.setSanitationScore(user1.getSanitationScore());
        user.setAttendanceScore(user1.getAttendanceScore());
        user.setWorkRatio(user1.getWorkRatio());
        user.setState(user1.getState());
        user.setWorkId(user1.getWorkId());
        user.setGroupId(user1.getGroupId());
        user.setSubParkId(user1.getSubParkId());
        user.setSalt(user1.getSalt());
        user.setWorkRatio(user1.getWorkRatio());
        return user;
    }
}
