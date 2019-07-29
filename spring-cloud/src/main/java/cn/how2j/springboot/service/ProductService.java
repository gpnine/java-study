package cn.how2j.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.how2j.springboot.pojo.Product;

@Service
public class ProductService {
	public List<Product> listProducts(){
    	List<Product> ps = new ArrayList<>();
    	ps.add(new Product(1,"product a", 50));
    	ps.add(new Product(2,"product b", 100));
    	ps.add(new Product(3,"product c", 150));
    	return ps;
	}
}
