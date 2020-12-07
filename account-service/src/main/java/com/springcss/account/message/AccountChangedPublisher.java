package com.springcss.account.message;

import com.springcss.account.domain.Account;

public interface AccountChangedPublisher {
	
	void publishAccountChangedEvent(Account account, String operation);

}
