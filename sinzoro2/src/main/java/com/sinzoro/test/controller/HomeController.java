package com.sinzoro.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sinzoro.test.dao.HomeDao;
import com.sinzoro.test.vo.HomeVO;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	HomeDao homeDao;
	
	/*
	 * 로그인 프로세스 성공 후, /jsp로 온다. security-context.xml -> default-target-url="/jsp" 참조.
	*/
	@RequestMapping(value = "/jsp", method = RequestMethod.GET)
	public String home(Locale locale,@RequestParam String code, Model model) {
		logger.info("Welcome home! The client code is {}.", code);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		List<HomeVO> list = homeDao.zoro();

		HomeVO vo = list.get(0);
		model.addAttribute("vo", vo);
		model.addAttribute("serverTime", formattedDate);
		
		return "/home/home"; // 로그인 성공한 경우, 최초 이동할 홈페이지. tiles.xml 참조
	}
	
}
