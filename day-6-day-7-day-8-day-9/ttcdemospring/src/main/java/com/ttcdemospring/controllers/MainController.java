package com.ttcdemospring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttcdemospring.requests.ProductRequest;
import com.ttcdemospring.responses.JsonResponse;

@RestController
@RequestMapping("/app")
public class MainController {
	
	
	// GET 
	@GetMapping("/test")
	public String sayHello() {
		return "hello world";
	}
	
	
	
	// SERVICE SOMME X Y 
	@GetMapping("/somme")
	public int somme( @RequestParam( required=true  ) int x, @RequestParam( required=true  ) int y ) {
		return ( x+y );
	}
	
	
	// path variables
	
	
	@GetMapping("/user/details/{id}")
	public void getUser( @PathVariable( name="id" ) int userID ) {
		
		System.out.println(userID);
		
		
		// SELECT * FROM USER WHERE ID = ...
	}
	
	
	
	@GetMapping("/products/list")
	public List<ProductRequest> getUsersList(  ) {
		
		
		
		/// FAKE !!!!
		List<ProductRequest> list = new ArrayList<ProductRequest>();
		
		ProductRequest p = new ProductRequest();
		p.setPrice(180);
		p.setQuantity(70);
		p.setTitle("Samsung s21");
		
		
		list.add(p);
		
		// DATABASE 
		
		return list;
		
		
	}
	
	
	/***************************************************************************************************/
	
	
	
	/* simulation add produit */
	
	@PostMapping("/produit/add")
	public JsonResponse addProduct( @RequestBody()  ProductRequest productModel ) {
		System.out.println(productModel.getPrice());
		
		System.out.println(productModel.getQuantity());
		
		System.out.println(productModel.getTitle());
		
		
		// INSERT INTO ..
		
		
		JsonResponse res = new JsonResponse();
		
		res.setSuccess(true);
		res.setMessage("product inserted successfully !!");
		
		return res;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
