package com.a3.user.controller;

import com.a3.common.pojo.ResultObject;
import com.a3.user.dao.UserDao;
import com.a3.user.entity.UserEntity;
import com.a3.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @RequestMapping("test")
    public String test(){
        return userDao.selectByPrimaryKey("1").toString();
    }

    @RequestMapping("/createUser")
    public ResultObject createUser(UserEntity userEntity){
        userService.createUser(userEntity);
        return ResultObject.build();
    }

}
