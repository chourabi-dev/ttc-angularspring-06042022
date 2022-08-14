package com.ttcdemospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttcdemospring.entities.Category;
import com.ttcdemospring.repositories.CategoryRepository;
import com.ttcdemospring.requests.CategoryModel;
import com.ttcdemospring.responses.JsonResponse;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoriesController {

	
	
	@Autowired
	CategoryRepository cr;
	
	// add
	
	@PostMapping("/add")
	public ResponseEntity<?> add( @RequestBody CategoryModel model ){
		
		// create new category
		Category c = new Category();
		
		c.setName(model.getName());
		
		
		this.cr.save(c);
		
		
		 JsonResponse res = new JsonResponse();
		 
		 
	 	res.setSuccess(true);
		res.setMessage("category addedd successfully.");
		return ResponseEntity.ok( res );
		
		
	}
	
	
	
	// list
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getList() {
		return ResponseEntity.ok(  this.cr.findAll()  ); 
	}
	
	
}
