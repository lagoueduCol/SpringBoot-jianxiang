package com.springcss.order.repository.jdbctemplate;

import java.util.List;

import com.springcss.order.domain.Order;

public class AbstractJdbcTemplateTest {

	@SuppressWarnings("unchecked")
	public void test() {
	     AbstractJdbcTemplate jdbcTemplate = new OrderJdbcTemplate();  
	     List<Order> orders = (List<Order>) jdbcTemplate.execute("select * from Order");
	}
}
