package com.springcss.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcss.customer.domain.CustomerTicket;
import com.springcss.customer.repository.CustomerTicketRepository;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CustomerTicketRepository customerTicketRepository;

	@Test
	public void testFindCustomerTicketById() throws Exception {				
		this.entityManager.persist(new CustomerTicket(1L, "Order00001", "DemoCustomerTicket1", new Date()));
		
		CustomerTicket customerTicket = this.customerTicketRepository.getOne(1L);
		assertThat(customerTicket).isNotNull();
		assertThat(customerTicket.getId()).isEqualTo(1L);
	}
	
	@Test
	public void testFindCustomerTicketByOrderNumber() throws Exception {	
		String orderNumber = "Order00001";
		
		this.entityManager.persist(new CustomerTicket(1L, orderNumber, "DemoCustomerTicket1", new Date()));
		this.entityManager.persist(new CustomerTicket(2L, orderNumber, "DemoCustomerTicket2", new Date()));
		
		List<CustomerTicket> customerTickets = this.customerTicketRepository.getCustomerTicketByOrderNumber(orderNumber);
		assertThat(customerTickets).size().isEqualTo(2);
		CustomerTicket actual = customerTickets.get(0);
		assertThat(actual.getOrderNumber()).isEqualTo(orderNumber);
	}

	@Test
	public void testFindCustomerTicketByNonExistedOrderNumber() throws Exception {				
		this.entityManager.persist(new CustomerTicket(1L, "Order00001", "DemoCustomerTicket1", new Date()));
		this.entityManager.persist(new CustomerTicket(2L, "Order00002", "DemoCustomerTicket2", new Date()));
		
		List<CustomerTicket> customerTickets = this.customerTicketRepository.getCustomerTicketByOrderNumber("Order00003");
		assertThat(customerTickets).size().isEqualTo(0);
	}
}
