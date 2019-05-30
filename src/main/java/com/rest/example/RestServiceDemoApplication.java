package com.rest.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.rest.example.model" })
@EnableJpaRepositories(basePackages = { "com.rest.example.repository"})
public class RestServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceDemoApplication.class, args);
	}

}
