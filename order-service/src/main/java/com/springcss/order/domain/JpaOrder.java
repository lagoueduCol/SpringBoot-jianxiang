package com.springcss.order.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "`order`")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@NamedQueries({ @NamedQuery(name = "getOrderByOrderNumberWithQuery", query = "select o from JpaOrder o where o.orderNumber = ?1") })
public class JpaOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String orderNumber;
	private String deliveryAddress;

	@ManyToMany(targetEntity = JpaGoods.class)
	@JoinTable(name = "order_goods", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "goods_id", referencedColumnName = "id"))
	private List<JpaGoods> goods = new ArrayList<>();

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

	public List<JpaGoods> getGoods() {
		return goods;
	}

	public void setGoods(List<JpaGoods> goods) {
		this.goods = goods;
	}
}
