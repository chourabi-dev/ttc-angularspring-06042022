package com.ttcdemospring.requests;

public class ProductRequest {

	private String title;
	private int quantity;
	private float price;
	private long category;
	
	
	
	
	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
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
	
	
	
	public ProductRequest() {
		
	}
	
	
	
	
}
