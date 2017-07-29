package com.rollingstone;

import java.util.NoSuchElementException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CounterService counterService;

	@Before("execution(public * com.rollingstone.api.rest.*Controller.*(..))")
	public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
		logger.info(":::::AOP Before REST call:::::" + pjp);
	}

	//TODO Change the method name to your Create Method
	
	@AfterReturning("execution(public * com.rollingstone.api.rest.*Controller.createTODO*(..))")
	public void afterCallingCreateTODO(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning Create REST call:::::" + pjp);
		counterService.increment("com.rollingstone.api.rest.TODOController.createTODO");
	}

	//TODO Change the method name to your GetAll Method
	@AfterReturning("execution(public * com.rollingstone.api.rest.*Controller.getAllTODO*(..))")
	public void afterCallinggetAllTODO(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning getAllTODO REST call:::::" + pjp);

		counterService.increment("com.rollingstone.api.rest.TODOController.getAllTODO");
	}

	//TODO Change the method name to your Get Method
	@AfterReturning("execution(public * com.rollingstone.api.rest.*Controller.getTODO*(..))")
	public void afterCallinggetTODO(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning getTODO REST call:::::" + pjp);
		counterService.increment("com.rollingstone.api.rest.TODOController.getTODO");
	}

	//TODO Change the method name to your Update Method

	@AfterReturning("execution(public * com.rollingstone.api.rest.*Controller.updateTODO*(..))")
	public void afterCallingupdateTODO(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning update TODO REST call:::::" + pjp);
		counterService.increment("com.rollingstone.api.rest.TODOController.updateTODO");
	}

	//TODO Change the method name to your Application

	@AfterThrowing(pointcut = "execution(public * com.rollingstone.api.rest.*Controller.*(..))", throwing = "e")
	public void afterTODOThrowsException(NoSuchElementException e) {
		counterService.increment("counter.errors.TODO.controller");
	}
}
