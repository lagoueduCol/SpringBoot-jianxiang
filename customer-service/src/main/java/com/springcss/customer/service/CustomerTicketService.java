package com.springcss.customer.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springcss.customer.client.OrderClient;
import com.springcss.customer.client.OrderMapper;
import com.springcss.customer.domain.LocalAccount;
import com.springcss.customer.metrics.CounterService;
import com.springcss.customer.domain.CustomerTicket;
import com.springcss.customer.repository.CustomerTicketRepository;
import com.springcss.customer.repository.LocalAccountRepository;

import io.micrometer.core.instrument.MeterRegistry;

@Service
public class CustomerTicketService {

	@Autowired
	private CustomerTicketRepository customerTicketRepository;

	@Autowired
	private LocalAccountRepository localAccountRepository;

	@Autowired
	private OrderClient orderClient;
	
//	@Autowired
//	private CounterService customerTicketCounterService;
	
	@Autowired
	private MeterRegistry meterRegistry;

	private static final Logger logger = LoggerFactory.getLogger(CustomerTicketService.class);

	private OrderMapper getRemoteOrderByOrderNumber(String orderNumber) {

		return orderClient.getOrderByOrderNumber(orderNumber);
	}

	public CustomerTicket generateCustomerTicket(Long accountId, String orderNumber) {

		logger.debug("Generate customer ticket record with account: {} and order: {}", accountId, orderNumber);

		CustomerTicket customerTicket = new CustomerTicket();

		// 从本地数据库中获取Account信息
		LocalAccount account = getAccountById(accountId);
		if (account != null) {
			return customerTicket;
		}

		// 从远程order-service中获取Order信息
		OrderMapper order = getRemoteOrderByOrderNumber(orderNumber);
		if (order == null) {
			return customerTicket;
		}
		logger.debug("Get remote order: {} is successful", orderNumber);

		// 创建并保存CustomerTicket信息
		customerTicket.setAccountId(accountId);
		customerTicket.setOrderNumber(order.getOrderNumber());
		customerTicket.setCreateTime(new Date());
		customerTicket.setDescription("TestCustomerTicket");
		customerTicketRepository.save(customerTicket);

		// 添加Metrics
//		customerTicketCounterService.counter("customerTicket.created.count");
		meterRegistry.summary("customerTickets.generated.count").record(1);
		
		return customerTicket;
	}

	public List<CustomerTicket> getCustomerTickets(int pageIndex, int pageSize) {

		return customerTicketRepository.findAll(PageRequest.of(pageIndex - 1, pageSize, Sort.DEFAULT_DIRECTION))
				.getContent();
	}

	public CustomerTicket getCustomerTicketById(Long id) {
		return customerTicketRepository.getOne(id);
	}
	
	public void deleteCustomerTicket(Long id) {
		customerTicketRepository.deleteById(id);
	}

	private LocalAccount getAccountById(Long accountId) {
		return localAccountRepository.getOne(accountId);
	}
}
