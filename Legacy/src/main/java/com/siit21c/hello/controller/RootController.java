package com.siit21c.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	
	/*
	 * String path = "/error";
	 * 
	 * @RequestMapping(value = "/404") public String error404() { return path +
	 * "/404";
	
	} 404 에러 잡을라고*/
	@RequestMapping("/")
	String index() {
		
		
		return "index";
		
	}
	
	@RequestMapping("/hello")
	String hello() {
		
		return "hello";
	}
}
