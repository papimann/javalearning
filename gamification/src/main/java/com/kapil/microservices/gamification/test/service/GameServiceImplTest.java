/**
 *
 */
package com.kapil.microservices.gamification.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kapil.microservices.gamification.client.MultiplicationResultAttemptClient;
import com.kapil.microservices.gamification.client.dto.MultiplicationResultAttempt;
import com.kapil.microservices.gamification.domain.GameStats;
import com.kapil.microservices.gamification.domain.ScoreCard;
import com.kapil.microservices.gamification.enums.Badge;
import com.kapil.microservices.gamification.repository.BadgeCardRepository;
import com.kapil.microservices.gamification.repository.ScoreCardRepository;
import com.kapil.microservices.gamification.service.GameServiceImpl;

/**
 * @author kapil.arora
 *
 */
public class GameServiceImplTest {

	private GameServiceImpl gameService;

	@Mock
	private ScoreCardRepository scoreCardRepository;

	@Mock
	private BadgeCardRepository badgeCardRepository;

	@Mock
	private MultiplicationResultAttemptClient multiplicationClient;

	@Before
	public void setUp() {
		// With this call to initMocks we tell Mockito to process the annotations
		MockitoAnnotations.initMocks(this);
		gameService = new GameServiceImpl(scoreCardRepository, badgeCardRepository, multiplicationClient);

		// Common given - attempt does not contain a lucky number by default
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt("john_doe", 20, 70, 1400, true);
		given(multiplicationClient.retrieveMultiplicationResultAttemptbyId(anyLong())).willReturn(attempt);
	}

	@Test
	public void processFirstCorrectAttemptTest() {
		// given
		Long userId = 1L;
		Long attemptId = 8L;
		int totalScore = 10;
		ScoreCard scoreCard = new ScoreCard(userId, attemptId);
		given(scoreCardRepository.getTotalScoreForUser(userId)).willReturn(totalScore);
		// this repository will return the just-won score card
		given(scoreCardRepository.findByUserIdOrderByScoreTimestampDesc(userId))
				.willReturn(Collections.singletonList(scoreCard));
		given(badgeCardRepository.findByUserIdOrderByBadgeTimestampDesc(userId)).willReturn(Collections.emptyList());

		// when
		GameStats iteration = gameService.newAttemptForUser(userId, attemptId, true);

		// assert - should score one card and win the badge FIRST_WON
		assertThat(iteration.getScore()).isEqualTo(scoreCard.getScore());
		assertThat(iteration.getBadges()).containsOnly(Badge.FIRST_WON);
	}

}
