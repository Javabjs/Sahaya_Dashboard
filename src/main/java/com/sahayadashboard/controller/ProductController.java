package com.sahayadashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahayadashboard.model.Product;
import com.sahayadashboard.service.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return pService.createProduct(product);
		
	}
	
	

}
