package com.shop.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rensframework.core.entity.user.User;
import com.shop.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("entity")
	public User prepare(@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest req) {
		RequestMethod method = RequestMethod.valueOf(req.getMethod().toUpperCase());
		if ((id != null) && (id.longValue() > 0L)
				&& (RequestMethod.PUT.equals(method))) {
			 User user = (User) this.userService.getForUpdate(id.longValue());
			return user;
		}
		if (RequestMethod.POST.equals(method)) {
			return new User();
		}
		return null;
	} 
	

	@RequestMapping(method=RequestMethod.GET)
	public String index(User user,Model model){
		
		return "user/list";
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public String form(@ModelAttribute("entity") User user,Model model){
		System.out.println(user.getName()+user.getAccount());
		return "user/form";
	}
	
}
