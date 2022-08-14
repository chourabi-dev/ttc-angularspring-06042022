package com.ttcdemospring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name="products" )


public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	@Column( name="product_title" , nullable=false )
	private String title;
	
	@Column( name="product_quantity" , nullable=false )
	private int quantity;
	
	@Column( name="product_price" , nullable=false )
	private float price;
	
	
	
	@ManyToOne
	@JoinColumn( name="categories_id" )
	@JsonIgnore
	private Category category;
	
	
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Product() {
		super();
	}
	
	
	
	
	
	
	
}
