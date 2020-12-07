package com.springcss.customer.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "customer_ticket")
public class CustomerTicket {
	@Id
	@GeneratedValue
	private Long id;
    private Long accountId;    
    private String orderNumber;
    private String description;
    private Date createTime;
    
        
	public CustomerTicket() {
		super();
	}

	public CustomerTicket(Long accountId, String orderNumber) {
		super();
		
		Assert.notNull(accountId, "Account Id must not be null");
		Assert.notNull(orderNumber, "Order Number must not be null");
		Assert.isTrue(orderNumber.length() == 10, "Order Number must be exactly 10 characters");

		this.accountId = accountId;
		this.orderNumber = orderNumber;
	}
	
	public CustomerTicket(Long accountId, String orderNumber, String description, Date createTime) {
		
		this(accountId, orderNumber);
		
		this.description = description;
		this.createTime = createTime;
	}
	
	public CustomerTicket(Long id, Long accountId, String orderNumber, String description, Date createTime) {
				
		this(accountId, orderNumber);
		
		this.id = id;
		this.description = description;
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
