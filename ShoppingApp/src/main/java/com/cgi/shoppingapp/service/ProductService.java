package com.cgi.shoppingapp.service;

import java.util.List;

import com.cgi.shoppingapp.model.Product;

public interface ProductService {
	public List<Product> showAllProducts();
	public List<Product> filterByPriceRange(Integer minPrice, Integer maxPrice);
}
