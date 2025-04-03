package org.joonzis.aop;

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
}
