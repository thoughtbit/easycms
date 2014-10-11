package com.easycms.service;

import java.util.List;

import com.easycms.model.Account;
/**
 * 
 * @author fuxin
 *
 */
public interface AccountService{

	public void createAccount(Account account);
	
	public int deleteStudent(int id);
	
	public Account findAccountById(int id);
	
	public List<Account> findAccountAll();
	
	public int findTotal();
}