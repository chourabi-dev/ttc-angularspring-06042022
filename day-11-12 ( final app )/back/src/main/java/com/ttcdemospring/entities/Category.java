package com.ttcdemospring.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name="categories")
public class Category {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	@Column( name="category_name" , nullable=false )
	private String name;
	
	
	
	@OneToMany( mappedBy="category" )
	public List<Product> products;
	


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Category() {
		super();
	}
	
	
	
}
