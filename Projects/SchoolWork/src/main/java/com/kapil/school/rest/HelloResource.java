package com.kapil.school.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {

	@GetMapping("/all")
	public String hello() {
		return "Hello All";
	}

	@Secured({ "ADMIN" })
	@GetMapping("/secured/all")
	public String securedHello() {
		return "Secured Hello";
	}

}
