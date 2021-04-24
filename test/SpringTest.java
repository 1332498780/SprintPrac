import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hzy.demo.service.UserService;

public class SpringTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application.xml");
		UserService  userService = (UserService)applicationContext.getBean("userService");
		userService.sayHello();
		
		
	}
}
