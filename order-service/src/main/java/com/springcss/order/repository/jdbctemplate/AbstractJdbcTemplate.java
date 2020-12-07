package com.springcss.order.repository.jdbctemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.springcss.order.domain.Order;

public abstract class AbstractJdbcTemplate {

	@Autowired
	private DataSource dataSource;
	
	public final Object execute(String sql){  
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			Object object = handleResultSet(resultSet);			
			return object;
		} catch (SQLException e) {
			System.out.print(e);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		return null;
	}
	
	protected abstract Object handleResultSet(ResultSet rs) throws SQLException;  
}
