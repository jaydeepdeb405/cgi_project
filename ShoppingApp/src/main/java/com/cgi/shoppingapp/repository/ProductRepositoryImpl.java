package com.cgi.shoppingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cgi.shoppingapp.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	private static final String VIEW_ALL_PRODUCTS_QUERY = "SELECT * FROM product";
	private static final String SORT_PRODUCTS_BY_PRICE_QUERY = "SELECT * FROM product where price between ? AND ?";
	private static final String SORT_PRODUCTS_BY_CATEGORY_QUERY = "SELECT * FROM product WHERE category LIKE ?";
	private static final String SORT_PRODUCTS_BY_GENDER_QUERY = "SELECT * FROM product where gender LIKE ?";
	private static final String SORT_PRODUCTS_BY_BRAND_QUERY = "SELECT * FROM product where brand LIKE ?";
	private static final String SEARCH_BY_CATEGORY_QUERY = "SELECT * FROM product where product_name LIKE ? AND category LIKE ?";

	@Autowired
	private JdbcTemplate template;
	
	private class ProductMapper implements RowMapper<Product>{
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Product(
					rs.getLong("id"), 
					rs.getString("product_name"),
					rs.getDouble("price"),
					rs.getString("image_url"),
					rs.getString("category"),
					rs.getString("gender"),
					rs.getString("brand"));
		}
	}
	
	@Override
	public List<Product> getAllProducts() {
		return template.query(VIEW_ALL_PRODUCTS_QUERY, new ProductMapper());
	}
	
	@Override
	public List<Product> getProductsByPrice(Integer minPrice, Integer maxPrice) {
		Integer[] params = {minPrice, maxPrice};
		return template.query(SORT_PRODUCTS_BY_PRICE_QUERY, params, new ProductMapper());
	}
	
	@Override
	public List<Product> getProductsByCategory(String category) {
		String[] params = {category};
		return template.query(SORT_PRODUCTS_BY_CATEGORY_QUERY, params, new ProductMapper());
	}
	
	@Override
	public List<Product> getProductsByGender(String gender) {
		String[] params = {gender};
		return template.query(SORT_PRODUCTS_BY_GENDER_QUERY, params, new ProductMapper());
	}
	
	@Override
	public List<Product> getProductsByBrand(String brand) {
		String[] params = {brand};
		return template.query(SORT_PRODUCTS_BY_BRAND_QUERY, params, new ProductMapper());	
	}
	
	@Override
	public List<Product> search(String searchKey, String category) {
		searchKey = searchKey.concat("%");
		System.out.println(searchKey);
		String[] params = {searchKey, category};
		return template.query(SEARCH_BY_CATEGORY_QUERY, params, new ProductMapper());
	}
	
}
