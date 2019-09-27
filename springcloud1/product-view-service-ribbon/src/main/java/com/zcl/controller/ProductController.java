package com.zcl.controller;

import com.zcl.pojo.Product;
import com.zcl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("/products")
	public Object products(Model m) {
		List<Product> ps = productService.listProducts();
		m.addAttribute("ps", ps);
		return "products";
	}
}
