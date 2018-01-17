package com.junli.springclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringclouddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringclouddemoApplication.class, args);
	}
}
