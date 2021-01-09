package org.prac.services;

import java.util.List;

import org.prac.dao.EmployeeJdbcTemplate;
import org.prac.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeJdbcTemplate employeeJdbcTemplate;

	public List<Employee> getEmployees() {
		return this.employeeJdbcTemplate.getEmployees();
	}

	public Employee getEmployee(String id) {
		return this.employeeJdbcTemplate.getEmployee(id);
	}

	/*
	 * Trasaction needs to be in service layer
	 * Answer 1 and 3 for why?
	 */
	@Transactional
	public void createEmployee(Employee employee) {
		this.employeeJdbcTemplate.createEmployee(employee);		
	}

	@Transactional
	public void updateEmployee(Employee employee) {
		this.employeeJdbcTemplate.updateEmployee(employee);
	}

	@Transactional
	public void deleteEmployee(String id) {
		this.employeeJdbcTemplate.deleteEmployee(id);
	}
}
