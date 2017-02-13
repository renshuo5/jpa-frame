package com.shop.jsonp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonpController {

	@RequestMapping(value="/jsonp/{callback}",method=RequestMethod.GET)
	@ResponseBody
	public String jsonp(@PathVariable("callback")String call, Model model){
		String jsStr = call+"('jsonDiv','这个是jsonp返回的消息')";
		return jsStr;
	}
}
