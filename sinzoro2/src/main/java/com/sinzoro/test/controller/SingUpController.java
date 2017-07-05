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

@Controller
public class SingUpController {

	private static final Logger logger = LoggerFactory.getLogger(SingUpController.class);

	@Autowired
	HomeDao homeDao;
	
	/*
	 * �α��� ���μ��� ���� ��, /jsp�� �´�. security-context.xml -> default-target-url="/jsp" ����.
	*/
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Thanks! Join us. {}", locale);
		
		return "/home/signUp"; // �α��� ������ ���, ���� �̵��� Ȩ������. tiles.xml ����
	}
	
}
