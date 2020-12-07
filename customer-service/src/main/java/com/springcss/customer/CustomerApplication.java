package com.springcss.customer;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
public class CustomerApplication {


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
//	@Bean
//	public RestTemplate restTemplate() {
//		// return new RestTemplate();
//
////		RestTemplate restTemplate = new RestTemplate();
//		// 获取RestTemplate默认配置好的所有转换器
////		List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
////		// 默认的MappingJackson2HttpMessageConverter在第7个 先把它移除掉
////		messageConverters.remove(6);
////		// 添加上GSON的转换器
////		messageConverters.add(6, new GsonHttpMessageConverter());
//		
//		
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//		messageConverters.add(new GsonHttpMessageConverter());
//		RestTemplate restTemplate = new RestTemplate(messageConverters);	
//		return restTemplate;
//	}
//
//
//	@Bean
//	public RestTemplate customRestTemplate() {
//		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//		httpRequestFactory.setConnectionRequestTimeout(3000);
//		httpRequestFactory.setConnectTimeout(3000);
//		httpRequestFactory.setReadTimeout(3000);
//
//		return new RestTemplate(httpRequestFactory);
//	}
	

//	@Bean
//	public MeterRegistryCustomizer<MeterRegistry> meterRegistryCustomizer() {
//		return registry -> registry.config().commonTags("tag1", "a", "tag2", "b");
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}
