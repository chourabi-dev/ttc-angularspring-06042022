package com.ttcdemospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttcdemospring.entities.Clients;
import com.ttcdemospring.entities.Sells;
import com.ttcdemospring.repositories.ClientRepository;
import com.ttcdemospring.repositories.ProductRepository;
import com.ttcdemospring.repositories.SellsRepository;
import com.ttcdemospring.requests.ClientModel;
import com.ttcdemospring.requests.SellsModel;
import com.ttcdemospring.responses.JsonResponse;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClientsController {
	
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	@Autowired
	SellsRepository sellsRepository;
	
	
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ClientModel model){
		Clients c = new Clients();
		
		c.setName(model.getName());
		c.setAddress(model.getAddress());
		c.setEmail(model.getEmail());
		c.setPhone(model.getPhone());
		
		this.clientRepository.save(c);
		
		
		
		 JsonResponse res = new JsonResponse();
		 
		 
	 	res.setSuccess(true);
		res.setMessage("client addedd successfully.");
		return ResponseEntity.ok( res );
	
	}
	
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getList() {
		return ResponseEntity.ok(  this.clientRepository.findAll()  ); 
	}
	
	
	
	// sells
	
	
	@PostMapping("/sells/buy")
	public ResponseEntity<?> addSell( @RequestBody SellsModel model  ){
		Sells s = new Sells();
		
		
		s.setClient( this.clientRepository.findById(model.getClient()).get() );
		s.setProduct( this.productRepository.findById( model.getProduct() ).get() );
		s.setQuantity(model.getQuantity());
		
		
		
		this.sellsRepository.save(s);
		
		JsonResponse res = new JsonResponse();
		
		
		res.setSuccess(true);
		res.setMessage("Taransaction successfully made.");
		return ResponseEntity.ok( res );
		
	}
	
	
	
	
	
	@GetMapping("/sells/list")
	public ResponseEntity<?> getAllTransactions() {
		return ResponseEntity.ok(  this.sellsRepository.findAll()  ); 
	}
	
	
	
	
	
	
	
	
}
