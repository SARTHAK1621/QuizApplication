package com.sarthak.ServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SreviceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SreviceRegistryApplication.class, args);
	}

}