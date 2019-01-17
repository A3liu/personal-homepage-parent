package com.a3.user.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 用户登陆日志，登陆次数，用户权限注入，
 * @author Donald 2019-01-17 12:37 
 *
 */
@Component
@Aspect
public class UserLogAOP {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserLogAOP.class);
	
	//切入点
	@Pointcut("execution( * com.a3.*.* (..) )")
	public void pointCut() {};
	
	
	@Around("pointCut()")
	public Object aroundCut(ProceedingJoinPoint joinPoint) {
		
		//截取请求信息
		 ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		 HttpServletRequest request = requestAttributes.getRequest();
		//
		 String ip = request.getRemoteAddr();
		 
		Object result = null;
		LOGGER.info("目标方法执行前置通知{}" + ip );
		try {
			result = joinPoint.proceed();//控制目标方法的执行
			LOGGER.info("目标方法正常执行 正常返回");
			//TODO 用户登陆时间设置
			
		} catch (Throwable e) {
			LOGGER.error("目标方法执行异常了" , e);
			//TODO 用户登陆次数限制,redis 数据写入
		}
		
		LOGGER.info("目标方法执行了");
		return result ;
	}
	
	
}
