package com.springcss.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcss.order.domain.Order;
import com.springcss.order.service.OrderService;

@RestController
@RequestMapping(value="orders")
public class OrderController {
  
	@Autowired
	OrderService orderService;
    	
	@GetMapping(value = "/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {	
		
		Order order = orderService.getOrderById(orderId);
    	return order;
    }
	
	@GetMapping(value = "orderNumber/{orderNumber}")
    public Order getOrderByOrderNumber(@PathVariable String orderNumber) {	
		
		Order order = orderService.getOrderDetailByOrderNumber(orderNumber);
    	return order;
    }
	
	@PostMapping(value = "")
    public Order addOrder(@RequestBody Order order) {	
		
		Order result = orderService.addOrder(order);
    	return result;
    }
}
