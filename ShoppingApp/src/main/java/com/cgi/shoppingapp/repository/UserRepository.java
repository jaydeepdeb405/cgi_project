package com.cgi.shoppingapp.repository;

import java.util.List;

import com.cgi.shoppingapp.model.Customer;
import com.cgi.shoppingapp.model.User;

public interface UserRepository {
	public List<User> getUsers(User user);
	public boolean registrationSucess(User user,Customer customer);
}
