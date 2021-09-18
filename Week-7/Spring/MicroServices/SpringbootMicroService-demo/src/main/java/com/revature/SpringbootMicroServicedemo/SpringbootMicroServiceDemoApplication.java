package com.revature.SpringbootMicroServicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootMicroServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroServiceDemoApplication.class, args);
	}

}
