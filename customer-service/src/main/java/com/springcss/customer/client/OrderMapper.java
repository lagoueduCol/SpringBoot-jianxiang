package com.springcss.customer.client;

import java.io.Serializable;

public class OrderMapper implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;	
	private String orderNumber;
	private String deliveryAddress;
	
	public OrderMapper(Long id, String orderNumber, String deliveryAddress) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.deliveryAddress = deliveryAddress;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
}