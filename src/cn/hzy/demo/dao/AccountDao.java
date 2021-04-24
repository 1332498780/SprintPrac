package cn.hzy.demo.dao;

import java.util.List;

import cn.hzy.demo.model.Account;

public interface AccountDao {

	void insert(Account account);
	
	void update(Account account);
	
	void delete(int id);
	
	Account findAccount(String name);
	
	List<Account> findAccountList();
	
	void updateMoney(String name,float balance);
	
}
