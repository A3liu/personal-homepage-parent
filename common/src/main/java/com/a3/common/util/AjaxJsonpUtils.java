package com.a3.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Donald
 *  2019-03-07 22:08
 */
public class AjaxJsonpUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(AjaxJsonpUtils.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * AJAX 跨域请求回调处理方法。
     * @param callback 回调函数名字
     * @param targetObj 返回对象
     * @return json 格式字符串
     */
    public static String getObjectJsonString( String callback, Object targetObj )
    {
        String objJsonString = null;
        try {
            objJsonString = objectMapper.writeValueAsString( targetObj );
        } catch (JsonProcessingException e) {
            LOGGER.info( "object translate to jsonString failed object is :{0}",targetObj,e );
        }
        return callback + "(" + objJsonString + ")";
    }
}
