package com.springcss.order.domain;

import java.util.ArrayList;
import java.util.List;

public class Order{
	
	private Long id;	
	private String orderNumber;
	private String deliveryAddress;
	private List<Goods> goodsList;		
	
	public Order() {
		super();
	}

	public Order(Long id, String orderNumber, String deliveryAddress) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.deliveryAddress = deliveryAddress;
		this.goodsList = new ArrayList<Goods>();
	}
	
	public void addGoods(Goods goods) {
		goodsList.add(goods);
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

	public List<Goods> getGoods() {
		return goodsList;
	}

	public void setGoods(List<Goods> goods) {
		this.goodsList = goods;
	}

}
