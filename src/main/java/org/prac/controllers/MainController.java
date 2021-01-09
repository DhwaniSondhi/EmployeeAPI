package org.prac.controllers;

import java.util.List;

import org.prac.models.Employee;
import org.prac.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.dao.EmptyResultDataAccessException;

@Controller
@ResponseBody
public class MainController {

	@Autowired
	private EmployeeService employeeService;

	//https://www.baeldung.com/java-collections-emptylist-new-list
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return this.employeeService.getEmployees();
	}

	//https://www.baeldung.com/spring-response-status-exception
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable String id) {
		try {
			return this.employeeService.getEmployee(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found!");
		}
	}

	/* 
	 * 409 for duplicate entry
	 * https://community.apigee.com/questions/24523/need-suggestions-on-http-status-code-for-trying-to.html#:~:text=2%20Answers&text=409%20is%20the%20correct%20status,resource%20or%20resource%20already%20exists.&text=%40Swapnil%20Raverkar%20409%20would%20be,in%20the%20case%20of%20PUT.
	 * */
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		try {
			this.employeeService.createEmployee(employee);
			return this.getEmployee(employee.getId());
		}catch(DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee already exists!");
		}
	}

	//Throws error if not found
	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
		employee.setId(id);
		this.employeeService.updateEmployee(employee);
		return this.getEmployee(id);
	}

	//Throws error if not found
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		this.getEmployee(id);
		this.employeeService.deleteEmployee(id);
		return "Deleted!";
	}
}
