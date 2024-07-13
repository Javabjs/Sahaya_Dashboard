package com.sahayadashboard.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sahayadashboard.model.Product;

public interface ProductService {
	Product createProduct(Product product);
	Optional<Product> getProductByUuid(UUID uuid);
	List<Product> getAllProduct();
	String deleteByUuid(UUID uuid);
	Product updateByUuid(UUID uuid,Product product);

}
