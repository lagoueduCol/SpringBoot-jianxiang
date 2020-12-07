package com.springcss.account.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.context.annotation.Configuration;

import com.springcss.account.repository.AccountRepository;

@Configuration
@Endpoint(id = "account", enableByDefault = true)
public class AccountEndpoint {
	
	@Autowired
	private AccountRepository accountRepository;	

	@ReadOperation
	public Map<String, Object> getMySystemInfo(@Selector String accountName) {
		Map<String, Object> result = new HashMap<>();
		result.put(accountName, accountRepository.findAccountByAccountName(accountName));
		return result;
	}
}
