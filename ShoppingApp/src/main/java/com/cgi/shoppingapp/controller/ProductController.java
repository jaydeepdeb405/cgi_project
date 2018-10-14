package com.cgi.shoppingapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
	public ResponseEntity<Map<String, List<Product>>> getAllProducts() {
		List<Product> products = productService.showAllProducts();
		Map<String, List<Product>> response = new HashMap<String, List<Product>>();
		response.put("products",products);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=UTF-8");
	    headers.add("X-Fsl-Location", "/");
	    headers.add("X-Fsl-Response-Code", "302");
		
		System.out.println("Products fetched");
		if (products.isEmpty()) {
			return new ResponseEntity<Map<String, List<Product>>>(response, headers, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Map<String, List<Product>>>(response, headers, HttpStatus.OK);
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
	
	@RequestMapping(value = "/products", params = {"brand"}, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsByBrand(@RequestParam("brand") String brand){
		List<Product> products = productService.filterByBrand(brand);
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", params = {"search","cat"}, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> searchByCategory(@RequestParam("search") String searchKey, @RequestParam("cat") String category){
		List<Product> products = productService.search(searchKey,category);
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
}
