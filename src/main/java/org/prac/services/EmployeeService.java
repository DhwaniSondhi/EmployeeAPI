package org.prac.services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.prac.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

	private HashMap<String, Employee> employees;

	public EmployeeService() {
		System.out.println("I am in");
		if(employees==null ||  employees.size()==0) {
			this.employees=new HashMap<String, Employee>();
			this.employees.put("1244062", new Employee.EmployeeBuilder()
					.setId("1244062")
					.setfName("Dhwani")
					.setlName("Sondhi")
					.setRole("Developer")
					.setPhoneNum("9999999999")
					.build());
			
			this.employees.put("1244063", new Employee.EmployeeBuilder()
					.setId("1244063")
					.setfName("Sahaj")
					.setlName("Sondhi")
					.setRole("Manager")
					.setPhoneNum("0000000000")
					.build());
			
			this.employees.put("1244064", new Employee.EmployeeBuilder()
					.setId("1244064")
					.setfName("Tans")
					.setlName("Singh")
					.setRole("TL")
					.setPhoneNum("4444444444")
					.build());
		}
	}

	public List<Employee> getEmployees() {
		return new ArrayList<Employee>(this.employees.values());
	}

	public Employee getEmployee(String id) {
		return this.employees.get(id);
	}

	public Employee addEmployee(Employee employee) {
		this.employees.put(employee.getId(), employee);
		return this.employees.get(employee.getId());
	}

	public Employee editEmployee(Employee employee) {
		this.employees.put(employee.getId(), employee);
		return this.employees.get(employee.getId());
	}

	public void deleteEmployee(String id) {
		this.employees.remove(id);
	}
}
