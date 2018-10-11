package com.cgi.shoppingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.shoppingapp.model.User;
import com.cgi.shoppingapp.service.AuthService;

@RestController
public class UserController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		if(authService.login(user))
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
