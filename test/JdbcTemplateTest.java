import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.hzy.demo.dao.AccountDao;
import cn.hzy.demo.model.Account;
import cn.hzy.demo.service.UserService;

public class JdbcTemplateTest {
	
//	@Test
	public void mainTest() {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application.xml");
		
//		JdbcTemplate template = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
		
//		template.execute("create table account(id int primary key,name varchar(32),createTime date)");
		AccountDao dao = (AccountDao)applicationContext.getBean("accountDao");
		dao.insert(new Account());
	}
	
	@Test
	public void queryTest() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application.xml");
		AccountDao dao = (AccountDao)applicationContext.getBean("accountDao");
//		List<Account> accounts = dao.findAccountList();
//		for(Account acc:accounts){
//			System.out.println(acc);
//		}
		Account account = dao.findAccount();
		System.out.println(account);
	}
		
}
