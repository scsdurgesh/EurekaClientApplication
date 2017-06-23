package com.example.demo;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*Registry Aware HTTP Client*/


@Configuration
public class ConfigClass {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplet()
	{
		return new RestTemplate(); 
	}
}
