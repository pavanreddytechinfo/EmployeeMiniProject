package com.employee.tech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.tech.model.Employee;
import com.employee.tech.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/createEmployees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		Employee savedEmployee = employeeService.saveEmployee(emp);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
		emp.setId(id); // Ensure the ID in the path and the ID in the request body match
		Employee updatedEmployee = employeeService.updateEmployee(emp);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		String result = employeeService.deleteEmployee(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		Employee employee = employeeService.getEmployee(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployee();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

}
