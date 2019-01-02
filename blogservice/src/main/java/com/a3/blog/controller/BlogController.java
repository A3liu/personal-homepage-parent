package com.a3.blog.controller;

import com.a3.blog.entity.BlogEntity;
import com.a3.blog.service.BlogService;
import com.a3.common.feignServices.UserFeignService;
import com.a3.common.pojo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    BlogService blogService;

    @RequestMapping("blogTest")
    public String blogTest (String id){
        System.out.println(id);
        String s = userFeignService.userTest(id);
        System.out.println(s);
        return s;
    }

    @PutMapping("createBlog")
    public ResultObject createBlog (@RequestBody BlogEntity blogEntity){
        return ResultObject.build(blogService.createBlog(blogEntity));
    }
}
