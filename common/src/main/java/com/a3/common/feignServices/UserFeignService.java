package com.a3.common.feignServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: liuyaosen
 * @Date: 2018/12/27 12:36
 */
@FeignClient("user-service")
public interface UserFeignService {

    @RequestMapping(value = "/userTest",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public String userTest(@RequestParam("id") String id);
}

