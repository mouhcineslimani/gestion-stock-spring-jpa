package org.mql.stock.business;

import java.util.List;
import java.util.Optional;

import org.mql.stock.entities.Product;
import org.mql.stock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceDefault implements StockService {
	@Autowired
	private ProductRepository productRepository;

	public StockServiceDefault() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product product(int id) {
		Optional<Product> p = productRepository.findById(id);
		return p.isPresent() ? p.get() : null;
	}

	@Override
	public List<Product> products() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> products(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> getProductsByKeyword(String keyword) {
		return productRepository.findByKeyword(keyword);
	}

}
