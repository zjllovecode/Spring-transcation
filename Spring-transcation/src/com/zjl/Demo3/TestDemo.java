package com.zjl.Demo3;

//spring声明式事务管理一基于TransactionProxyFactoryBean的方式(很少使用)
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class TestDemo{
	/**
	 * 注入代理类（spring框架给你写的）
	 *
	 */
	//@Resource(name="accountService")
	@Resource(name="accountServiceProxy")
	private AccountService accountService;
	
	@Test
	public void demo1(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}
