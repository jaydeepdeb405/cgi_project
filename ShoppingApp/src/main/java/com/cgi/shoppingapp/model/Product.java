package com.cgi.shoppingapp.model;

public class Product {
	private long id;
	private String product_name;
	private double price;
	private String image_url;
	private String category;
	private String gender;
	private String brand;
	
	public Product(long id, String product_name, double price, String image_url, String category, String gender, String brand) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.price = price;
		this.image_url = image_url;
		this.category = category;
		this.gender = gender;
		this.brand = brand;
	}

	public long get_id() {
		return id;
	}

	public void set_id(long id) {
		this.id = id;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + id + ", product_name=" + product_name + ", price=" + price
				+ ", image_url=" + image_url + ", category=" + category + ", gender=" + gender + ", brand=" + brand
				+ "]";
	}
	
}
