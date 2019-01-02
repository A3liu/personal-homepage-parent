package com.a3.common.MVCIntercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: liuyaosen
 * @Date: 2018/12/25 22:50
 */
public class MVCIntercepter implements HandlerInterceptor {

    private static final Logger logger= LoggerFactory.getLogger(MVCIntercepter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("========================request start with URI:"+request.getRequestURI()+"=======================");
        request.setAttribute("time",System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        logger.info("========================request end with time:"+request.getRequestURI()+"("+(System.currentTimeMillis()-(long)request.getAttribute("time"))+"ms)=======================");
    }
}
