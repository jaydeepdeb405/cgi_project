package com.cgi.shoppingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.shoppingapp.model.Product;
import com.cgi.shoppingapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> showAllProducts() {
		return productRepository.getAllProducts();
	}
	
	@Override
	public List<Product> filterByPriceRange(Integer minPrice, Integer maxPrice) {
		return productRepository.getProductsByPrice(minPrice, maxPrice);
	}
	
	@Override
	public List<Product> filterByCategory(String category){
		return productRepository.getProductsByCategory(category);
	}
	
	@Override
	public List<Product> filterByGender(String gender){
		return productRepository.getProductsByGender(gender);
	}
	
}
