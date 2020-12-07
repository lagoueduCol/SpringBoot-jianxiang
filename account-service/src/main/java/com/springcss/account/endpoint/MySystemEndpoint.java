package com.springcss.account.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

@Configuration
@Endpoint(id = "mysystem", enableByDefault = true)
public class MySystemEndpoint {

	@ReadOperation
	public Map<String, Object> getMySystemInfo() {
		Map<String, Object> result = new HashMap<>();
		Map<String, String> map = System.getenv();
		result.put("username", map.get("USERNAME"));
		result.put("computername", map.get("COMPUTERNAME"));
		return result;
	}
}
