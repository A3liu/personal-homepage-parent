package com.a3.common.exception;

import com.a3.common.pojo.ResultObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: liuyaosen
 * @Date: 2018/12/25 22:27
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultObject globalExceptionHandler(Exception e){
        logger.error("------------------------Exception------------------------");
        logger.error(e.getMessage());
        logger.error("------------------------Exception------------------------");
        printStackTrace(e);
        return ResultObject.error(e,"错误,请联系管理员");
    }

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public ResultObject serviceExceptionHandler(ServiceException e){
        logger.error("------------------------ServiceException------------------------");
        logger.error(e.getMessage());
        logger.error("------------------------ServiceException------------------------");
        printStackTrace(e);
        return ResultObject.error(e);
    }

    public void printStackTrace(Exception e){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }).start();
    }

}
