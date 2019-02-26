package com.kapil.microservices.socialmultiplications.event;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Event that models the fact that a {@link Multiplication} has been solved in
 * the system. Provides some context information about the multiplication.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class MultiplicationSolvedEvent implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -285126283048886309L;

	private final Long multiplicationResultAttemptId;
	private final Long userId;
	private final boolean correct;

	// Empty constructor for JSON (de)serialization
	MultiplicationSolvedEvent() {
		this(0L, 0L, false);
	}

}
