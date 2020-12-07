package com.springcss.customer;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcss.customer.client.OrderClient;
import com.springcss.customer.client.OrderMapper;
import com.springcss.customer.domain.CustomerTicket;
import com.springcss.customer.domain.LocalAccount;
import com.springcss.customer.repository.CustomerTicketRepository;
import com.springcss.customer.repository.LocalAccountRepository;
import com.springcss.customer.service.CustomerTicketService;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CustomerServiceTests {

	@MockBean
	private OrderClient orderClient;

	@MockBean
	private CustomerTicketRepository customerTicketRepository;	

	@MockBean
	private LocalAccountRepository localAccountRepository;

	@Autowired
	private CustomerTicketService customerTicketService;
	
	@Test
	public void testGetCustomerTicketById() throws Exception {
		Long id = 1L;
		
		Mockito.when(customerTicketRepository.getOne(id)).thenReturn(new CustomerTicket(1L, 1L, "Order00001", "DemoCustomerTicket1", new Date()));
        		
		CustomerTicket actual = customerTicketService.getCustomerTicketById(id);

		assertThat(actual).isNotNull();
		assertThat(actual.getOrderNumber()).isEqualTo("Order00001");
	}

	@Test
	public void testGenerateCustomerTicket() throws Exception {
		Long accountId = 100L;
		String orderNumber = "Order00001";
	
		Mockito.when(this.orderClient.getOrderByOrderNumber("Order00001"))
			.thenReturn(new OrderMapper(1L, orderNumber, "deliveryAddress"));
		
		Mockito.when(this.localAccountRepository.getOne(accountId))
			.thenReturn(new LocalAccount(100L, "accountCode", "accountName"));

		CustomerTicket actual = customerTicketService.generateCustomerTicket(accountId, orderNumber);

		assertThat(actual.getOrderNumber()).isEqualTo(orderNumber);
	}
}