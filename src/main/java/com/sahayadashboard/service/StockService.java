package com.sahayadashboard.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sahayadashboard.model.Product;
import com.sahayadashboard.model.Stock;

public interface StockService {
	    Stock createStock(Stock stock);
	    Optional<Stock> getStockByUuid(UUID uuid);
	    List<Stock> getAllStock();
	    String deleteByUuid(UUID uuid);
	    Stock updateByUuid(UUID uuid, Stock stock);
		Stock findByProduct(Product product);
	    
	}



