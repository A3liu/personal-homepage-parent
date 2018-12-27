package com.a3.blog.controller;

import com.a3.common.feignServices.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liuyaosen
 * @Date: 2018/12/27 12:43
 */
@RestController
public class BlogController {
    @Autowired
    UserFeignService userFeignService;

    @RequestMapping("blogTest")
    public String blogTest (String id){
        System.out.println(id);
        String s = userFeignService.userTest(id);
        System.out.println(s);
        return s;
    }
}
