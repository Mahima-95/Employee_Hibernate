package com.employee.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {

	private long EmployeeId;
	private String EmployeeName;
	private String EmployeeDesignation;

	private Manager manager;

	public Employee() {
	}

	public Employee(String EmployeeName, String EmployeeDesignation, Manager manager) {
		this.EmployeeName = EmployeeName;
		this.EmployeeDesignation = EmployeeDesignation;
		this.manager = manager;
	}

	@Id
	@Column(name = "employeeId")
	@GeneratedValue
	public long getEmployeeId() {
		return EmployeeId;
	}

	@ManyToOne
	@JoinColumn(name = "managerId")
	public Manager getManager() {
		return manager;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String EmployeeName) {
		this.EmployeeName = EmployeeName;
	}

	public String getEmployeeDesignation() {
		return EmployeeDesignation;
	}

	public void setEmployeeDesignation(String EmployeeDesignation) {
		this.EmployeeDesignation = EmployeeDesignation;
	}

	public void setEmployeeId(long EmployeeId) {
		this.EmployeeId = EmployeeId;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
}