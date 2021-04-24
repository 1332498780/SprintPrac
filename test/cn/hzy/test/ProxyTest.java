package cn.hzy.test;

import cn.hzy.demo.aop.CglibProxy;
import cn.hzy.demo.aop.JdkProxy;
import cn.hzy.demo.aop.face.AInterface;
import cn.hzy.demo.aop.face.InterfaceImpl;

public class ProxyTest {

	public static void main(String[] args) {
		
		cglibProxyTest();
		
	}
	
	static void jdkProxyTest() {
		JdkProxy<AInterface> face = new JdkProxy(new InterfaceImpl());
		AInterface warpObject = face.getInstance();
		
		warpObject.say(new String[] {"ab","cd"});
	}
	
	static void cglibProxyTest() {
		CglibProxy cglibProxy = new CglibProxy();
		InterfaceImpl face = (InterfaceImpl)cglibProxy.getInstance(new InterfaceImpl());
		face.say(new String[] {"ab","cd"});
	}

}
