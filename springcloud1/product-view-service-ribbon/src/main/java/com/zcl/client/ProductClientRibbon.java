package com.zcl.client;

import com.zcl.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * springcloud1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-9-11 .
 */
@Component
public class ProductClientRibbon {

	@Autowired
	RestTemplate restTemplate;

	public List<Product> listProdcuts() {
		return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/products", List.class);
	}
}
