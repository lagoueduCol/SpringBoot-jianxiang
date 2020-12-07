package com.springcss.customer.metrics;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@Component
public class CounterService {
	
	public CounterService() {
		Metrics.addRegistry(new SimpleMeterRegistry());
	}

	public void counter(String name, String... tags) {
		Counter counter = Metrics.counter(name, tags);
		counter.increment();
	}
}




//@Autowired
//private MeterRegistry registry;
//
//public void counter(String name, String... tags) {
//	Counter counter = registry.counter(name, tags);
//	counter.increment();
//}