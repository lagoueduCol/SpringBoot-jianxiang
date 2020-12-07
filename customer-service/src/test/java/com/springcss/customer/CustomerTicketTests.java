package com.springcss.customer;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

import com.springcss.customer.domain.CustomerTicket;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CustomerTicketTests {

	private static final String ORDER_NUMBER = "Order00001";

	@Test
	public void testOrderNumberIsExactly10Chars() throws Exception {

		CustomerTicket customerTicket = new CustomerTicket(100L, ORDER_NUMBER);

		assertThat(customerTicket.getOrderNumber().toString()).isEqualTo(ORDER_NUMBER);
	}
}
