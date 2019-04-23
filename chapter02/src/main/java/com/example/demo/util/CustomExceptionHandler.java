package com.example.demo.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;


/**
 * chapter02 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView uploadException() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "上传文件大小超出限制");
		mv.setViewName("error");
		return mv;
	}
}
