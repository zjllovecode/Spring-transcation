package com.zjl.Demo2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//加载测试环境
@ContextConfiguration("classpath:applicationContext2.xml")//加载配置文件
public class TestDemo{
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void demo1(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}
