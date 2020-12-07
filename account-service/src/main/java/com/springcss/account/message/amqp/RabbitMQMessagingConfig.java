package com.springcss.account.message.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springcss.message.AccountChannels;

@Configuration
public class RabbitMQMessagingConfig {

	public static final String SPRINGCSS_ACCOUNT_DIRECT_EXCHANGE = "springcss.account.exchange";
	public static final String SPRINGCSS_ACCOUNT_ROUTING = "springcss.account.routing";

	@Bean
	public Queue SpringCssDirectQueue() {
		return new Queue(AccountChannels.SPRINGCSS_ACCOUNT_QUEUE, true);
	}

	@Bean
	public DirectExchange SpringCssDirectExchange() {
		return new DirectExchange(SPRINGCSS_ACCOUNT_DIRECT_EXCHANGE, true, false);
	}

	@Bean
	public Binding bindingDirect() {
		return BindingBuilder.bind(SpringCssDirectQueue()).to(SpringCssDirectExchange())
				.with(SPRINGCSS_ACCOUNT_ROUTING);
	}

	@Bean
	public Jackson2JsonMessageConverter rabbitMQMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}