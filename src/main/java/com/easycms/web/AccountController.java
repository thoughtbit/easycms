package com.easycms.web;


import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easycms.model.Account;
import com.easycms.service.AccountService;

@Controller(value="accountController")
@RequestMapping("/account")
public class AccountController{
	
	private static Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountService accountService;
	
	//数据添加
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAccount(HttpServletRequest req){
		Account acc = new Account();
		acc.setUsername(req.getParameter("username"));
		acc.setPassword(req.getParameter("password"));
		accountService.createAccount(acc);
		logger.info("{}", acc);
		req.setAttribute("name", req.getParameter("username"));
		return "front/login";
	}
}
