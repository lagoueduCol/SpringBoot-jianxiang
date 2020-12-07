package com.springcss.order.repository.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.springcss.order.domain.Order;

public class OrderJdbcTemplate extends AbstractJdbcTemplate {

	@Override
	protected Object handleResultSet(ResultSet rs) throws SQLException {

		List<Order> orders = new ArrayList<Order>();
		while (rs.next()) {
			Order order = new Order(rs.getLong("id"), rs.getString("order_number"), rs.getString("delivery_address"));
			orders.add(order);
		}
		return orders;
	}
}

