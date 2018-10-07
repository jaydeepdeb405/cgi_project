package com.cgi.shoppingapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cgi.shoppingapp.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	private static final String VIEW_ALL_PRODUCTS_QUERY = "SELECT * FROM product";
	
	@Autowired
	private JdbcTemplate template;
	
	private class ProductMapper implements RowMapper<Product>{
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Product(
					rs.getLong("product_id"), 
					rs.getString("product_name"),
					rs.getDouble("price"),
					rs.getString("image"));
		}
	}
	
	@Override
	public List<Product> getAllProducts() {
		return template.query(VIEW_ALL_PRODUCTS_QUERY, new ProductMapper());
	}
	
}
