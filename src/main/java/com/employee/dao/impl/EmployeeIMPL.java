package com.employee.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

/*import org.hibernate.Criteria;*/
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.employee.dao.EmployeeDAO;
import com.employee.pojo.Category;
import com.employee.pojo.Employee;
import com.employee.pojo.Manager;
import com.employee.pojo.Product;

/*import org.hibernate.criterion.Order;*/
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
		/*
		 * Criteria cr = session.createCriteria(Employee.class);
		 * cr.addOrder(Order.desc("EmployeeID"));
		 */

		System.out.println(transaction);
		Manager manager = new Manager("Aviral");

		Employee employee2 = new Employee("Mahima", "Trainee", manager);
		Employee employee3 = new Employee("Mahima2", "Trainee", manager);
		Employee employee4 = new Employee("Mahima3", "Trainee", manager);
		Employee employee5 = new Employee("Mahima4", "Trainee", manager);

		Set<Employee> employees = new HashSet<Employee>();
//		employees.add(employee);
		employees.add(employee5);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		
		manager.setEmployees(employees);
		
		session.save(manager);
		session.getTransaction().commit();
//		transaction.commit();
		// List<Employee> resp = getEmployee(null);
		// System.out.println(resp.get(0).getManager().getManagerId());
		session.close();
		return "Successfully data added..!!!!!";
	}

	/*private void test() {

		Category category = new Category("Computer");

		Product pc = new Product("DELL PC", "Quad-core PC", 1200, category);

		Product laptop = new Product("MacBook", "Apple High-end laptop", 2100,
				category);

		Product phone = new Product("iPhone 5",
				"Apple Best-selling smartphone", 499, category);

		Product tablet = new Product("iPad 3", "Apple Best-selling tablet",
				1099, category);

		Set<Product> products = new HashSet<Product>();
		products.add(pc);
		products.add(laptop);
		products.add(phone);
		products.add(tablet);

		category.setProducts(products);

		session.save(category);

		session.getTransaction().commit();
		session.close();
	}*/

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
		if (employee.getEmployeeId() > 0) {
			Employee emp = session
					.get(Employee.class, employee.getEmployeeId());
			if (!StringUtils.isEmpty(emp)) {
				if (!StringUtils.isEmpty(employee.getEmployeeName())) {
					emp.setEmployeeName(employee.getEmployeeName());
				}
				if (!StringUtils.isEmpty(employee.getEmployeeDesignation())) {
					emp.setEmployeeDesignation(employee
							.getEmployeeDesignation());
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
