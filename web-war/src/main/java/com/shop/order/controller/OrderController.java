package com.shop.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/")
public class OrderController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		
		return "";
	}

}
