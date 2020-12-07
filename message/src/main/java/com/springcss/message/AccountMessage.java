package com.springcss.message;

import java.io.Serializable;

public class AccountMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String accountCode;    
    private String accountName;
    
	public AccountMessage() {
		super();
	}

	public AccountMessage(Long id, String accountCode, String accountName) {
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
