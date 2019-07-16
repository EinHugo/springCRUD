package com.sinc.project.aop.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("loginAspect")
@Aspect
public class LoginAspect {
	
	@Before("execution(public * com.sinc.project..*Impl.say*(..))")
	public void before(JoinPoint join) {
		System.out.println("aspect >>>>>>> before advice");
	}
	@AfterThrowing(pointcut="execution(public * com.sinc.project..*Impl.say*(..))", throwing="e" )
	public void throwing(JoinPoint point, Exception e) {
		System.out.println("Throwing!");
		e.printStackTrace();
	}
	
}
