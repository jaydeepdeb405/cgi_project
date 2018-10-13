package com.cgi.shoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.shoppingapp.model.Product;
import com.cgi.shoppingapp.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.showAllProducts();
		if (products.isEmpty()) {
			System.out.println("helllo");
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", params = {"min","max"}, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsByPriceRange(@RequestParam("min") Integer minPrice, @RequestParam("max") Integer maxPrice){
		List<Product> products = productService.filterByPriceRange(minPrice, maxPrice);
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", params = {"cat"}, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam("cat") String category){
		List<Product> products = productService.filterByCategory(category);
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", params = {"gen"}, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsByGender(@RequestParam("gen") String gender){
		List<Product> products = productService.filterByGender(gender);
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
