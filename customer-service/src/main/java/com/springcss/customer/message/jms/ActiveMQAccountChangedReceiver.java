//package com.springcss.customer.message.jms;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Component;
//
//import com.springcss.customer.message.AbstractAccountChangedReceiver;
//import com.springcss.message.AccountChangedEvent;
//import com.springcss.message.AccountChannels;
//
//@Component("activeMQAccountChangedReceiver")
//public class ActiveMQAccountChangedReceiver extends AbstractAccountChangedReceiver {
//
//	@Autowired
//	private JmsTemplate jmsTemplate;
//
//	@Override
//	protected AccountChangedEvent receiveEvent() {
//		return (AccountChangedEvent) jmsTemplate.receiveAndConvert(AccountChannels.SPRINGCSS_ACCOUNT_QUEUE);
//	}
//
//	@Override
//	@JmsListener(destination = AccountChannels.SPRINGCSS_ACCOUNT_QUEUE)
//	public void handlerAccountChangedEvent(AccountChangedEvent event) {
//		
//		super.handleEvent(event);		
//	}
//}
