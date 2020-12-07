package com.springcss.customer.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderClient {

	private static final Logger logger = LoggerFactory.getLogger(OrderClient.class);

	@Autowired
	RestTemplate restTemplate;

	public OrderMapper getOrderByOrderNumber(String orderNumber) {

		logger.debug("Get order: {}", orderNumber);

		ResponseEntity<OrderMapper> restExchange = restTemplate.exchange(
				"http://localhost:8083/orders/{orderNumber}", HttpMethod.GET, null,
				OrderMapper.class, orderNumber);

		 OrderMapper result = restExchange.getBody();

		return result;
	}
}
