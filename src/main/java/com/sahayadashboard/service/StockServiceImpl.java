package com.sahayadashboard.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahayadashboard.model.Product;
import com.sahayadashboard.model.Stock;
import com.sahayadashboard.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository sRepository;

    @Override
    public Stock createStock(Stock stock) {
        Stock s= sRepository.save(stock);
        System.out.println(s.getId());
        return s;
    }

    @Override
    public Optional<Stock> getStockByUuid(UUID uuid) {
        return sRepository.findById(uuid);
    }

    @Override  
    public List<Stock> getAllStock() {
        return sRepository.findAll();
    }
	
	@Override
	public String deleteByUuid(UUID uuid) {
		sRepository.deleteById(uuid);
		return "Deleted Sucessfully";
	}

	@Override
	public Stock updateByUuid(UUID uuid, Stock stock) {
		Optional<Stock>st=sRepository.findById(uuid);
		Stock s=st.get();
		s.setQuantity(stock.getQuantity());
		return sRepository.save(s);
	}
	
	@Override
	public Stock findByProduct(Product product) {
        return sRepository.findByProduct(product);
	}
		
		
		
}
	
	
	
		
	

