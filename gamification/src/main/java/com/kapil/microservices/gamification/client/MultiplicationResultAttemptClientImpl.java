package com.kapil.microservices.gamification.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.kapil.microservices.gamification.client.dto.MultiplicationResultAttempt;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class MultiplicationResultAttemptClientImpl implements MultiplicationResultAttemptClient {

	private final RestTemplate restTemplate;
	private final String multiplicationHost;

	@Autowired
	public MultiplicationResultAttemptClientImpl(final RestTemplate restTemplate,
			@Value("${multiplicationHost}") final String multiplicationHost) {
		this.restTemplate = restTemplate;
		this.multiplicationHost = multiplicationHost;
	}

	@Override
	@HystrixCommand(fallbackMethod = "defaultResult")
	public MultiplicationResultAttempt retrieveMultiplicationResultAttemptbyId(final Long multiplicationId) {
		return restTemplate.getForObject(multiplicationHost + "/results/" + multiplicationId,
				MultiplicationResultAttempt.class);
	}

}
