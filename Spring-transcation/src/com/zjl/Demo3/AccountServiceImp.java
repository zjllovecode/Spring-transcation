package com.zjl.Demo3;

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
