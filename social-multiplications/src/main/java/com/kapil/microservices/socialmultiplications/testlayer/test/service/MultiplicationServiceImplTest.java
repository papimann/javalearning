package com.kapil.microservices.socialmultiplications.testlayer.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kapil.microservices.socialmultiplications.businesslayer.domain.Multiplication;
import com.kapil.microservices.socialmultiplications.businesslayer.domain.MultiplicationResultAttempt;
import com.kapil.microservices.socialmultiplications.businesslayer.domain.User;
import com.kapil.microservices.socialmultiplications.businesslayer.service.RandomGeneratorService;
import com.kapil.microservices.socialmultiplications.businesslayer.service.impl.MultiplicationServiceImpl;
import com.kapil.microservices.socialmultiplications.datalayer.repository.MultiplicationResultAttemptRepository;
import com.kapil.microservices.socialmultiplications.datalayer.repository.UserRepository;
import com.kapil.microservices.socialmultiplications.event.EventDispatcher;
import com.kapil.microservices.socialmultiplications.event.MultiplicationSolvedEvent;

public class MultiplicationServiceImplTest {

	@Mock
	private RandomGeneratorService randomGeneratorService;

	private MultiplicationServiceImpl multiplicationServiceImpl;

	@Mock
	private MultiplicationResultAttemptRepository attemptRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	private EventDispatcher eventDispatcher;

	@Before
	public void setUp() {
		// With this call to initMocks we tell Mockito to process the annotations
		MockitoAnnotations.initMocks(this);
		multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService, attemptRepository,
				userRepository, eventDispatcher);
	}

	@Test
	public void createRandomMultiplicationTest() {
		// given (our mocked Random Generator service will return first 50, then 30)
		given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);
		// when
		Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();
		// assert
		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
//		assertThat(multiplication.getResult()).isEqualTo(1500);
	}

	@Test
	public void checkCorrectAttemptTest() {
		// given
		Multiplication multiplication = new Multiplication(50, 60);

		User user = new User("john_doe");

		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3000, false);
		MultiplicationResultAttempt verifiedAttempt = new MultiplicationResultAttempt(user, multiplication, 3000, true);

		MultiplicationSolvedEvent event = new MultiplicationSolvedEvent(attempt.getId(), attempt.getUser().getId(),
				true);

		given(userRepository.findByAlias("john_doe")).willReturn(Optional.empty());
		// when
		boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);
		// then
		assertThat(attemptResult).isTrue();

		verify(attemptRepository).save(verifiedAttempt);

		verify(eventDispatcher).send(eq(event));
	}

	@Test
	public void checkWrongAttemptTest() {
		// given
		Multiplication multiplication = new Multiplication(50, 60);

		User user = new User("john_doe");

		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3010, false);

		MultiplicationSolvedEvent event = new MultiplicationSolvedEvent(attempt.getId(), attempt.getUser().getId(),
				false);

		given(userRepository.findByAlias("john_doe")).willReturn(Optional.empty());

		// when
		boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

		// then
		assertThat(attemptResult).isFalse();

		verify(attemptRepository).save(attempt);

		verify(eventDispatcher).send(eq(event));
	}

	@Test
	public void retrieveStatsTest() {
		// given
		Multiplication multiplication = new Multiplication(50, 60);
		User user = new User("john_doe");
		MultiplicationResultAttempt attempt1 = new MultiplicationResultAttempt(user, multiplication, 3010, false);
		MultiplicationResultAttempt attempt2 = new MultiplicationResultAttempt(user, multiplication, 3051, false);
		List<MultiplicationResultAttempt> latestAttempts = Lists.newArrayList(attempt1, attempt2);
		given(userRepository.findByAlias("john_doe")).willReturn(Optional.empty());
		given(attemptRepository.findTop5ByUserAliasOrderByIdDesc("john_doe")).willReturn(latestAttempts);
		// when
		List<MultiplicationResultAttempt> latestAttemptsResult = multiplicationServiceImpl.getStatsForUser("john_doe");
		// then
		assertThat(latestAttemptsResult).isEqualTo(latestAttempts);
	}

}
