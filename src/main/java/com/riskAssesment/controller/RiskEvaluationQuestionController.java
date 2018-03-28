package com.riskAssesment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riskAssesment.model.RiskEvaluationQuestion;
import com.riskAssesment.service.RiskEvaluationQuestionService;


@RestController
@CrossOrigin
@RequestMapping("/tierQuestion")
public class RiskEvaluationQuestionController {

	@Autowired
	RiskEvaluationQuestionService riskEvaluationQuestionService;

	@PostMapping("/create")
	// The @Valid annotation makes sure that the request body is valid.
	public RiskEvaluationQuestion createMaintenanceType(@Valid @RequestBody RiskEvaluationQuestion riskEvaluationQuestion) {
		return riskEvaluationQuestionService.createQuestion(riskEvaluationQuestion);
	}

}
