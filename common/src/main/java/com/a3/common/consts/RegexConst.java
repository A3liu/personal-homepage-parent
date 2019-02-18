package com.a3.common.consts;

/**
 * @Author: liuyaosen
 * @Date: 2019/2/18 21:17
 */
public class RegexConst {
    //密码的以后再用   ^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$

    public static final String PASSWORD = "^[0-9a-zA-Z]{6,20}$";

    public static final String USER_NAME = "^[A-Za-z\\d]{6,20}$";
}
