package com.sahayadashboard.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahayadashboard.model.Product;
import com.sahayadashboard.model.Stock;

public interface StockRepository extends JpaRepository<Stock,UUID> {

	Stock findByProduct(Product product);

}
