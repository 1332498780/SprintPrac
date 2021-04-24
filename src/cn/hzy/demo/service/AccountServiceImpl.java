package cn.hzy.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hzy.demo.dao.AccountDao;
import cn.hzy.demo.model.Account;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	@Transactional()
	public void transferBalance(String from, String to, float money) {
		//ls 给 zs 2块钱
		Account zsAccount = accountDao.findAccount(from);
		float zsBalance = zsAccount.getBalance() - money;
		accountDao.updateMoney(from, zsBalance);
		//模拟程序出问题
		int a = 10/0;

		Account lsAccount = accountDao.findAccount(to);
		float lsBalance = lsAccount.getBalance() + money;
		accountDao.updateMoney(to, lsBalance);
	}

}
