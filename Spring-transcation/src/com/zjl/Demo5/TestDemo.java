package com.zjl.Demo5;

//spring声明式事务管理一基于基于注解的事务管理方式
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext5.xml")
public class TestDemo{
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void demo1(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}
