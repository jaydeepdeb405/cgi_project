package com.cgi.shoppingapp.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cgi.shoppingapp.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private static final String LOGIN_QUERY = "SELECT * FROM user where username=? AND password=?"; 
	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public boolean checkUserExists(User user) {
		List<User> users = template.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(LOGIN_QUERY);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				return ps;
			}
		}, new UserMapper());
		System.out.println(users.toString());
		if(users.isEmpty())
			return false;
		else
			return true;
	}
	
	private class UserMapper implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getInt("id"),
							   rs.getString("username"),
							   rs.getString("password"));
		}
	}

}
