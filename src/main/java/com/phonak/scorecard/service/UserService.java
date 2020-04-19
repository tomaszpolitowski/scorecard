package com.phonak.scorecard.service;

import com.phonak.scorecard.dao.UserDao;
import com.phonak.scorecard.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int insertUser(User user){return userDao.insertUser(user);}
}
