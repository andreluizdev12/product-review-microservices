package com.github.andreluizdev12.product_with_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProductWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductWithSpringApplication.class, args);
	}

}
