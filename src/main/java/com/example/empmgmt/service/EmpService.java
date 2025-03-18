package com.example.empmgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.empmgmt.dto.EmployeeRequestDto;
import com.example.empmgmt.entity.EmpDetails;
import com.example.empmgmt.entity.Employee;

@Service
public interface EmpService {

	Employee saveEmployee(EmployeeRequestDto entity);

	Optional<Employee> getEmployeeById(Long id);

	List<Employee> getAllEmployees();

	void deleteEmployee(Long id);

	Employee updateEmployee(Long id, EmployeeRequestDto employee);
	
	Optional<EmpDetails> getEmployeeDetailById(Long id);

	void deleteEmployeeDetails(Long id);


}
