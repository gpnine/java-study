package com.project.controller;

import com.project.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * JAVAWeb-Advanced .
 *
 * @description: .
 * @author: ChengLin Zhu .
 * @date: 19-1-30 .
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);


	// /user/test?id=1
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("userId:" + userId);
		User user = null;
		if (userId == 1) {
			user = new User();
			user.setAge(11);
			user.setId(1);
			user.setPassword("123");
			user.setUserName("javen");
		}

		if (user != null) {
			log.debug(user.toString());
		}
		model.addAttribute("user", user);
		return "index";
	}
}
