package com.a3.common.exception;

import com.a3.common.pojo.ResultObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Author: liuyaosen
 * @Date: 2018/12/25 22:27
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private ThreadPoolTaskExecutor pool;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultObject globalExceptionHandler(Exception e) {
        logger.error("------------------------Exception------------------------");
        logger.error(e.getMessage());
        logger.error("------------------------Exception------------------------");
        printStackTrace(e);
        return ResultObject.error(e, "错误,请联系管理员");
    }

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public ResultObject serviceExceptionHandler(ServiceException e) {
        logger.error("------------------------ServiceException------------------------");
        logger.error(e.getMessage());
        logger.error("------------------------ServiceException------------------------");
        printStackTrace(e);
        return ResultObject.error(e);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultObject methodArgumentNotValidHandler(MethodArgumentNotValidException e) {
        ResultObject error = ResultObject.error("param check failed");
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        List<Map<String, Object>> errors = new ArrayList<>();
        allErrors.forEach(t->errors.add(new HashMap<String, Object>(){{put("message",t.getDefaultMessage());put("error detail",t.getCodes());}}));
        error.setResult(errors);
        return error;
    }

    public void printStackTrace(Exception e) {
        pool.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e1) {
            }
            e.printStackTrace();
        });
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e1) {
//                    e1.printStackTrace();
//                }
//                e.printStackTrace();
//            }
//        });
    }

}
