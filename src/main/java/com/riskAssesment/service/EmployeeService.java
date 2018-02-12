package com.riskAssesment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.riskAssesment.model.Employee;
import com.riskAssesment.repository.EmployeeRepository;

/**
 * 
 * @author MP-29
 *
 */
@Component
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	/**
	 * getAllEmployees() calls JpaRepository’s findAll() method to retrieve all the employees from 
	 * the database and returns the entire list.
	 * @return List<Employee>
	 */
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	/**
	 * In the getEmployeeById(), we are returning a ResponseEntity<Employee> instead of Employee. 
	 * The ResponseEntity class gives us more flexibility while returning a response from the api.
	 * @param employeeId
	 * @return ResponseEntity<Employee>
	 */
	public ResponseEntity<Employee> getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findOne(employeeId);
		if (employee == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(employee);
	}
	
	/**
	 * createEmployee() method uses the save() method to save the data in the database. 
	 * @param employee
	 * @return
	 */
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	/**
	 * updateEmployee() method uses the save() method to update the data in the database.
	 * @param employeeId
	 * @param employeeDetails
	 * @return
	 */
	public ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employeeDetails) {
		Employee employee = employeeRepository.findOne(employeeId);
		if (employee == null) {
			return ResponseEntity.notFound().build();
		}
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());

		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	/**
	 * deleteEmployee() uses the delete() method to delete the data();
	 * @param employeeId
	 * @return
	 */
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
		Employee note = employeeRepository.findOne(employeeId);
		if (note == null) {
			return ResponseEntity.notFound().build();
		}

		employeeRepository.delete(note);
		return ResponseEntity.ok().build();
	}

}
