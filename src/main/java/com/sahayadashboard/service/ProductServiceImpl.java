package com.sahayadashboard.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahayadashboard.model.Product;
import com.sahayadashboard.repository.ProductRepository;

@Service

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository pRepository;
	
	@Override
	public Product createProduct(Product product) {
		return pRepository.save(product);
	}

	@Override
	public Optional<Product> getProductByUuid(UUID uuid) {
		return pRepository.findById(uuid);
	}

	@Override
	public List<Product> getAllProduct() {
		return pRepository.findAll();
	}

	@Override
	public String deleteByUuid(UUID uuid) {
		 pRepository.deleteById(uuid);
		 return "Deleted Successfully";
	}

	@Override
	public Product updateByUuid(UUID uuid, Product product) {
		Optional<Product>prd=pRepository.findById(uuid);
		Product pr=prd.get();
		pr.setName(product.getName());
		pr.setBrand(product.getBrand());
		pr.setType(product.getType());
		pr.setQuantity(product.getQuantity());
		pr.setAlcohol_percentage(product.getAlcohol_percentage());
		pr.setManufacture_date(product.getManufacture_date());
		pr.setExpiry_date(product.getExpiry_date());
		return pRepository.save(pr);
	}
	

}
