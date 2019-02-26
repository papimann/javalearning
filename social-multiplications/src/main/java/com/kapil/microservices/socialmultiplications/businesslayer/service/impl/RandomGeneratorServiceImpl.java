package com.kapil.microservices.socialmultiplications.businesslayer.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.kapil.microservices.socialmultiplications.businesslayer.service.RandomGeneratorService;

@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService {

	final static int MINIMUM_FACTOR = 11;
	final static int MAXIMUM_FACTOR = 99;

	@Override
	public int generateRandomFactor() {
		return new Random().nextInt((MAXIMUM_FACTOR - MINIMUM_FACTOR) + 1) + MINIMUM_FACTOR;
	}

}
