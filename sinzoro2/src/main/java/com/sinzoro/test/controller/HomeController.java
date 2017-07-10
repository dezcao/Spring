package com.sinzoro.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home/*")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "home", method = {RequestMethod.GET, RequestMethod.POST})
	//imageUrl displayName
	public String home() {
		return "/home/home";
	}
	
	@RequestMapping(value = "board", method = {RequestMethod.GET, RequestMethod.POST})
	public String board() {
	    return "/home/board";
	}
	
	@RequestMapping(value = "contact", method = {RequestMethod.GET, RequestMethod.POST})
	public String contact() {
	    return "/home/contact";
	}
	
}
