package com.sinzoro.test.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sinzoro.test.dao.HomeDao;

@Controller
public class GoogleLoginController {

	private static final Logger logger = LoggerFactory.getLogger(GoogleLoginController.class);

	@Autowired
	HomeDao homeDao;

	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;

	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;

	/* 구글code 발행 -> 구글 로그인 페이지로 이동하기. 
	 * OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
	 * String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
	 */
	@RequestMapping(value = "/login/googleSingIn", method = RequestMethod.GET)
	public String googleSingIn() {
	    String url = "redirect:" + googleConnectionFactory.getOAuthOperations().buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
	    logger.info("googleSingIn. url : {}", url);
	    return url;
	}
	
	// 구글 Callback호출 메소드 http://adunhansa.tistory.com/192, http://websystique.com/spring-security/spring-security-4-role-based-login-example/
	@RequestMapping(value = "/login/oauth2callback", method = RequestMethod.GET)
	public ModelAndView googleCallback2(ModelAndView model, @RequestParam String code, HttpServletRequest request, HttpServletResponse response,
	        RedirectAttributes redirectAttributes) throws IOException, ServletException {
	    logger.info("google callback. code : {}", code);
	    
	    OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
	    AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, googleOAuth2Parameters.getRedirectUri(), null);
	    String accessToken = accessGrant.getAccessToken();
	    
	    Long expireTime = accessGrant.getExpireTime();
	    if (expireTime != null && expireTime < System.currentTimeMillis()) {
	        accessToken = accessGrant.getRefreshToken();
	        logger.info("accessToken is expired. refresh token = {}", accessToken);
	    }
	    Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
	    Google google = (connection == null ? new GoogleTemplate(accessToken) : connection.getApi());
	    PlusOperations plusOperations = google.plusOperations();
	    Person person = plusOperations.getGoogleProfile();
	    
	    logger.info("person.getImageUrl() : {}", person.getImageUrl());
	    logger.info("person displayName: {}", person.getDisplayName());
	    
	    HttpSession session = request.getSession();
	    session.setAttribute("imageUrl", person.getImageUrl());
	    session.setAttribute("displayName", person.getDisplayName());
	    
	    RedirectView redirectView = new RedirectView(); // redirect url 설정
	    redirectView.setUrl("/home/home");
	    //redirectAttributes.addFlashAttribute("imageUrl", person.getImageUrl()); // redirectAttributes
	    //redirectAttributes.addFlashAttribute("displayName", person.getDisplayName());
	    redirectView.setExposeModelAttributes(false); // redirect 요청이지만 model에 추가한 변수값을 숨겨준다.
	    model.setView(redirectView); // 리다이렉트 url 깨끗하게 위에 설정한 값으로 변경한다.
	    return model;
	}

}
