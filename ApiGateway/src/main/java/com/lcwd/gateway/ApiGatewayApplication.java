package com.lcwd.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

//	For Api Gateway implementition when even a request comes to a pariticular port it will redirct it
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->
						r.path("/users/**") //It is for url pattern that will be accessable api api gateway
						.uri("lb://USER-SERVICE")) //USER-SERVICE is the name of the service
				.route(r->
						r.path("/hotels/**")
						.uri("lb://HOTEL-SERVICE"))
				.route(r->
						r.path("/ratings/**")
								.uri("lb://RATING-SERVICE"))
				.build();
	}


}
