package cn.hzy.demo.springaop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MySpringAop implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("start");
		Object res = methodInvocation.proceed();
		System.out.println("end");
		return res;
	}

	

}
