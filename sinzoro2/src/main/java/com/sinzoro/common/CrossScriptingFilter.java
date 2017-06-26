package com.sinzoro.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CrossScriptingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	    chain.doFilter(new XSSRequestWrapper((HttpServletRequest) req), res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("XSS Filtering init");
	}


	@Override
	public void destroy() {
	    
	}

}
