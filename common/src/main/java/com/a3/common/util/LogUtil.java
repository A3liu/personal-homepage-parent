package com.a3.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: liuyaosen
 * @Date: 2019/1/2 21:22
 */
public class LogUtil {
    public static Logger loggger = LoggerFactory.getLogger(LogUtil.class);

    public static void info(String msg) {
        loggger.info(msg);
    }

    public static void error(String msg) {
        loggger.error(msg);
    }

}
