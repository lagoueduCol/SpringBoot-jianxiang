package com.springcss.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcss.order.domain.JpaOrder;
import com.springcss.order.service.JpaOrderService;

@RestController
@RequestMapping(value="orders/jpa")
public class JpaOrderController {
  
	@Autowired
	JpaOrderService jpaOrderService;
    	
	@GetMapping(value = "/{orderId}")
    public JpaOrder getOrderById(@PathVariable Long orderId) {	
		
		JpaOrder order = jpaOrderService.getOrderById(orderId);
    	return order;
    }
	
	@GetMapping(value = "orderNumber/{orderNumber}")
    public JpaOrder getOrderByOrderNumber(@PathVariable String orderNumber) {	
		
//		JpaOrder order = jpaOrderService.getOrderByOrderNumber(orderNumber);
//		JpaOrder order = jpaOrderService.getOrderByOrderNumberByExample(orderNumber);
		JpaOrder order = jpaOrderService.getOrderByOrderNumberBySpecification(orderNumber);
    	return order;
    }
	
	@PostMapping(value = "")
    public JpaOrder addOrder(@RequestBody JpaOrder order) {	
		
		JpaOrder result = jpaOrderService.addOrder(order);
    	return result;
    }
}
