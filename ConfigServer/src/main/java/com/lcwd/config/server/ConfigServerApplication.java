package com.lcwd.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
//	Config Server basically used to store and fetch the commonoly used configurations from github

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
