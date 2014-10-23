package com.easycms.service;

import java.util.List;

import com.easycms.model.Account;
/**
 * 
 * @author fuxin
 *
 */
public interface AccountService{

	void createAccount(Account account);
	
	int deleteAccount(int id);
	
	Account updateAccount(Account account);
	
	Account findAccountById(int id);
	
	List<Account> findAccountAll();
	
	int findTotal();
}