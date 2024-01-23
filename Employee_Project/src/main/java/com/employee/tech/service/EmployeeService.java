package com.employee.tech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.tech.model.Employee;

@Service
public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public String deleteEmployee(Long id);
	public Employee getEmployee(Long id);
	public List<Employee> getAllEmployee();

}
