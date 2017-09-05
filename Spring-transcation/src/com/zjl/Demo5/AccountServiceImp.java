package com.zjl.Demo5;

import org.springframework.transaction.annotation.Transactional;

/**
* propagation	：事务的传播行为。
* isolation	：事务的隔离级别，比如，Isolation.DEFAULT:数据库默认级别。
* readonly	：只读（不可进行修改、插入、删除操作，否则报错）。
* rollback-for ：发生哪些异常回滚事务。
* no-rollback-for ：发生哪些异常事务不回滚，继续提交。
* timeout	：过期信息。
*/
//@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
@Transactional
public class AccountServiceImp implements AccountService {

	public AccountDaoImp getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDaoImp accountDao) {
		this.accountDao = accountDao;
	}

	private AccountDaoImp accountDao;

	@Override
	public void transfer(String out, String in, Double money) {
		accountDao.outMoney(out, money);
		//没有事务控制的话发生异常的情况下就会出现前减少了对方没有收到
		 int i=1/0;
		accountDao.inMoney(in, money);
	}

}
