package org.mql.stock.controllers;

import java.util.List;

import org.mql.stock.business.StockService;
import org.mql.stock.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private StockService service;

	@GetMapping
	public List<Product> getAllProducts() {
		return service.products();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getAllProductsById(@PathVariable int id) {
		Product p = service.product(id);
		return p == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(p);
	}

	@GetMapping("/search")
	public List<Product> getAllProductsByName(@RequestParam String name) {
		return service.products(name);
	}

	@GetMapping("/keyword/{keyword}")
	public List<Product> getAllProductsByKeyword(@PathVariable String keyword) {
		return service.getProductsByKeyword(keyword);
	}
}
