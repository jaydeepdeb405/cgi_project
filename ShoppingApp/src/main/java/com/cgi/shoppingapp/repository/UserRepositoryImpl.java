package com.cgi.shoppingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cgi.shoppingapp.model.Customer;
import com.cgi.shoppingapp.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private static final String LOGIN_QUERY = "SELECT * FROM user where username=? AND password=?";
	private static final String USER_INSERT_QUERY = "INSERT INTO user (username,password) values (?,?)";
	private static final String GET_USER_ID_QUERY = "SELECT id FROM user WHERE username LIKE ?";
	private static final String INSERT_CUSTOMER_QUERY = "INSERT INTO CUSTOMER (id,firstname,lastname,email,address,phone) values (?,?,?,?,?,?)";
	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<User> getUsers(User user) {
		String[] params = {user.getUsername(),user.getPassword()};
		return template.query(LOGIN_QUERY, params, new UserMapper());
	}
	
	@Override
	public boolean registrationSucess(User user, Customer customer) {
		String[] params0 = {user.getUsername(),user.getPassword()};
		template.update(USER_INSERT_QUERY, params0);
		String[] params1 = {user.getUsername()};
		System.out.println(params1[0]);
		List<Long> userId = template.query(GET_USER_ID_QUERY, params1, new RowMapper<Long>() {
			@Override
			public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Long(rs.getLong("id"));
			}
		});
		System.out.println(customer);
		Object[] params2 = {userId.get(0), 
				customer.getFirstName(), 
				customer.getLastName(), 
				customer.getEmail(), 
				customer.getAddress(), 
				customer.getPhone()};
		if(template.update(INSERT_CUSTOMER_QUERY, params2) > 0)
			return true;
		else
			return false;
	}
	
	private class UserMapper implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getLong("id"),
							   rs.getString("username"),
							   rs.getString("password"));
		}
	}

}
