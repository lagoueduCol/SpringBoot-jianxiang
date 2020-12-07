package com.springcss.customer.message;

import org.springframework.beans.factory.annotation.Autowired;

import com.springcss.customer.domain.LocalAccount;
import com.springcss.customer.repository.LocalAccountRepository;
import com.springcss.message.AccountChangedEvent;
import com.springcss.message.AccountMessage;

public abstract class AbstractAccountChangedReceiver implements AccountChangedReceiver {

	@Autowired
	LocalAccountRepository localAccountRepository;

	@Override
	public void receiveAccountChangedEvent() {

		AccountChangedEvent event = receiveEvent();

		handleEvent(event);
	}

	protected void handleEvent(AccountChangedEvent event) {
		AccountMessage account = event.getAccountMessage();
		String operation = event.getOperation();

		operateAccount(account, operation);
	}

	private void operateAccount(AccountMessage accountMessage, String operation) {
		System.out.print(
				accountMessage.getId() + ":" + accountMessage.getAccountCode() + ":" + accountMessage.getAccountName());

		LocalAccount localAccount = new LocalAccount(accountMessage.getId(), accountMessage.getAccountCode(),
				accountMessage.getAccountName());

		if (operation.equals("ADD") || operation.equals("UPDATE")) {
			localAccountRepository.save(localAccount);
		} else {
			localAccountRepository.delete(localAccount);
		}
	}

	protected abstract AccountChangedEvent receiveEvent();
}
