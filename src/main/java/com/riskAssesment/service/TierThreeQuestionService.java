package com.riskAssesment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riskAssesment.model.TierThreeQuestion;
import com.riskAssesment.repository.TierThreeQuestionRepository;

/**
 * 
 * @author MP-29
 *
 */
@Component
public class TierThreeQuestionService {

	@Autowired
	TierThreeQuestionRepository tierThreeQuestionRepository;

	public TierThreeQuestion createQuestion(TierThreeQuestion tierThreeQuestion) {
		return tierThreeQuestionRepository.save(tierThreeQuestion);
	}
}
