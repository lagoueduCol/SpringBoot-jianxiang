package com.springcss.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.springcss.customer.controller.CustomerController;
import com.springcss.customer.domain.CustomerTicket;
import com.springcss.customer.service.CustomerTicketService;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTestsWithMockMvc {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CustomerTicketService customerTicketService;

	@Test
	public void testGenerateCustomerTicket() throws Exception {
		Long accountId = 100L;
		String orderNumber = "Order00001";		
		
		given(this.customerTicketService.generateCustomerTicket(accountId, orderNumber))
				.willReturn(new CustomerTicket(1L, 100L, "Order00001", "DemoCustomerTicket1", new Date()));

		this.mvc.perform(post("/customers/" + accountId+ "/" + orderNumber).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}