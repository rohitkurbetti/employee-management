package com.example.empmgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empmgmt.dto.EmployeeRequestDto;
import com.example.empmgmt.entity.Employee;
import com.example.empmgmt.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepo;

	@Override
	public Employee saveEmployee(EmployeeRequestDto entity) {
		
		Employee empDom = new Employee();
		empDom.setEmpDesignation(entity.getDesignation());
		empDom.setEmpName(entity.getName());
		
		return empRepo.save(empDom);
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		return empRepo.findById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public void deleteEmployee(Long id) {
		empRepo.deleteById(id);
	}

	public Employee updateEmployee(Long id, EmployeeRequestDto employee) {
        Optional<Employee> existingEmployee = getEmployeeById(id);
        Employee emp = null;
        if(existingEmployee.isPresent()) {  
        	emp = existingEmployee.get();
        	emp.setEmpName(employee.getName());
        	emp.setEmpDesignation(employee.getDesignation());
        } else {
        	emp = new Employee();
        }
        return empRepo.save(emp);
    }

	
	
	
	
	
	
}
