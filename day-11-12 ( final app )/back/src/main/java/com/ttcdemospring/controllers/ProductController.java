package com.ttcdemospring.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttcdemospring.entities.Category;
import com.ttcdemospring.entities.Product;
import com.ttcdemospring.repositories.CategoryRepository;
import com.ttcdemospring.repositories.ProductRepository;
import com.ttcdemospring.requests.ProductRequest;
import com.ttcdemospring.responses.JsonResponse;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
	
	
	// injection de service
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository cr;
	
	
	
	@PostMapping("/add")
	
	public ResponseEntity<?> addProduct( @RequestBody ProductRequest model ){
		
		// CREATE THE ENTITY
		
		Product p = new Product();
		
		
		// fill the product
		
		p.setTitle(model.getTitle());
		p.setPrice(model.getPrice());
		p.setQuantity(model.getQuantity());
		
		
		long idCategory = model.getCategory();
		
		
		Category c = this.cr.findById(idCategory).get();
		
		
		p.setCategory(  c );
		
		
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
	
	
	
	
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> update( @PathVariable() long id, @RequestBody ProductRequest model ){
		
		// find product by id !! SELECT ... WHERE ID = ..
		
		
		try {
			Product old = this.productRepository.findById(id).get();
			 
			 old.setTitle(model.getTitle());
			 old.setPrice(model.getPrice());
			 old.setQuantity(model.getQuantity());
			 
			 
			 long idCategory = model.getCategory();
				
				
				Category c = this.cr.findById(idCategory).get();
				
				
				old.setCategory(  c );
				
			 
			 this.productRepository.save(old);  // repository check if has an ID => UPDATE , else INSERT
			 
			 
			 JsonResponse res = new JsonResponse();
			 
			 
			 	res.setSuccess(true);
				res.setMessage("product updated successfully.");
				return ResponseEntity.ok( res );
		}catch(NoSuchElementException e) {
		
			 JsonResponse res = new JsonResponse();
			 
			 
			 	res.setSuccess(false);
				res.setMessage("could not found product");
				return ResponseEntity.ok( res );
				
		}
		
		 
		 
		
	}
	
	

	@GetMapping("/find/{id}")
	public ResponseEntity<?> find( @PathVariable() long id  ){
		
	 
		
		try {
			Product p = this.productRepository.findById(id).get();
			 
			 
			ProductRequest res = new ProductRequest();
			
			res.setTitle(p.getTitle());
			res.setPrice(p.getPrice());
			res.setQuantity(p.getQuantity());
			res.setCategory(p.getCategory().getId());
			
			return ResponseEntity.ok( res );
				
		}catch(NoSuchElementException e) {
		
			 JsonResponse res = new JsonResponse();
			 
			 
			 	res.setSuccess(false);
				res.setMessage("could not found product");
				return ResponseEntity.ok( res );
				
		}
		
		 
		 
		
	}
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete( @PathVariable() long id  ){
		
		// find product by id !! SELECT ... WHERE ID = ..
		
		
		try {
			Product old = this.productRepository.findById(id).get();
			 
			  
			 
			 this.productRepository.delete(old);  
			 
			 
			 JsonResponse res = new JsonResponse();
			 
			 
			 	res.setSuccess(true);
				res.setMessage("product deleted successfully.");
				return ResponseEntity.ok( res );
				
		}catch(NoSuchElementException e) {
		
			 JsonResponse res = new JsonResponse();
			 
			 
			 	res.setSuccess(false);
				res.setMessage("could not found product");
				return ResponseEntity.ok( res );
				
		}
		
		 
		 
		
	}
	
	
	
	
	
	/**************************************  search  ****************************************/
	
	
	// SELECT * FROM PRODUCT WHERE QUANTITY=0
	
	
	
	@GetMapping("/out-of-stock")
	
	public ResponseEntity<?> outOfStock(){
		return ResponseEntity.ok(  this.productRepository.findByQuantity( 0 ) ); 
	}
	
	
	
	
	
	
	
	
	
	
}
