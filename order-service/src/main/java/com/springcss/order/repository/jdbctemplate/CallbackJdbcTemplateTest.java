package com.springcss.order.repository.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.springcss.order.domain.Order;

public class CallbackJdbcTemplateTest {

	public Object queryOrder(final String sql)  {

		class OrderStatementCallback implements StatementCallback {

			public Object handleStatement(Statement statement) throws SQLException {
				ResultSet rs = statement.executeQuery(sql);
				List<Order> orders = new ArrayList<Order>();
				while (rs.next()) {
					Order order = new Order(rs.getLong("id"), rs.getString("order_number"),
							rs.getString("delivery_address"));
					orders.add(order);
				}

				return orders;
			}
		}

		CallbackJdbcTemplate jdbcTemplate = new CallbackJdbcTemplate();
		return jdbcTemplate.execute(new OrderStatementCallback());
	}
	
	public Object queryOrder2(final String sql)  {

		CallbackJdbcTemplate jdbcTemplate = new CallbackJdbcTemplate();
		return jdbcTemplate.execute(new StatementCallback() {
			
			public Object handleStatement(Statement statement) throws SQLException {
				ResultSet rs = statement.executeQuery(sql);
				List<Order> orders = new ArrayList<Order>();
				while (rs.next()) {
					Order order = new Order(rs.getLong("id"), rs.getString("order_number"),
							rs.getString("delivery_address"));
					orders.add(order);
				}

				return orders;
			}
		});		
	}


	@SuppressWarnings("unchecked")
	public void test() {
		List<Order> orders = (List<Order>) queryOrder("select * from Order");
	}
}
