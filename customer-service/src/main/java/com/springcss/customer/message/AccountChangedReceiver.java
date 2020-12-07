package com.springcss.customer.message;

import com.springcss.message.AccountChangedEvent;

public interface AccountChangedReceiver {
	
	//Pull模式下的消息接收方法
	void receiveAccountChangedEvent();
	
	//Push模式下的消息接收方法
	void handlerAccountChangedEvent(AccountChangedEvent event);
}
