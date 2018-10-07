package com.cgi.shoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cgi.shoppingapp.model.Product;
import com.cgi.shoppingapp.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	public String productHome(Model model) {
		List<Product> products = service.showAllProducts();
		System.out.println(products);
		model.addAttribute("products",products);
		return "product";
	}
}
