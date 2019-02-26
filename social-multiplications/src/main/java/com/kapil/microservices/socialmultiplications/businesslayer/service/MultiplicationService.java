package com.kapil.microservices.socialmultiplications.businesslayer.service;

import java.util.List;

import com.kapil.microservices.socialmultiplications.businesslayer.domain.Multiplication;
import com.kapil.microservices.socialmultiplications.businesslayer.domain.MultiplicationResultAttempt;

public interface MultiplicationService {

	/**
	 * Generates a random {@link Multiplication} object.
	 *
	 * @return a multiplication of randomly generated numbers
	 */
	Multiplication createRandomMultiplication();

	/**
	 * @return true if the attempt matches the result of the multiplication, false
	 *         otherwise.
	 */
	boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

	/**
	 * @return last 5 attempts of the users
	 */
	List<MultiplicationResultAttempt> getStatsForUser(final String userAlias);

	/**
	 * @return attempt by id
	 */
	MultiplicationResultAttempt getResultById(final long resultId);
}
