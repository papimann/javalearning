package com.shkp.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SHKPSchool {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SHKPSchool.class);
		app.run(args);
	}

}
