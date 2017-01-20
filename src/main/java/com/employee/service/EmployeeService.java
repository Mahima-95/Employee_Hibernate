package com.employee.service;

import java.util.List;

import com.employee.pojo.Employee;

public interface EmployeeService {

	String addEmployee(Employee employee);

	String deleteEmployee(int EmployeeID);

	List<Employee> getEmployee(Employee employee);

	String updateEmployee(Employee employee);
}
