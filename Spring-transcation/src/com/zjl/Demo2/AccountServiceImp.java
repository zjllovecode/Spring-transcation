package com.zjl.Demo2;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImp implements AccountService {
	private AccountDaoImp accountDao;

	public void setAccountDao(AccountDaoImp accountDao) {
		this.accountDao = accountDao;
	}
	
	
	
	// 注入事务管理的模板并提供set方法
	private TransactionTemplate transactionTemplate;
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public void transfer(String out, String in, Double money) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus ) {
				accountDao.outMoney(out, money);
				//int i=1/0;
				accountDao.inMoney(in, money);
			}
		});
	}

}
