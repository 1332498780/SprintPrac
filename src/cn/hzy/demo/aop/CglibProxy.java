package cn.hzy.demo.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglibProxy ����ָ���ӿڣ��ڲ�����target���������࣬�ڱ���ʱ������ת��
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
	 * proxyObj: ����
	 * Method: �����ִ�з���
	 * argument:����
	 * methodProxy: ͨ��������ִ�и���ķ���
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
