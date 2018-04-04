package com.riskAssesment.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.riskAssesment.model.AllQuestionAnswer;
import com.riskAssesment.model.QuestionAnswer;
import com.riskAssesment.model.RiskEvaluation;
import com.riskAssesment.model.RiskEvaluationQuestion;
import com.riskAssesment.model.RiskEvaluationQuestionAnswer;
import com.riskAssesment.model.TestResult;
import com.riskAssesment.repository.RiskEvaluationQuestionAnswerRepository;
import com.riskAssesment.repository.RiskEvaluationQuestionRepository;
import com.riskAssesment.repository.RiskEvalutionRepository;
import com.riskAssesment.repository.TierThreeQuestionRepository;

/**
 * 
 * @author MP-29
 *
 */
@Component
public class ScoringService {

	@Autowired
	TierThreeQuestionRepository tierThreeQuestionRepository;
	@Autowired
	RiskEvaluationQuestionAnswerRepository riskEvaluationQuestionAnswerRepository;
	@Autowired
	RiskEvaluationQuestionRepository riskEvaluationQuestionRepository;
	@Autowired
	RiskEvalutionRepository riskEvalutionRepository;

	public TestResult calculateRiskScore(AllQuestionAnswer allQuestionsAnswer) {
		double riskScore = 0.0;
		long numberOfQuestion = 0;
		double averageRiskScore = 0.0;
		String riskAssesed = null;
		RiskEvaluation riskEvaluation = new RiskEvaluation();

		TestResult testResult = new TestResult();
		if (!StringUtils.isEmpty(allQuestionsAnswer.getBap())) {
			riskEvaluation.setBap(allQuestionsAnswer.getBap());
			testResult.setBap(allQuestionsAnswer.getBap());
		}

		if (!StringUtils.isEmpty(allQuestionsAnswer.getReleaseVersion())) {
			riskEvaluation.setReleaseVersion(allQuestionsAnswer.getReleaseVersion());
			testResult.setReleaseVersion(allQuestionsAnswer.getReleaseVersion());
		}
		List<QuestionAnswer> returnQuestionAndAnswers = new LinkedList<QuestionAnswer>();
		for (QuestionAnswer questionAnswer : allQuestionsAnswer.getQuestionAnswer()) {
			QuestionAnswer returnQuestionAndAnswer = new QuestionAnswer();
			RiskEvaluationQuestionAnswer riskEvaluationQuestionAnswer = new RiskEvaluationQuestionAnswer();
			riskEvaluationQuestionAnswer.setBapId(allQuestionsAnswer.getBap());
			riskEvaluationQuestionAnswer.setQuestionId(questionAnswer.getQuestionId());
			riskEvaluationQuestionAnswer.setAnswer(questionAnswer.getAnswer());

			RiskEvaluationQuestion riskEvaluationQuestion = riskEvaluationQuestionRepository
					.findOne(questionAnswer.getQuestionId());
			returnQuestionAndAnswer.setQuestionId(questionAnswer.getQuestionId());
			returnQuestionAndAnswer.setQuestion(riskEvaluationQuestion.getQuestion());
			returnQuestionAndAnswer.setAnswer(questionAnswer.getAnswer());
			if (questionAnswer.getAnswer()) {

				System.out.println("Weight : " + riskEvaluationQuestion.getWeight());
				riskScore = riskScore + riskEvaluationQuestion.getWeight();
				numberOfQuestion++;
			}
			riskEvaluationQuestionAnswerRepository.save(riskEvaluationQuestionAnswer);
			returnQuestionAndAnswers.add(returnQuestionAndAnswer);

		}
		if (riskScore > 0.0) {
			averageRiskScore = riskScore / numberOfQuestion;
		}
		riskEvaluation.setRiskScore(averageRiskScore);

		if (averageRiskScore <= 1) {
			riskAssesed = "Low";
			testResult.setPerformanceTestingRequired(false);
		} else if (averageRiskScore <= 2) {
			riskAssesed = "Medium";
			testResult.setPerformanceTestingRequired(true);
		} else {
			riskAssesed = "High";
			testResult.setPerformanceTestingRequired(true);
		}
		riskEvaluation.setRiskAssesed(riskAssesed);
		// Save
		riskEvalutionRepository.save(riskEvaluation);

		// Set return response
		testResult.setScore(averageRiskScore);
		testResult.setRiskcategory(riskAssesed);
		testResult.setQuestionAnswer(returnQuestionAndAnswers);
		return testResult;
	}

	/*
	 * Get all test result
	 */
	public List<RiskEvaluation> getAllTestResult() {
		return riskEvalutionRepository.findAll();
	}

	public RiskEvaluation getByBap(String bap) {
		return riskEvalutionRepository.findByBap(bap);
	}
}
