package com.example.empmgmt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee_details")
public class EmpDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "emp_details_seq")
	@SequenceGenerator(name = "emp_details_seq", sequenceName = "emp_details_seq", allocationSize = 1)
	private long id;
	
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "emp_salary")
	private Long empSalary;
	
	@Column(name = "emp_address1")
	private String empAddress1;
	
	@Column(name = "emp_address2")
	private String empAddress2;
	
	@Column(name = "emp_annual_income")
	private Long empAnnualIncome;
	
	@Column(name = "emp_state")
	private String empState;

	
}
