package com.employee.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.employee.dao.EmployeeDAO;
import com.employee.pojo.Employee;

@Repository
public class EmployeeIMPL implements EmployeeDAO {

	private Session session;
	private Transaction transaction;

	public EmployeeIMPL() {
		super();
	}

	@Autowired
	private SessionFactory sessionFactory;

	public String addEmployee(Employee employee) {
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		System.out.println(transaction);
		session.save(employee);
		transaction.commit();
		session.close();
		return "Successfully data added..!!!!!";
	}

	private Session getSession() {
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		return session;
	}

	public String deleteEmployee(int EmployeeID) {
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		Employee employee = session.get(Employee.class, EmployeeID);
		System.out.println(employee);
		session.delete(employee);
		transaction.commit();
		session.close();
		System.out.println("Successfully deleted...!!!!");
		return "Successfully deleted...!!!!";
	}

	public List<Employee> getEmployee(Employee employee) {
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		return session.createCriteria(Employee.class).list();
	}

	public String updateEmployee(Employee employee) {
		String response = null;
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		if (employee.getEmployeeID() > 0) {
			Employee emp = session.get(Employee.class, employee.getEmployeeID());
			if (!StringUtils.isEmpty(emp)) {
				if (!StringUtils.isEmpty(employee.getEmployeeName())) {
					emp.setEmployeeName(employee.getEmployeeName());
				}
				if (!StringUtils.isEmpty(employee.getEmployeeDesignation())) {
					emp.setEmployeeDesignation(employee.getEmployeeDesignation());
				}
				try {
					session.update(emp);
					transaction.commit();
					response = "Successfully updated...!!!!";
				} catch (Exception exception) {
					response = "Exception error";
					exception.printStackTrace();
				} finally {
					session.close();
				}
			}
		} else {
			response = "No data exists for given Id";
		}

		return response;
	}

}
