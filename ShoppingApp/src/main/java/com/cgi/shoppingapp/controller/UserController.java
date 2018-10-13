package com.cgi.shoppingapp.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.shoppingapp.model.User;
import com.cgi.shoppingapp.model.Customer;
import com.cgi.shoppingapp.service.AuthService;

@RestController
public class UserController {
	
	@Autowired
	AuthService authService;
	
	@SuppressWarnings("unchecked")
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody List<Object> params) {
		System.out.println(params.get(0).getClass());
		LinkedHashMap<String, String> jsonObject;
		jsonObject = (LinkedHashMap<String, String>) params.get(0);
		User user = new User(null, 
				jsonObject.get("username"), 
				jsonObject.get("password"));
		jsonObject = (LinkedHashMap<String, String>) params.get(1);
		Customer customer =  new Customer(null, 
				jsonObject.get("firstname"), 
				jsonObject.get("lastname"),
				jsonObject.get("email"), 
				jsonObject.get("address"),
				jsonObject.get("phone"));
		if(authService.register(user, customer))
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		if(authService.login(user))
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
}
