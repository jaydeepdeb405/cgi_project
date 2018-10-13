package com.cgi.shoppingapp.model;

public class Product {
	private long product_id;
	private String product_name;
	private double price;
	private String image_url;
	private String category;
	private String gender;
	
	public Product(long product_id, String product_name, double price, String image_url, String category, String gender) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.image_url = image_url;
		this.category = category;
		this.gender = gender;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", image_url=" + image_url + "]";
	}
	
}
