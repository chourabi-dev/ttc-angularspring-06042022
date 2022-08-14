package com.ttcdemospring.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name="sells" )

public class Sells {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn( name="clients_id" )
	private Clients client;
	
	@ManyToOne
	@JoinColumn( name="products_id" )
	private Product product;
	
	
	private int quantity;
	
	
	
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	private LocalDateTime datetime = LocalDateTime.now();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Clients getClient() {
		return client;
	}


	public void setClient(Clients client) {
		this.client = client;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public LocalDateTime getDatetime() {
		return datetime;
	}


	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}


	public Sells() {
		super();
	}
	
		
	
	

}
