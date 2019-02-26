package com.kapil.microservices.socialmultiplications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SocialMultiplicationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMultiplicationsApplication.class, args);
	}

}

