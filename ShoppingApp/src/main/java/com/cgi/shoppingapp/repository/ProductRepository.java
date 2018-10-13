package com.cgi.shoppingapp.repository;

import java.util.List;

import com.cgi.shoppingapp.model.Product;

public interface ProductRepository {
	public List<Product> getAllProducts();
	public List<Product> getProductsByPrice(Integer minPrice, Integer maxPrice);
	public List<Product> getProductsByCategory(String category);
	public List<Product> getProductsByGender(String gender);
}
