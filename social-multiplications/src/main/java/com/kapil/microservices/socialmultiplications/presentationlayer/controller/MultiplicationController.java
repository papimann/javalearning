/**
 *
 */
package com.kapil.microservices.socialmultiplications.presentationlayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.microservices.socialmultiplications.businesslayer.domain.Multiplication;
import com.kapil.microservices.socialmultiplications.businesslayer.service.MultiplicationService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kapil.arora
 *
 *         Controller for multiplications domain
 *
 */
@Slf4j
@RestController
@RequestMapping("/multiplications")
final public class MultiplicationController {

	private final MultiplicationService multiplicationService;

	private final int serverPort;

	@Autowired
	public MultiplicationController(final MultiplicationService multiplicationService, @Value("${server.port}") int serverPort) {
		this.multiplicationService = multiplicationService;
		this.serverPort = serverPort;
	}

	@GetMapping("/random")
	Multiplication getRandomMultiplication() {
		log.info("Generating a random multiplication from server @ {}", serverPort);
		return multiplicationService.createRandomMultiplication();
	}

}
