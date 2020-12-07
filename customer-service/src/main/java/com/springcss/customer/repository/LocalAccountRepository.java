package com.springcss.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcss.customer.domain.LocalAccount;

@Repository
public interface LocalAccountRepository extends JpaRepository<LocalAccount, Long>{

}
