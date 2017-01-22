package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rensframework.core.entity.user.User;

@ControllerAdvice	
public class CommonController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static final String ATTR_LOGIN_USER = "loginUser";
	
	@ModelAttribute(ATTR_LOGIN_USER)
	public User loginUser(Model model){
		logger.info("common");
		if (false) {
			User user = new User();
			user.setAccount("renshuo");
			user.setCellphone("15101640992");
			user.setEmail("825558984@qq.com");
			user.setName("任硕");
			return user;
		} else {
			return null;
		}
	}
}
