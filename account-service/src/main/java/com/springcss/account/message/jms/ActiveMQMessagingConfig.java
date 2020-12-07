package com.springcss.account.message.jms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import com.springcss.message.AccountChangedEvent;

@Configuration
public class ActiveMQMessagingConfig {

	@Bean
	public MappingJackson2MessageConverter activeMQMessageConverter() {
		MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
		messageConverter.setTypeIdPropertyName("_typeId");

		Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
		typeIdMappings.put("accountChangedEvent", AccountChangedEvent.class);
		messageConverter.setTypeIdMappings(typeIdMappings);

		return messageConverter;
	}

}
