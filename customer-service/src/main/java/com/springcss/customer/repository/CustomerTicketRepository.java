package com.springcss.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcss.customer.domain.CustomerTicket;

@Repository
public interface CustomerTicketRepository extends JpaRepository<CustomerTicket, Long> {
	
	List<CustomerTicket> getCustomerTicketByOrderNumber(String orderNumber);
}
