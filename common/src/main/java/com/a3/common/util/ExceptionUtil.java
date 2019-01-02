package com.a3.common.util;

import com.a3.common.exception.ServiceException;

/**
 * @Author: liuyaosen
 * @Date: 2019/1/2 21:21
 */
public class ExceptionUtil {

    public static final String INVALIdPARAM="invalid param! pls check ur in input!";

    public static void invalidParam(){
        error(INVALIdPARAM);
    }

    public static void error(String msg){
        LogUtil.error(msg);
        throw new ServiceException(msg);
    }
}
