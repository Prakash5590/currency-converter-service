package com.salt.pepper.currencycoverterservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CurrencyConverterAspect {
	
	Logger LOGG = LoggerFactory.logger(CurrencyConverterAspect.class);
	
	@Pointcut("execution (* com.salt.pepper.currencycoverterservice.*.*.*(..))")
	public void allMethodPointCut() {
		
	}
	
	@Before("allMethodPointCut()")
	public void logBefore(JoinPoint joinpoint) {
		System.out.println("==============================Before Method=======================");
		LOGG.info("Before method :: {}",joinpoint.getArgs());
		
	}
	
	@After("execution (* com.salt.pepper.currencycoverterservice.*.*.*(..))")
	public void logAfter(JoinPoint joinPoint){
		LOGG.info("After method :: {}");
	}
	
	
	@Around("allMethodPointCut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("==============================Around Method starting=======================");
		LOGG.info("Around method :: {}");
		Object res = jp.proceed();
		System.out.println("==============================Around Method done!!=======================");
		return res;
	}
	
	@AfterThrowing(throwing = "ex",value = "execution (* com.salt.pepper.currencycoverterservice.repository.*.*(..))")
	public void logException(JoinPoint joinPoint, Exception ex) {
		LOGG.error("Exceptino while calling method error MSg is :: "+ex.getMessage());
	}
		
}
