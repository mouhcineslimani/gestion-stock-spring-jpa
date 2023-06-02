package org.mql.stock.repositories;

import java.util.List;

import org.mql.stock.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findByName(String name);
	
	@Query("SELECT p FROM Product p where p.name LIKE :keyword%")
	public List<Product> findByKeyword(String keyword);
}
