package com.example.empmgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empmgmt.dto.EmployeeRequestDto;
import com.example.empmgmt.entity.EmpDetails;
import com.example.empmgmt.entity.Employee;
import com.example.empmgmt.repository.EmpDetailsRepository;
import com.example.empmgmt.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepo;
	
	@Autowired
	private EmpDetailsRepository empDetailsRepo;

	@Override
	public Employee saveEmployee(EmployeeRequestDto entity) {
		
		//save employee
		Employee empDom = new Employee();
		empDom.setEmpDesignation(entity.getDesignation());
		empDom.setEmpName(entity.getName());
		empDom.setEmpDepartment(entity.getDepartment());
		Employee empSaved = empRepo.save(empDom);
		
		//save empDetails
		EmpDetails empDetails = new EmpDetails();
		empDetails.setEmpId(empSaved.getId());
		empDetails.setEmpSalary(entity.getSalary());
		empDetails.setEmpAddress1(entity.getEmpAddress1());
		empDetails.setEmpAddress2(entity.getEmpAddress2());
		empDetails.setEmpAnnualIncome(entity.getAnnualIncome());
		empDetails.setEmpState(entity.getState());
		
		empDetailsRepo.save(empDetails);
		
		return empSaved;
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

	@Override
	public Optional<EmpDetails> getEmployeeDetailById(Long id) {
		Optional<EmpDetails> empDetails = empDetailsRepo.findByEmpId(id);
		if(empDetails.isPresent()) {
			return empDetails;
		}
		return Optional.empty();
	}

	@Override
	public void deleteEmployeeDetails(Long id) {
		empDetailsRepo.deletebyEmpId(id);
	}

	
	
	
	
	
	
}
