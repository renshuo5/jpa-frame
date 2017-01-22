package com.shop.user.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String index(Model model){
		Iterable<User> iter = userService.findAll();
		List<User> list = new ArrayList<User>();
		Iterator<User> it = iter.iterator();
		while(it.hasNext()){
			list.add(it.next());
		}
		model.addAttribute("list", list);
		
		String renshuo = userService.getInfo();
		System.out.println(renshuo);
		
	public String index(User user,Model model){
		System.out.println("list");
		return "user/list";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(@RequestParam(value = "id", required = false) User user,Model model){
		if(user==null){
			user = new User();
		}
		model.addAttribute("entity", user);
		return "user/form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(User user,Model model){
		
		user.setEncryptPassword("123");
		user.setLevel(8);
		user.setRemoved(false);
		userService.saveWithAudit(user);
		return "redirect:./user";
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.PUT)
	public String update(@PathVariable("id") Long id,@ModelAttribute("entity") User user,Model model){
		System.out.println(user.getName()+user.getAccount());
		
		userService.saveWithAudit(user);
		return "redirect:/user";
	}
	
}
