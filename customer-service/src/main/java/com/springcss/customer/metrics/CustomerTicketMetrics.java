package com.springcss.customer.metrics;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import com.springcss.customer.domain.CustomerTicket;

import io.micrometer.core.instrument.MeterRegistry;

@Component
public class CustomerTicketMetrics extends AbstractRepositoryEventListener<CustomerTicket> {

	private MeterRegistry meterRegistry;

	public CustomerTicketMetrics(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
	}

	@Override
	protected void onAfterCreate(CustomerTicket customerTicket) {
//		meterRegistry.counter("customerTicket.created.count").increment();
		
		meterRegistry.summary("customerTicket.created.count").record(1);
	}
}
