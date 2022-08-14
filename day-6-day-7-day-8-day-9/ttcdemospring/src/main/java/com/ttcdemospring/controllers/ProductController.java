package com.ttcdemospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttcdemospring.entities.Product;
import com.ttcdemospring.repositories.ProductRepository;
import com.ttcdemospring.requests.ProductRequest;
import com.ttcdemospring.responses.JsonResponse;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	
	// injection de service
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/add")
	
	public ResponseEntity<?> addProduct( @RequestBody ProductRequest model ){
		
		// CREATE THE ENTITY
		
		Product p = new Product();
		
		
		// fill the product
		
		p.setTitle(model.getTitle());
		p.setPrice(model.getPrice());
		p.setQuantity(model.getQuantity());
		
		
		// SAVE THE ENTITY TO THE DATABASE !!!
		
		this.productRepository.save(p);
		
		
		JsonResponse res = new JsonResponse();
		
		
		res.setSuccess(true);
		res.setMessage("product inserted successfully.");
		
		return ResponseEntity.ok( res );
		
		
	}

	
	
	
	// list products !!
	
	@GetMapping("/list")
	public ResponseEntity<?> getList() {
		return ResponseEntity.ok(  this.productRepository.findAll()  ); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
