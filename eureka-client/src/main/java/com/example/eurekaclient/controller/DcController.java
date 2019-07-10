package com.example.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * eureka-server .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-9 .
 */
@RestController
public class DcController {

	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping("/dc")
	public String dc() {
		String services = "Services:" + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
}
