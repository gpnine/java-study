package com.example.demo.config;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * chapter02 .
 *
 * @description: 自定义error视图.
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@Component
public class MyErrorViewResolver implements ErrorViewResolver {
	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
		ModelAndView mv = new ModelAndView("errorPage");
		mv.addObject("custommsg", "出错拉！");
		mv.addAllObjects(model);
		return mv;
	}
}
