package com.example.demo.component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * chapter02 .
 *
 * @description: 自定义过滤器.
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@WebFilter("/*")
public class MyFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter>>>init");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter>>>doFilter");
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter>>>dostory");
	}
}
