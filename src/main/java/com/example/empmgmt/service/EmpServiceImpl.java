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
		empDom.setEmpDesignation(entity.getEmpDesignation());
		empDom.setEmpName(entity.getEmpName());
		empDom.setEmpDepartment(entity.getEmpDepartment());
		Employee empSaved = empRepo.save(empDom);
		
		//save empDetails
		EmpDetails empDetails = new EmpDetails();
		empDetails.setEmpId(empSaved.getId());
		empDetails.setEmpSalary(entity.getEmpSalary());
		empDetails.setEmpAddress1(entity.getEmpAddress1());
		empDetails.setEmpAddress2(entity.getEmpAddress2());
		empDetails.setEmpAnnualIncome(entity.getEmpAnnualIncome());
		empDetails.setEmpState(entity.getEmpState());
		
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
        	emp.setEmpName(employee.getEmpName());
        	emp.setEmpDesignation(employee.getEmpDesignation());
        	emp.setEmpDepartment(employee.getEmpDepartment());
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

	@Override
	public EmpDetails updateEmployeeDetails(Long id, EmployeeRequestDto employee) {
		Optional<EmpDetails> existingEmployee = getEmployeeDetailById(id);
        EmpDetails empDetails = null;
        if(existingEmployee.isPresent()) {  
        	empDetails = existingEmployee.get();
        	empDetails.setEmpAddress1(employee.getEmpAddress1());
        	empDetails.setEmpAddress2(employee.getEmpAddress2());
        	empDetails.setEmpAnnualIncome(employee.getEmpAnnualIncome());
        	empDetails.setEmpSalary(employee.getEmpSalary());
        	empDetails.setEmpState(employee.getEmpState());
        	
        } else {
        	empDetails = new EmpDetails();
        }
        return empDetailsRepo.save(empDetails);
	}

	
	
	
	
	
	
}
