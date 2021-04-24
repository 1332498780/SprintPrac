package cn.hzy.demo.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import cn.hzy.demo.dao.GroupDao;
import cn.hzy.demo.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService,BeanNameAware,BeanFactoryAware,InitializingBean{

	private UserDao userDao;
	private GroupDao groupDao;
	private String beanName;
	
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
//	public UserServiceImpl(UserDao userDao,GroupDao groupDao) {
//		this.userDao = userDao;
//		this.groupDao = groupDao;
//	}
	
	@Override
	public void sayHello() {
//		System.out.println("hello world");
		userDao.doSomething();
//		groupDao.doSomething();
//		System.out.println("My name is "+beanName);
		
//		System.out.println( 10 / 0 );
	}
	
	@Override
	public void setBeanName(String arg0) {
		this.beanName = arg0;
	}
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println(arg0);
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("properties set init succeed");
	}
	
	/**
	 * spring通过setter方法注入依赖
	 * @param userDao
	 */
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
}
