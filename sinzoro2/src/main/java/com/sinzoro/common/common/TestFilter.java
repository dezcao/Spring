package com.sinzoro.common.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestFilter implements Filter {
    
    private static final Logger logger = LoggerFactory.getLogger(TestFilter.class);
    
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest request = (HttpServletRequest)req;
	    logger.debug("RequestURL : {} ", request.getRequestURL());
	    chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	    String testParam = config.getInitParameter("testParam");
	    logger.debug("testParam : {} ", testParam);
	}

	@Override
	public void destroy() {
	}

}
