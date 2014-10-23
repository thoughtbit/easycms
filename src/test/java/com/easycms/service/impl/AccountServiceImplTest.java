package com.easycms.service.impl;

import static org.junit.Assert.*;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.easycms.model.Account;
import com.easycms.service.AccountService;

@Transactional
@TransactionConfiguration(defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class AccountServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests{
 
  	private static Logger logger = LoggerFactory.getLogger(AccountServiceImplTest.class);

	@Autowired
	private AccountService accountService;
	
	@Test
	public void testFindAllStudents() {
		List<Account> accounts = accountService.findAccountAll();
		assertNotNull(accounts);
		for (Account account : accounts){
			System.err.println(account);
		}
	}

	@Test
	public void testFindStudentById() {
		Account account = accountService.findAccountById(1);
		System.err.println(account);
		System.err.println(account.getUsername()+":"+account.getUsername());
	}

	
	@Test
	public void testCreateStudent() {
		Account account = new Account();
		account.setUsername("moocss@126.com");
		account.setPassword("123456");
		System.err.println("CreatedStudent: "+account);
	}

	@Test
	public void testDeleteStudent() {
		int deleted = accountService.deleteAccount(3);
		System.err.println("deleteStudent:"+deleted);
	}

}
