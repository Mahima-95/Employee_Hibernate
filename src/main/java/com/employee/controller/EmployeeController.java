package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.pojo.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/addEmployee") // , consumes=
											// MediaType.APPLICATION_JSON_VALUE
	public String addEmployee() {
		Employee employee = new Employee();
		System.out.println(employee);
		employee.setEmployeeID(1);
		employee.setEmployeeName("Mahima");
		employee.setEmployeeDesignation("Trainee");
		return employeeService.addEmployee(employee);

	}

	@RequestMapping(value = "/deleteEmployee")
	public String deleteEmployee() {
		return employeeService.deleteEmployee(2);

	}
	
	@RequestMapping(value = "/getEmployee")
	public List<Employee> getEmployee() {
		Employee employee = new Employee();
		employee.getEmployeeID();
		return employeeService.getEmployee(employee);

	}
	
	@RequestMapping(value = "/updateEmployee")
	public String updateEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeID(3);
		employee.setEmployeeName("Mahi");
		return employeeService.updateEmployee(employee);

	}

}
