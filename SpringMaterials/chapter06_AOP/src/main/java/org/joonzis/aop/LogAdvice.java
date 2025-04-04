package org.joonzis.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
@Aspect
public class LogAdvice {
	@Before("execution(* org.joonzis.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("====================");
	}
	
	@Before("execution(* org.joonzis.service.SampleService*.doAdd(String, String)) && args(str1,str2)")
	public void logBeforeWithParam(String str1, String str2) {
		log.info("str1 : "+str1);
		log.info("str2 : "+str2);
	}
	
	@AfterThrowing(pointcut = "execution(* org.joonzis.service.SampleService*.*(..))"
			,throwing="exception"
			)
	// 예외를 발생시키면 그 다음에 실행되는 메서드
	public void logException(Exception exception) {
		log.info("Exception..!");
		log.info("exception : "+exception);
	}
}
