package com.riskAssesment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riskAssesment.model.RiskEvaluationQuestion;
import com.riskAssesment.repository.RiskEvaluationQuestionRepository;

@Component
public class RiskEvaluationQuestionService {

	@Autowired
	RiskEvaluationQuestionRepository riskEvaluationQuestionRepository;

	public RiskEvaluationQuestion createQuestion(RiskEvaluationQuestion riskEvaluationQuestion) {
		return riskEvaluationQuestionRepository.save(riskEvaluationQuestion);
	}
	
	public List<RiskEvaluationQuestion> getAllTierQuestion() {
		return riskEvaluationQuestionRepository.findAll();
	}

}
