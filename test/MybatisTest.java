import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.hzy.demo.model.Customer;

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
	public void findByNameTest() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		Customer cus = new Customer();
		cus.setName("s");
		cus.setJobs("teacher");
		List<Customer> customers = sqlSession
				.selectList("cn.hzy.demo.mapper.CustomerMapper.findCustomerByName", cus);
		System.out.println(customers);
	}
}
