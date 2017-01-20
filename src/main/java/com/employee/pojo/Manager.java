package com.employee.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager {

	private long id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "managerId")
	@GeneratedValue
	public long getId() {
		return id;
	}

	private Set<Employee> employees;

	public Manager() {
	}

	public Manager(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}