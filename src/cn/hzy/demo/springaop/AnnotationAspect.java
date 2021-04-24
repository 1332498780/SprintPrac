package cn.hzy.demo.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationAspect {

	@Pointcut("execution(* cn.hzy.demo.service.*.*(..))")
	public void pointCut() {}
	
	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		System.out.println("before1");
	}
	
	@AfterReturning("pointCut()")
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("afterReturn");
	}
	
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("before2");
		return joinPoint.proceed();
	}
	
	@After("pointCut()")
	public void after(JoinPoint joinPoint) {
		System.out.println("after");
	} 
	
	@AfterThrowing(value="pointCut()",throwing="e")
	public void afterThrowing(JoinPoint joinPoint,Throwable e) {
		System.out.println("throwing");
	}
}
