package com.lcwd.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class USerserviceApplication {


	public static void main(String[] args) {
		SpringApplication.run(USerserviceApplication.class, args);
	}
	@Bean
	@LoadBalanced //LoadBalance to call the api services by service name like HOTEL-SERVICE
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
