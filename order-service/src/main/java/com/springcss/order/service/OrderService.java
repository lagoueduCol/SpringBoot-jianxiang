package com.springcss.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springcss.order.domain.Order;
import com.springcss.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
    @Qualifier("orderJdbcRepository")
	private OrderRepository orderRepository;
	
	
	public Order getOrderById(Long orderId) {
		
		return orderRepository.getOrderById(orderId);
	}
	
	public Order getOrderDetailByOrderNumber(String orderNumber) {
		return orderRepository.getOrderDetailByOrderNumber(orderNumber);
	}
	
	public Order addOrder(Order order) {
		return orderRepository.addOrder(order);
	}
	
}

