package com.springcss.order.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.springcss.order.domain.JpaOrder;
import com.springcss.order.repository.OrderJpaRepository;

@Service
public class JpaOrderService {

	@Autowired
	private OrderJpaRepository orderJpaRepository;

	public JpaOrder getOrderById(Long orderId) {

		return orderJpaRepository.getOne(orderId);
	}

	public JpaOrder getOrderByOrderNumber(String orderNumber) {

		return orderJpaRepository.getOrderByOrderNumber(orderNumber);
	}

	public JpaOrder getOrderByOrderNumberWithQuery(String orderNumber) {

		return orderJpaRepository.getOrderByOrderNumberWithQuery(orderNumber);
	}

	public JpaOrder getOrderByOrderNumberByExample(String orderNumber) {
		JpaOrder order = new JpaOrder();
		order.setOrderNumber(orderNumber);

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
				.withMatcher("orderNumber", GenericPropertyMatchers.exact()).withIncludeNullValues();

		Example<JpaOrder> example = Example.of(order, matcher);

		return orderJpaRepository.findOne(example).orElse(new JpaOrder());
	}
	
	public JpaOrder getOrderByOrderNumberBySpecification(String orderNumber) {
		JpaOrder order = new JpaOrder();
		order.setOrderNumber(orderNumber);

		@SuppressWarnings("serial")
		Specification<JpaOrder> spec = new Specification<JpaOrder>() {
            @Override
            public Predicate toPredicate(Root<JpaOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> orderNumberPath = root.get("orderNumber");
              
                Predicate predicate = cb.equal(orderNumberPath, orderNumber);
                return predicate;
            }
        };

		return orderJpaRepository.findOne(spec).orElse(new JpaOrder());		
	}

	public JpaOrder addOrder(JpaOrder order) {

		return orderJpaRepository.save(order);
	}

}
