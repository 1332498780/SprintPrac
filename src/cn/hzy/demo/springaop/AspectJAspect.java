package cn.hzy.demo.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AspectJAspect {

	
	public void before(JoinPoint joinPoint) {
		System.out.println("before");
//		System.out.println("target is:"+joinPoint.getTarget());
	}
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("res is:");
	}
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
//		before(joinPoint);
//		after(joinPoint);
		
		return joinPoint.proceed();
	}
	public void afterThrowing(JoinPoint joinPoint,Throwable e) {
		System.out.println("throwing");
//		System.out.println("target is:"+joinPoint.getTarget());
		e.printStackTrace();
	}
	public void after(JoinPoint joinPoint) {
		System.out.println("after");
//		System.out.println("target is:"+joinPoint.getTarget());
	}
}
