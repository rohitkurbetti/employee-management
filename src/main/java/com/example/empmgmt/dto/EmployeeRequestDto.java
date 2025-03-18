package com.example.empmgmt.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize
@JsonDeserialize
public class EmployeeRequestDto {
	
	private String empName;
	private String empDesignation;
	private String empDepartment;
	private Long empSalary;
	private String empAddress1;
	private String empAddress2;
	private Long empAnnualIncome;
	private String empState;

}
