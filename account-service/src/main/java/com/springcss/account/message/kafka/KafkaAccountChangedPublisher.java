package com.springcss.account.message.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.springcss.account.message.AbstractAccountChangedPublisher;
import com.springcss.message.AccountChangedEvent;
import com.springcss.message.AccountChannels;

@Component("kafkaAccountChangedPublisher")
public class KafkaAccountChangedPublisher extends AbstractAccountChangedPublisher {

	@Autowired
	private KafkaTemplate<String, AccountChangedEvent> kafkaTemplate;
	  
	@Override
	protected void publishEvent(AccountChangedEvent event) {
		kafkaTemplate.send(AccountChannels.SPRINGCSS_ACCOUNT_TOPIC, event);
	}
}
