package cn.hzy.demo.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglibProxy 无需指定接口，内部根据target生成其子类，在编译时期做的转换
 * @author ZCG04000034
 *
 */
public class CglibProxy implements MethodInterceptor{

	public Object getInstance(Object target) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	/***
	 * proxyObj: 子类
	 * Method: 子类的执行方法
	 * argument:参数
	 * methodProxy: 通过它可以执行父类的方法
	 */
	@Override
	public Object intercept(Object proxyObj, Method method, Object[] arguments, MethodProxy methodProxy) throws Throwable {
		
		System.out.println("start..");
		System.out.println(method.getName());
		Object obj = methodProxy.invokeSuper(proxyObj, arguments);
		System.out.println("end..");
		return obj;
	}

	
}
