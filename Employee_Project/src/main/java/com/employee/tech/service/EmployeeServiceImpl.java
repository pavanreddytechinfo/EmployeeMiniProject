package com.employee.tech.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.tech.model.Employee;
import com.employee.tech.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		employee.setCreatedBy("HR");
		employee.setCreatedSource("saveEmployee()");
		employee.setCreatedTime(new Date());
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> optionalExistingEmployee = employeeRepository.findById(employee.getId());
		if (optionalExistingEmployee != null) {
			Employee existingEmployee = optionalExistingEmployee.get();
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setPosition(employee.getPosition());
			existingEmployee.setSalary(employee.getSalary());
			existingEmployee.setUpdatedBy("HR");
			existingEmployee.setUpdatedSource("updateEmployee()");
			existingEmployee.setUpdatedTime(new Date());
			return employeeRepository.save(existingEmployee);
		} else {
			throw new EntityNotFoundException("Employee with ID " + employee.getId() + " not found");
		}
	}

	@Override
	public String deleteEmployee(Long id) {
		Optional<Employee> optionalExistingEmployee = employeeRepository.findById(id);
		if (optionalExistingEmployee != null) {
			employeeRepository.deleteById(id);
			return "Employee with ID " + id + " deleted successfully.";
		} else {
			return "Employee with ID " + id + " not found.";
		}
	}

	@Override
	public Employee getEmployee(Long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		} else {
			throw new EntityNotFoundException("Employee with ID " + id + " not found");
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
