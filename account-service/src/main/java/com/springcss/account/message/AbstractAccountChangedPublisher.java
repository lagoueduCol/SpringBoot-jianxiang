package com.springcss.account.message;

import com.springcss.account.domain.Account;
import com.springcss.message.AccountChangedEvent;
import com.springcss.message.AccountMessage;

public abstract class AbstractAccountChangedPublisher implements AccountChangedPublisher {

	@Override
	public void publishAccountChangedEvent(Account account, String operation) {

		AccountMessage accountMessage = new AccountMessage(account.getId(), account.getAccountCode(), account.getAccountName());
		AccountChangedEvent event = new AccountChangedEvent(AccountChangedEvent.class.getTypeName(),
				operation.toString(), accountMessage);

		publishEvent(event);
	}

	protected abstract void publishEvent(AccountChangedEvent event);
}
