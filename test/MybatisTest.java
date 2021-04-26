import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.hzy.demo.model.Account;
import cn.hzy.demo.model.Customer;
import cn.hzy.demo.model.Person;

public class MybatisTest {

	@Test
	public void findCustomerTest() {
		
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		
		Customer customer = sqlSession.selectOne("cn.hzy.demo.mapper.CustomerMapper.findCustomerById", 1);
		System.out.println(customer);
	}
	
	@Test
	public void findPersonTest() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		
		Person person = sqlSession.selectOne("cn.hzy.demo.mapper.PersonMapper.findPersonById", 1);
		System.out.println(person.getName());
//		System.out.println(person.getIdCard());
		System.out.println(person.getItems());
		
		
	}
}
