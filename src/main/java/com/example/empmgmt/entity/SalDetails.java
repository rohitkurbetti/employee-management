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
@Table(name = "sal_details")
public class SalDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sal_details_seq")
	@SequenceGenerator(name = "sal_details_seq", sequenceName = "sal_details_seq", allocationSize = 1)
	private long id;
	
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "emp_salary")
	private Long empSalary;
	
	@Column(name = "emp_taxslab")
	private Long empTaxslab;
	
	@Column(name = "emp_primary_income")
	private Boolean empPrimaryIncome;
	
	@Column(name = "emp_taxable_amount")
	private Long empTaxableAmount;
	
}
