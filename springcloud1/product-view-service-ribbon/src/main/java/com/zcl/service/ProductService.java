package com.zcl.service;


import com.zcl.client.ProductClientRibbon;
import com.zcl.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {
	@Value("${server.port}")
	String port;

	@Autowired
	ProductClientRibbon productClientRibbon;
	public List<Product> listProducts(){
		return productClientRibbon.listProdcuts();
	}
}
