package com.easycms.mappers;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.easycms.model.Account;

/**
 * 
 * @author fuxin
 *
 */

@Repository
public interface AccountMapper{
	@Delete("delete from Account where id=#{id}")
	int deleteAccount(int id);
	
	@Insert("insert into Account(username,password) values(#{username},#{password})")
	void createAccount(Account account);
	
	@Select("select * from Account where id=#{id}")
	Account findAccountById(int id);
	
	@Select("select * from Account")
	List<Account> findAccountAll();
	
	@Select("select count(*) from Account")
	int findAccountTotal();
}