package com.cgi.shoppingapp.service;

import com.cgi.shoppingapp.model.Customer;
import com.cgi.shoppingapp.model.User;

public interface AuthService {
	public boolean login(User user);
	public String register(User user,Customer customer);
}
