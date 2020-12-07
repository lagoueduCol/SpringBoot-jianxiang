//package com.springcss.customer.message.kafka;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//import com.springcss.customer.message.AbstractAccountChangedReceiver;
//import com.springcss.message.AccountChangedEvent;
//import com.springcss.message.AccountChannels;
//
//@Component
//public class KafkaAccountChangedListener extends AbstractAccountChangedReceiver {
//
//	@Override
//	@KafkaListener(topics = AccountChannels.SPRINGCSS_ACCOUNT_TOPIC)
//	public void handlerAccountChangedEvent(AccountChangedEvent event) {
//
//		super.handleEvent(event);	
//	}
//
//	@Override
//	protected AccountChangedEvent receiveEvent() {
//		return null;
//	}
//}
