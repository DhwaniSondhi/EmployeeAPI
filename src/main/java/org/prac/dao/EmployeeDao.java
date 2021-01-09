package org.prac.dao;

import java.util.List;

import org.prac.models.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployees();
	public Employee getEmployee(String id);
	public void createEmployee(Employee employee);
	public void updateEmployee(Employee employee) ;
	public void deleteEmployee(String id) ;
}
