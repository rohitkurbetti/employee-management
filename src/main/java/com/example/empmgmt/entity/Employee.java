package com.example.empmgmt.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Nonnull
	@Column(name="emp_id")
	private Long id;
	
	@Column(name="emp_name")
	private String empName;

	@Column(name="emp_designation")
	private String empDesignation;
	
	@Column(name="emp_department")
	private String empDepartment;
	
	
	
}
