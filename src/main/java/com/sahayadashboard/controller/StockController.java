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
import com.sahayadashboard.model.Stock;
import com.sahayadashboard.service.StockService;

@RestController
@RequestMapping("/stock")

public class StockController {
	@Autowired
	private StockService sService;
	
	@PostMapping
	public Stock createStock(@RequestBody Stock stock){
		return sService.createStock(stock);
		
	}
	
	@GetMapping("/{uuid}")
	public Optional<Stock>getStockByUuid(@PathVariable String uuid){
		return sService.getStockByUuid(UUID.fromString(uuid));
		
	}
	
	@GetMapping
	public List<Stock>getAllStock(){
		return sService.getAllStock();
		                                                                                                     
	}
	
	@DeleteMapping("/{uuid}")
	public String deleteByUuid(@PathVariable String uuid) {
		return sService.deleteByUuid(UUID.fromString(uuid));
		
	}
	
	@PutMapping
	public Stock updateByUuid(@PathVariable String Uuid,@RequestBody Stock stock) {
		return sService.updateByUuid(UUID.fromString(Uuid), stock);
		
	}
	
	@GetMapping("/product/{uuid}")
	public Stock findByUuid(@PathVariable Product product) {
		return sService.findByProduct(product);
	}
	
	
	

}
