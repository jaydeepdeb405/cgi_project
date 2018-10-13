package com.cgi.shoppingapp.repository;

import java.util.List;

import com.cgi.shoppingapp.model.User;

public interface UserRepository {
	public boolean checkUserExists(User user);
}
