package com.kapil.microservices.gamification.event;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class MultiplicationSolvedEvent implements Serializable {
	/**
	*
	*/
	private static final long serialVersionUID = 2775081171954926848L;

	private final Long multiplicationResultAttemptId;
	private final Long userId;
	private final boolean correct;

	// Empty constructor for JSON (de)serialization
	MultiplicationSolvedEvent() {
		this(0L, 0L, false);
	}

}
