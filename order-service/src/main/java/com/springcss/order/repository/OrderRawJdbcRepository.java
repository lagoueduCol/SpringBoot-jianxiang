package com.springcss.order.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcss.order.domain.Order;

@Repository("orderRawJdbcRepository")
public class OrderRawJdbcRepository implements OrderRepository {

	@Autowired
	private DataSource dataSource;

	@Override
	public Order addOrder(Order order) {
		// 不做实现
		return null;
	}

	@Override
	public Order getOrderById(Long orderId) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("select id, order_number, delivery_address from `order` where id=?");
			statement.setLong(1, orderId);
			resultSet = statement.executeQuery();
			Order order = null;
			if (resultSet.next()) {
				order = new Order(resultSet.getLong("id"), resultSet.getString("order_number"),
						resultSet.getString("delivery_address"));
			}
			return order;
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

	@Override
	public Order getOrderDetailByOrderNumber(String orderNumber) {
		// 不做实现
		return null;
	}
}
