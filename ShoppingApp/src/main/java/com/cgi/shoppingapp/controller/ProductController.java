package com.cgi.shoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.shoppingapp.model.Product;
import com.cgi.shoppingapp.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> productHome() {
		List<Product> products = service.showAllProducts();
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
