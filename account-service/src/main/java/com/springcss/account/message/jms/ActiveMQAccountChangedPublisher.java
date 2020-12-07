package com.springcss.account.message.jms;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.springcss.account.message.AbstractAccountChangedPublisher;
import com.springcss.message.AccountChangedEvent;
import com.springcss.message.AccountChannels;

@Component("activeMQAccountChangedPublisher")
public class ActiveMQAccountChangedPublisher extends AbstractAccountChangedPublisher {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	protected void publishEvent(AccountChangedEvent event) {
		jmsTemplate.convertAndSend(AccountChannels.SPRINGCSS_ACCOUNT_QUEUE, event, this::addEventSource);
	}

	private Message addEventSource(Message message) throws JMSException {
		message.setStringProperty("EVENT_SYSTEM", "SpringCSS");
		return message;
	}
}
