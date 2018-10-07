package com.cgi.shoppingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.shoppingapp.dao.ProductDao;
import com.cgi.shoppingapp.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> showAllProducts() {
		return productDao.getAllProducts();
	}
}
