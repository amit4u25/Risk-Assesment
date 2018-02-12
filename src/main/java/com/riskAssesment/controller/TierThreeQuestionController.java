package com.riskAssesment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riskAssesment.model.TierThreeQuestion;
import com.riskAssesment.service.TierThreeQuestionService;

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
@RequestMapping("/tierThreeQuestion")
public class TierThreeQuestionController {

	@Autowired
	TierThreeQuestionService tierThreeQuestionService;

	@PostMapping("/create")
	// The @Valid annotation makes sure that the request body is valid.
	public TierThreeQuestion createQuestion(@Valid @RequestBody TierThreeQuestion tierThreeQuestion) {
		return tierThreeQuestionService.createQuestion(tierThreeQuestion);
	}

}
