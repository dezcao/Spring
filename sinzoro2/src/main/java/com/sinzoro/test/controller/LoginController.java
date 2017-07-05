package com.sinzoro.test.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinzoro.test.dao.HomeDao;
import com.sinzoro.test.vo.HomeVO;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	HomeDao homeDao;
	
	/*
	 * 로그인 요청 : 로그인 되지 않은 모든 요청은 이곳으로 보내진다. security-context.xml 참조.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Locale locale,
			HomeVO vo,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			ModelAndView model) {
		
		logger.info("Welcome login.", locale);
		
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}

}
