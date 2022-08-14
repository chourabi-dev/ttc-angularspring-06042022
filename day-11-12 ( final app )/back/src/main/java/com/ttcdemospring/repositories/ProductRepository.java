package com.ttcdemospring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttcdemospring.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
	
	
	public List<Product> findByQuantity(int quantity);
	
	
	
	
	
	
	
}
