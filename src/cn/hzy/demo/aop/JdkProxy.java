package cn.hzy.demo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

public class JdkProxy<T> implements InvocationHandler{

	private T target;
	
	public JdkProxy(T face) {
		this.target = face;
	}
	
	public T getInstance() {
		
		Class[] classes = target.getClass().getInterfaces();
//		for(Class c:classes) {
//			System.out.println(c);
//		}
		
//		Type[] types = target.getClass().getGenericInterfaces();
//		for(Type t:types) {
//			System.out.println("type:"+);
//		}
		return (T) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(),classes, this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始前的一些准备...");
		Object res = method.invoke(target, args);
		System.out.println("结束后的一些清理...");
		return res;
	}

	
}
