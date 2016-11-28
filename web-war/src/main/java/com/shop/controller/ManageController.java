package com.shop.controller;
		

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rensframework.core.entity.user.User;


@Controller
public class ManageController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping({"/"})
	public String login(Model model){
		logger.info("ManageController终于有日志啦");
		model.addAttribute("user", 
				(User) model.asMap().get(CommonController.ATTR_LOGIN_USER));
		return "manage/index";
	}
}
