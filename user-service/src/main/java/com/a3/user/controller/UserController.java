package com.a3.user.controller;

import com.a3.common.pojo.ResultObject;
import com.a3.user.dao.UserDao;
import com.a3.user.entity.UserEntity;
import com.a3.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @GetMapping("test")
    public String test(){
        return userDao.selectByPrimaryKey("1").toString();
    }

    @RequestMapping("/userTest")
    public String userTest(String id){
        System.out.println(id);
        return "userService"+id;
    }

    @PutMapping("/createUser")
    public ResultObject createUser(@Valid @RequestBody UserEntity userEntity){
        return ResultObject.build(userService.createUser(userEntity));
    }

}
