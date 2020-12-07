package com.springcss.account.security;

import org.springframework.data.repository.CrudRepository;

public interface SpringCssUserRepository extends CrudRepository<SpringCssUser, Long> {
  	
	SpringCssUser findByUsername(String username);  
}
