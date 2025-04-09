package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_employees")
public class EmployeeNew {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "emp_new_seq")
	@SequenceGenerator(name = "emp_new_seq", sequenceName = "emp_new_seq", allocationSize = 1)
	private long id;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_department")
	private String empDept;
	
	@Column(name = "email_id")
	private String empEmailId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public EmployeeNew() {
		
	}
	
	public EmployeeNew(String empName, String empDept, String empEmailId) {
		this.empName = empName;
		this.empDept = empDept;
		this.empEmailId = empEmailId;
	}
	
	
	
}
