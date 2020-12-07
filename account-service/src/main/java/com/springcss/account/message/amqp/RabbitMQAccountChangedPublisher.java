package com.springcss.account.message.amqp;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springcss.account.message.AbstractAccountChangedPublisher;
import com.springcss.message.AccountChangedEvent;
import com.springcss.message.AccountChannels;

@Component("rabbitMQAccountChangedPublisher")
public class RabbitMQAccountChangedPublisher extends AbstractAccountChangedPublisher {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Override
	protected void publishEvent(AccountChangedEvent event) {
		rabbitTemplate.convertAndSend(AccountChannels.SPRINGCSS_ACCOUNT_QUEUE, event, new MessagePostProcessor() {
			@Override
			public Message postProcessMessage(Message message) throws AmqpException {
				MessageProperties props = message.getMessageProperties();
				props.setHeader("EVENT_SYSTEM", "SpringCSS");
				return message;
			}
		});		
	}
}
