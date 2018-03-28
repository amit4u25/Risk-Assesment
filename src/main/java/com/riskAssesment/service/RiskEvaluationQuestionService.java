package com.riskAssesment.service;

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

}
