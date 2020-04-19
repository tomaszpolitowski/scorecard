package com.phonak.scorecard.dao;

import com.phonak.scorecard.model.User;

import java.util.List;

public interface UserDao {
    int insertUser(User user);
    List<User> selectAllUser();

}
