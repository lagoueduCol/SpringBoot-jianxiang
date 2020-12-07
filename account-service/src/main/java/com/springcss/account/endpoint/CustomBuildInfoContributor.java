package com.springcss.account.endpoint;

import java.util.Collections;
import java.util.Date;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomBuildInfoContributor implements InfoContributor {
 
	@Override
	public void contribute(Builder builder) {
		builder.withDetail("build", 
			Collections.singletonMap("timestamp", new Date()));	
	}
}
