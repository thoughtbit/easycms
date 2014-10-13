package com.easycms.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easycms.service.AccountService;

@Controller
public class IndexController{
	
	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(HttpServletRequest req, ModelMap model) throws Exception {
		logger.info("进入首页");
		model.addAttribute("message", "Hello Index!");
		return "/front/index";
	}
	
	@RequestMapping(value = "/fornt/index", method = RequestMethod.GET)
	public String fornthome(HttpServletRequest req, ModelMap model) throws Exception {
		logger.info("进入前台首页");
		model.addAttribute("message", "Hello Index!");
		return "/front/index";
	}

	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public String adminhome(HttpServletRequest req, ModelMap model) throws Exception {
		logger.info("进入后台首页");
		model.addAttribute("message", "Hello Index!");
		return "/admin/index";
	}

}
