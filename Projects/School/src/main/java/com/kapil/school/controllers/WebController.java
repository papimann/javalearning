package com.kapil.school.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "welcome";
	}

}
