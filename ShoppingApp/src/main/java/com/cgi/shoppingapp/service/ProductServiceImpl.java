package com.cgi.shoppingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.shoppingapp.model.Product;
import com.cgi.shoppingapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productDao;
	
	@Override
	public List<Product> showAllProducts() {
		return productDao.getAllProducts();
	}
}
