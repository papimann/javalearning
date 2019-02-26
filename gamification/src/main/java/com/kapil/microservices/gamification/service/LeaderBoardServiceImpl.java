package com.kapil.microservices.gamification.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kapil.microservices.gamification.domain.LeaderBoardRow;
import com.kapil.microservices.gamification.repository.ScoreCardRepository;

@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {

	private ScoreCardRepository scoreCardRepository;

	public LeaderBoardServiceImpl(final ScoreCardRepository scoreCardRepository) {
		this.scoreCardRepository = scoreCardRepository;
	}

	@Override
	public List<LeaderBoardRow> getCurrentLeaderBoard() {
		return scoreCardRepository.findFirst10();
	}

}
