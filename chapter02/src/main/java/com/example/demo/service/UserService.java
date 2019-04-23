package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * chapter02 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@Service
public class UserService {
	public String getUserById(Integer id) {
		System.out.println("get...");
		return "user";
	}

	public void deleteUserById(Integer id) {
		System.out.println("delete...");
	}
}
