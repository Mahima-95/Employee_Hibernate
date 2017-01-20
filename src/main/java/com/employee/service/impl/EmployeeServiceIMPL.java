package com.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDAO;
import com.employee.pojo.Employee;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public String addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	public String deleteEmployee(int EmployeeID) {
		return employeeDAO.deleteEmployee(EmployeeID);
	}

	public List<Employee> getEmployee(Employee employee) {
		return employeeDAO.getEmployee(employee);
	}

	public String updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

}
