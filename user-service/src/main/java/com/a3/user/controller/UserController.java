package com.a3.user.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a3.common.exception.ServiceException;
import com.a3.common.pojo.ResultObject;
import com.a3.user.dao.UserDao;
import com.a3.user.entity.UserEntity;
import com.a3.user.service.UserService;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @GetMapping("test")
    public String test() {
        return userDao.selectByPrimaryKey("1").toString();
    }

    @RequestMapping("/userTest")
    public String userTest(String id) {
        System.out.println(id);
        return "userService" + id;
    }

    @PutMapping("/createUser")
    public ResultObject createUser(@Valid @RequestBody UserEntity userEntity) {
        return ResultObject.build(userService.createUser(userEntity));
    }






    /*----------------------------------------------------楚河汉界-----------------------------------------------------*/





    @RequestMapping("/login")
    public Object login(UserEntity user, HttpSession session) {

        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            // 将用户名、密码封装为token
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
            // 设置为rememberme
            token.setRememberMe(true);
            try {
                subject.login(token);// 执行登陆操作
                // TODO 成功后执行
                session.setAttribute("loginuser", "user");
                return "index";
            } catch (UnknownAccountException e) {
                throw new ServiceException("账户不存在");
            } catch (IncorrectCredentialsException e) {
                throw new ServiceException("密码不正确");
            }
        }
        return "login";
    }

    @RequestMapping("/regist")
    public Object register(UserEntity user) {
        Object result = new SimpleHash("MD5", user.getPassword(), ByteSource.Util.bytes("boke"), 1024);
        // 密码加密入库
        // TODO

        return null;
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }
}
