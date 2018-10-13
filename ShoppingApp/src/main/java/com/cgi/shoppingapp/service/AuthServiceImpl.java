package com.cgi.shoppingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.shoppingapp.model.Customer;
import com.cgi.shoppingapp.model.User;
import com.cgi.shoppingapp.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean login(User user) {
		if(userRepository.getUsers(user).isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean register(User user, Customer customer) {
		if(userRepository.registrationSucess(user, customer)) {
			return true;
		}else {
			return false;
		}
	}

}
