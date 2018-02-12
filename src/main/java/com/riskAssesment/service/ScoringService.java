package com.riskAssesment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.riskAssesment.model.AllQuestionAnswer;
import com.riskAssesment.model.RiskEvaluation;
import com.riskAssesment.model.TestResult;
import com.riskAssesment.model.TierThreeQuestion;
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
	RiskEvalutionRepository riskEvalutionRepository;

	public TestResult calculateRiskScore(List<AllQuestionAnswer> allQuestionsAnswers) {
		double riskScore = 0.0;
		long numberOfQuestion = 0;
		double averageRiskScore = 0.0;
		String riskAssesed = null;
		RiskEvaluation riskEvaluation = new RiskEvaluation();
		TestResult testResult = new TestResult();
		for (AllQuestionAnswer allQuestionAnswer : allQuestionsAnswers) {

			if (!StringUtils.isEmpty(allQuestionAnswer.getBap())) {
				riskEvaluation.setBap(allQuestionAnswer.getBap());
			}

			if (!StringUtils.isEmpty(allQuestionAnswer.getReleaseVersion())) {
				riskEvaluation.setReleaseVersion(allQuestionAnswer.getReleaseVersion());
			}

			if (allQuestionAnswer.getAnswer()) {
				TierThreeQuestion tierThreeQuestion = tierThreeQuestionRepository
						.findOne(allQuestionAnswer.getQuestionId());
				riskScore = riskScore + tierThreeQuestion.getWeight();
			} else {
				riskScore = riskScore + 1;
			}
			numberOfQuestion++;
		}
		averageRiskScore = riskScore / numberOfQuestion;
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
		riskEvalutionRepository.save(riskEvaluation);

		// Set return response
		testResult.setScore(averageRiskScore);
		testResult.setRiskcategory(riskAssesed);
		return testResult;
	}
}
