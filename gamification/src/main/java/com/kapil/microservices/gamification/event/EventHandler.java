package com.kapil.microservices.gamification.event;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.kapil.microservices.gamification.service.GameService;

import lombok.extern.slf4j.Slf4j;

/**
 * This class receives the events and triggers the associated business logic.
 */
@Slf4j
@Component
public class EventHandler {
	private GameService gameService;

	EventHandler(final GameService gameService) {
		this.gameService = gameService;
	}

	@RabbitListener(queues = "${multiplication.queue}")
	void handleMultiplicationSolved(final MultiplicationSolvedEvent event) {
		log.info("Multiplication Solved Event received: {}", event.getMultiplicationResultAttemptId());
		System.out.println("Hiiiii");
		try {
			gameService.newAttemptForUser(event.getUserId(), event.getMultiplicationResultAttemptId(),
					event.isCorrect());
		} catch (final Exception e) {
			log.error("Error when trying to process MultiplicationSolvedEvent", e);
			// Avoids the event to be re-queued and reprocessed.
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}
}
