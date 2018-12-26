package com.a3.user.service;

import com.a3.user.dao.UserDao;
import com.a3.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;


    public void createUser(UserEntity user) {
        userDao.insert(user);
    }
}
