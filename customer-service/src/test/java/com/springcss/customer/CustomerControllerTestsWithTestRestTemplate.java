package com.springcss.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcss.customer.domain.CustomerTicket;
import com.springcss.customer.service.CustomerTicketService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTestsWithTestRestTemplate {

	@Autowired
    private TestRestTemplate testRestTemplate;

	@MockBean
	private CustomerTicketService customerTicketService;

	@Test
	public void testGenerateCustomerTicket() throws Exception {
		Long accountId = 100L;
		String orderNumber = "Order00001";		
		
		given(this.customerTicketService.generateCustomerTicket(accountId, orderNumber))
				.willReturn(new CustomerTicket(1L, accountId, orderNumber , "DemoCustomerTicket1", new Date()));

		CustomerTicket actual = testRestTemplate.postForObject("/customers/" + accountId+ "/" + orderNumber, null, CustomerTicket.class);
		assertThat(actual.getOrderNumber()).isEqualTo(orderNumber);
	}
}