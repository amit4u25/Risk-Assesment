package com.riskAssesment.controller;

import com.riskAssesment.model.Employee;
import com.riskAssesment.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 
 * @author MP-29
 * @RestController annotation is a combination of Spring’s @Controller and @ResponseBody annotations.
 * The @Controller annotation is used to define a controller and the @ResponseBody annotation is used to 
 * indicate that the return value of a method should be used as the response body of the request.
 * @RequestMapping("/api") declares that the url for all the apis in this controller will start with /api
 **/
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@PostMapping("/employee")
	//The @Valid annotation makes sure that the request body is valid. 
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) {
		return employeeService.updateEmployee(employeeId, employeeDetails);
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
}
