package com.example.empmgmt.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize
@JsonDeserialize
public class EmployeeRequestDto {
	
	private String name;
	private String designation;
	private String department;
	private Long salary;
	private String empAddress1;
	private String empAddress2;
	private Long annualIncome;
	private String state;

}
