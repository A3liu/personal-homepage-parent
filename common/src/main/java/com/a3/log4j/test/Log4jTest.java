package com.a3.log4j.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		LOGGER.info("什么玩意");
		tryMethoD("网", 9);
	}
	
	public static void tryMethoD(String name,int a) {
		LOGGER.error("报错了哟 我草");
	}

}
