//package com.springcss.customer.message.amqp;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.springcss.customer.message.AbstractAccountChangedReceiver;
//import com.springcss.message.AccountChangedEvent;
//import com.springcss.message.AccountChannels;
//
//@Component("rabbitMQAccountChangedReceiver")
//public class RabbitMQAccountChangedReceiver extends AbstractAccountChangedReceiver {
//
//	@Autowired
//	private RabbitTemplate rabbitTemplate;
//
//	@Override
//	public AccountChangedEvent receiveEvent() {
//		return (AccountChangedEvent) rabbitTemplate.receiveAndConvert(AccountChannels.SPRINGCSS_ACCOUNT_QUEUE);
//	}
//
//	@Override
//	@RabbitListener(queues = AccountChannels.SPRINGCSS_ACCOUNT_QUEUE)
//	public void handlerAccountChangedEvent(AccountChangedEvent event) {
//		super.handleEvent(event);
//	}
//}
