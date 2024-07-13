package com.sahayadashboard.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
	@GetMapping("/{uuid}")
	public Optional<Product> getProductByUuid(@PathVariable String uuid){
	  return pService.getProductByUuid(UUID.fromString(uuid));
	
		
	}
	
	@GetMapping
	public List<Product> getAllProduct(){
		return pService.getAllProduct();
		
	}
	
	@DeleteMapping("/{uuid}")
	public String deleteByUuid(@PathVariable String uuid) {
		return pService.deleteByUuid(UUID.fromString(uuid));
		
	}
	
	@PutMapping("/{uuid}")
	public Product updateByUuid(@PathVariable String uuid,@RequestBody Product product) {
		return pService.updateByUuid(UUID.fromString(uuid),product);
		
	}
	
	
	

}
