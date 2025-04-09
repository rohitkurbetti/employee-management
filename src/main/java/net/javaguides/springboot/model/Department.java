package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "emp_dept_seq")
	@SequenceGenerator(name = "emp_dept_seq", sequenceName = "emp_dept_seq", allocationSize = 1)
	private long id;
	
	@Column(name = "emp_name")
	private String name;
	
	@Column(name = "emp_department")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department() {
		
	}
	
	public Department(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	

	
}
