package com.springcss.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.springcss.order.domain.JpaOrder;

@Repository("orderJpaRepository")
public interface OrderJpaRepository extends JpaRepository<JpaOrder, Long>, 
	JpaSpecificationExecutor<JpaOrder>, QueryByExampleExecutor<JpaOrder> {

	@Query("select o from JpaOrder o where o.orderNumber = ?1")
	JpaOrder getOrderByOrderNumberWithQuery(String orderNumber);

	JpaOrder getOrderByOrderNumber(String orderNumber);

}
