package com.springcss.order.domain;

public class Goods {
	private Long id;	
	private String goodsCode;
	private String goodsName;
	private Double price;
	
	public Goods() {
		super();
	}

	public Goods(Long id, String goodsCode, String goodsName, Double price) {
		super();
		this.id = id;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}	
}
