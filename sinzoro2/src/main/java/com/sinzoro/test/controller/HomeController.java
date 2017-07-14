package com.sinzoro.test.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sinzoro.test.dao.BoardDao;
import com.sinzoro.test.vo.BoardVO;

@Controller
@RequestMapping("/home/*")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
    BoardDao boardDao;
	
	@ModelAttribute
	public void activeParameterSetter (HttpServletRequest request) {
	    
	    logger.debug(request.getRequestURI());
	    
	    switch (request.getRequestURI()) {
            case "/home/home":
                request.setAttribute("active_li", "home_li");
                break;
            case "/home/board":
                request.setAttribute("active_li", "board_li");
                break;
            case "/home/contact":
                request.setAttribute("active_li", "contact_li");
                break;
        }
	}
	
	@RequestMapping(value = "home", method = {RequestMethod.GET, RequestMethod.POST})
	public String home() {
	    logger.info("Welcome Home.");
		return "/home/home";
	}
	
	@RequestMapping(value = "board", method = {RequestMethod.GET, RequestMethod.POST})
	public String board(HttpServletRequest request) {
	    logger.info("Here is board.");
	    List<BoardVO> boardList = boardDao.findAll();
	    request.setAttribute("boardList", boardList);
	    return "/home/board";
	}
	
	@RequestMapping(value = "contact", method = {RequestMethod.GET, RequestMethod.POST})
	public String contact() {
	    logger.info("Heare is contect.");
	    return "/home/contact";
	}
	
}
