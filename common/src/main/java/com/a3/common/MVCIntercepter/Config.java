package com.a3.common.MVCIntercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: liuyaosen
 * @Date: 2018/12/25 23:01
 */
@Configuration
public class Config implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MVCIntercepter()).addPathPatterns("/**");
    }
}
