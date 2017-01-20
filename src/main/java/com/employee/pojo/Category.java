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
@Table(name = "CATEGORY")
public class Category {

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
	@Column(name = "CATEGORY_ID")
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	private Set<Product> products;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	public Set<Product> getProducts() {
		return products;
	}
}