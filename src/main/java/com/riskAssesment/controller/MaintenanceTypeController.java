package com.riskAssesment.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.riskAssesment.model.MaintenanceType;
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
	final static Logger logger = Logger.getLogger(MaintenanceTypeController.class);

	@Autowired
	MaintenanceTypeService maintenanceTypeService;

	@PostMapping("/create")
	// The @Valid annotation makes sure that the request body is valid.
	public MaintenanceType createMaintenanceType(@Valid @RequestBody MaintenanceType maintenanceType) {
		return maintenanceTypeService.createMaintenanceType(maintenanceType);
	}

	@GetMapping("/all")
	public List<MaintenanceType> getAllMaintenanceType() {
		System.out.println("Hiii..");
		logger.debug("Found maintenanceType:: ");
		return maintenanceTypeService.getAllMaintenanceType();
	}
	
	/**
	 * Get the MaintenanceType by ID
	 * 
	 * @param id of MaintenanceType
	 * @return MaintenanceType
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MaintenanceType> getMaintenanceType(@PathVariable("id") Long id) {
		MaintenanceType maintenanceType = maintenanceTypeService.getById(id);
		if (maintenanceType == null) {
			logger.debug("MaintenanceType with id " + id + " does not exists");
			return new ResponseEntity<MaintenanceType>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found maintenanceType:: " + maintenanceType);
		return new ResponseEntity<MaintenanceType>(maintenanceType, HttpStatus.OK);
	}
}
