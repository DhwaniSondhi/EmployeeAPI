package org.prac.controllers;

import java.util.List;

import org.prac.models.Employee;
import org.prac.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return this.employeeService.getEmployees();
	}

	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return this.employeeService.getEmployee(id);
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.employeeService.addEmployee(employee);
	}

	@PutMapping("/editEmployee/{id}")
	public Employee editEmployee(@PathVariable String id, @RequestBody Employee employee) {
		employee.setId(id);
		return this.employeeService.editEmployee(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable String id) {
		this.employeeService.deleteEmployee(id);
	}
}
