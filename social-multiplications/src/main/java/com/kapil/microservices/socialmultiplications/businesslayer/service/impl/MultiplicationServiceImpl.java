package com.kapil.microservices.socialmultiplications.businesslayer.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.kapil.microservices.socialmultiplications.businesslayer.domain.Multiplication;
import com.kapil.microservices.socialmultiplications.businesslayer.domain.MultiplicationResultAttempt;
import com.kapil.microservices.socialmultiplications.businesslayer.domain.User;
import com.kapil.microservices.socialmultiplications.businesslayer.service.MultiplicationService;
import com.kapil.microservices.socialmultiplications.businesslayer.service.RandomGeneratorService;
import com.kapil.microservices.socialmultiplications.datalayer.repository.MultiplicationResultAttemptRepository;
import com.kapil.microservices.socialmultiplications.datalayer.repository.UserRepository;
import com.kapil.microservices.socialmultiplications.event.EventDispatcher;
import com.kapil.microservices.socialmultiplications.event.MultiplicationSolvedEvent;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

	private RandomGeneratorService randomGeneratorService;
	private MultiplicationResultAttemptRepository attemptRepository;
	private UserRepository userRepository;
	private EventDispatcher eventDispatcher;

	@Autowired
	public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService,
			final MultiplicationResultAttemptRepository attemptRepository, final UserRepository userRepository,
			final EventDispatcher eventDispatcher) {
		this.randomGeneratorService = randomGeneratorService;
		this.attemptRepository = attemptRepository;
		this.userRepository = userRepository;
		this.eventDispatcher = eventDispatcher;
	}

	@Override
	public Multiplication createRandomMultiplication() {
		int factorA = randomGeneratorService.generateRandomFactor();
		int factorB = randomGeneratorService.generateRandomFactor();
		return new Multiplication(factorA, factorB);
	}

	@Transactional
	@Override
	public boolean checkAttempt(final MultiplicationResultAttempt attempt) {

		// Check if the user already exists for that alias
		Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());

		// Avoids 'hack' attempts
		Assert.isTrue(!attempt.isCorrect(), "You can't send an attempt marked as correct!!");

		// Check if the attempt is correct
		boolean isCorrect = attempt.getResultAttempt() == attempt.getMultiplication().getFactorA()
				* attempt.getMultiplication().getFactorB();

		MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(user.orElse(attempt.getUser()),
				attempt.getMultiplication(), attempt.getResultAttempt(), isCorrect);

		// Stores the attempt
		attemptRepository.save(checkedAttempt);

		// Communicates the result via Event
		eventDispatcher.send(new MultiplicationSolvedEvent(checkedAttempt.getId(), checkedAttempt.getUser().getId(),
				checkedAttempt.isCorrect()));

		// Returns the result
		return isCorrect;
	}

	@Override
	public List<MultiplicationResultAttempt> getStatsForUser(final String userAlias) {
		return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
	}

	@Override
	public MultiplicationResultAttempt getResultById(final long resultId) {
		// TODO Auto-generated method stub
		return attemptRepository.findOne(resultId);
	}

}
