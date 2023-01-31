package com.mb.api.web.configuration;

import java.time.Duration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig
{
	/*
	//name of the method does not matter
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	*/

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	 
		return builder
			.setConnectTimeout(Duration.ofMillis(3000))
			.setReadTimeout(Duration.ofMillis(3000))
			.build();
	}
}
