package com.a3.user.service;

import com.a3.common.util.ExceptionUtil;
import com.a3.user.Builder.BuilderFactory;
import com.a3.user.Builder.UserBuilder;
import com.a3.user.dao.UserDao;
import com.a3.user.entity.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    BuilderFactory builderFactory;

    public String createUser(UserEntity user) {
        user = builderFactory.createNewUser(user);
        userDao.insert(user);
        return user.getId();
    }
}
