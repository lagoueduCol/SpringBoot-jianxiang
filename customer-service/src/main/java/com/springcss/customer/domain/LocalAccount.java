package com.springcss.customer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localaccount")
public class LocalAccount {
    @Id
	@GeneratedValue
	private Long id;
    private String accountCode;    
    private String accountName;
    
	public LocalAccount(Long id, String accountCode, String accountName) {
		super();
		this.id = id;
		this.accountCode = accountCode;
		this.accountName = accountName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}    
}
