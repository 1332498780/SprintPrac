package cn.hzy.demo.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.hzy.demo.model.Account;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(Account account) {
		String sql = "insert into account values(?,?,?,?)";
		Object[] premeters = new Object[] {
				1,
				"zs",
				"2020-10-01 12:00:00",
				6.7f
		};
		int count = jdbcTemplate.update(sql, premeters);
		System.out.println("≤Â»Î"+count+" ––");
	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account findAccount() {
		String sql = "select * from account where name = ?";
		Object[] premeters = new Object[] {
//				"zs or 1=1"
				"zs"
		};
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
		
		return jdbcTemplate.queryForObject(sql, premeters, rowMapper);
	}

	@Override
	public List<Account> findAccountList() {
		
		String sql = "select * from account";
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
		return jdbcTemplate.query(sql, rowMapper);
	}

}
