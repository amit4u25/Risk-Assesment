package com.riskAssesment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riskAssesment.model.AllQuestionAnswer;
import com.riskAssesment.model.RiskEvaluation;
import com.riskAssesment.model.TestResult;
import com.riskAssesment.service.ScoringService;

/**
 * 
 * @author MP-29
 * @RestController annotation is a combination of Spring’s @Controller
 *                 and @ResponseBody annotations. The @Controller annotation is
 *                 used to define a controller and the @ResponseBody annotation
 *                 is used to indicate that the return value of a method should
 *                 be used as the response body of the
 *                 request. @RequestMapping("/api") declares that the url for
 *                 all the apis in this controller will start with /api
 **/
@RestController
@CrossOrigin
@RequestMapping("/score")
public class ScoringController {

	@Autowired
	ScoringService scoringService;

	@PostMapping("/evaluate")
	// The @Valid annotation makes sure that the request body is valid.
	public TestResult calculatRiskScore(@Valid @RequestBody AllQuestionAnswer allQuestionAnswers) {
		return scoringService.calculateRiskScore(allQuestionAnswers);
	}

	@GetMapping("/all")
	public List<RiskEvaluation> getAllTestResult() {
		return scoringService.getAllTestResult();
	}

	@GetMapping("/{bap}")
	public List<RiskEvaluation> getByBap(@PathVariable("bap") String bap) {
		return scoringService.getByBap(bap);
	}

}
