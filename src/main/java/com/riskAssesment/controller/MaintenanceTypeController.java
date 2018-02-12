package com.riskAssesment.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riskAssesment.model.MaintenanceType;
import com.riskAssesment.model.TierTwoQuestion;
import com.riskAssesment.service.MaintenanceTypeService;

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
@RequestMapping("/maintenance")
public class MaintenanceTypeController {

	@Autowired
	MaintenanceTypeService maintenanceTypeService;

	@PostMapping("/create")
	// The @Valid annotation makes sure that the request body is valid.
	public MaintenanceType createMaintenanceType(@Valid @RequestBody MaintenanceType maintenanceType) {
		return maintenanceTypeService.createMaintenanceType(maintenanceType);
	}

	@GetMapping("/all")
	public List<MaintenanceType> getAllMaintenanceType() {
		List<MaintenanceType> abc = maintenanceTypeService.getAllMaintenanceType();
//		for (MaintenanceType maintenanceType : abc) {
//			System.out.println("maintenanceType :" + maintenanceType.getChangeType());
//			Set<TierTwoQuestion> dfdf = maintenanceType.getTierTwoQuestion();
//			for (TierTwoQuestion fgfg : dfdf) {
//				System.out.println("fgfg :" + fgfg.getQuestion());
//
//			}
//		}
		 return maintenanceTypeService.getAllMaintenanceType();
	}
}
