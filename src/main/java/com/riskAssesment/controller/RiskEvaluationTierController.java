package com.riskAssesment.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riskAssesment.model.RiskEvaluationTier;
import com.riskAssesment.service.RiskEvaluationTierService;;


@RestController
@CrossOrigin
@RequestMapping("/tier")
public class RiskEvaluationTierController {
	final static Logger logger = Logger.getLogger(RiskEvaluationTierController.class);

	@Autowired
	RiskEvaluationTierService riskEvaluationTierService;

	@PostMapping("/create")
	// The @Valid annotation makes sure that the request body is valid.
	public RiskEvaluationTier createTier(@Valid @RequestBody RiskEvaluationTier riskEvaluationTier) {
		return riskEvaluationTierService.createRiskEvaluationTier(riskEvaluationTier);
	}

	@GetMapping("/all")
	public List<RiskEvaluationTier> getAllTier() {
		return riskEvaluationTierService.getAllRiskEvaluationTier();
	}
}
