package com.springcss.message;

import java.io.Serializable;

public class AccountChangedEvent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//事件类型
    private String type;
    //事件所对应的操作
    private String operation;
    //事件对应的领域模型
    private AccountMessage accountMessage;

    
    public AccountChangedEvent() {
		super();
	}

	public AccountChangedEvent(String type, String operation, AccountMessage accountMessage) {
        super();
        this.type   = type;
        this.operation = operation;
        this.accountMessage = accountMessage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public AccountMessage getAccountMessage() {
		return accountMessage;
	}

	public void setAccountMessage(AccountMessage accountMessage) {
		this.accountMessage = accountMessage;
	}
}