package com.sinzoro.test.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinzoro.test.dao.HomeDao;
import com.sinzoro.test.vo.HomeVO;

@Controller
public class SingUpController {

	private static final Logger logger = LoggerFactory.getLogger(SingUpController.class);

	@Autowired
	HomeDao homeDao;
	
	/*
	 * 
	*/
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signForm(Locale locale, Model model) {
		logger.info("Thanks! Join us. {}", locale);
		
		return "/home/signUp";
	}
	
	@RequestMapping(value = "/signUpInsert", method = RequestMethod.POST)
	public String insert(HomeVO vo) {		
		logger.info("go go insert! {}", vo.getName());
		homeDao.insertUser(vo);
		homeDao.insertAuthority(vo);
		// insert 성공 여부에 따라서 로직이 들어갈 자리.
		return "redirect:/login";
	}
	
}
