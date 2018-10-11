package com.cgi.shoppingapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.cgi.shoppingapp.model.User;

public class UserRepositoryImpl implements UserRepository {
	
	private static final String LOGIN_QUERY = "SELECT * FROM user where username=? AND password=?"; 
	
	@Autowired
	JdbcTemplate template;
	
	private class UserMapper implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getInt("id"),
							   rs.getString("username"),
							   rs.getString("password"));
		}
	}
	
	@Override
	public boolean login(User user) {
		if(template.execute(LOGIN_QUERY,new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				return ps.execute();
			}
		})) {
			return true;
		} else {
			return false;
		}
	}

}
