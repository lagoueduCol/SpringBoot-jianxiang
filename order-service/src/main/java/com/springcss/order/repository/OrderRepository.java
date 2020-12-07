package com.springcss.order.repository;

import com.springcss.order.domain.Order;

public interface OrderRepository {
	
	Order addOrder(Order order);
	
	Order getOrderById(Long orderId);
	
	Order getOrderDetailByOrderNumber(String orderNumber);
}
