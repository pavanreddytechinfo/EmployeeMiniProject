package com.employee.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.tech.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
