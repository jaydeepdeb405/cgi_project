package com.cgi.shoppingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.cgi.shoppingapp.model.Customer;
import com.cgi.shoppingapp.model.User;
import com.cgi.shoppingapp.repository.UserRepository;

public class AuthServiceImpl implements AuthService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean login(User user) {
		if(userRepository.login(user)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String register(User user, Customer customer) {
		// TODO Auto-generated method stub
		return "";
	}

}
