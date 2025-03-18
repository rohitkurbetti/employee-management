package com.example.empmgmt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empmgmt.dto.EmployeeRequestDto;
import com.example.empmgmt.entity.EmpDetails;
import com.example.empmgmt.entity.Employee;
import com.example.empmgmt.service.EmpService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000") // Allow React app
public class EmpController {


	@Autowired
	private EmpService empService;
	
	@PostMapping("/employees/add")
	public Employee addEmployee(@RequestBody EmployeeRequestDto empRequest) {
		return empService.saveEmployee(empRequest);
	}
	
	// Get All Employees
	@GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return empService.getAllEmployees();
    }

    // Get Employee by ID
	@GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return empService.getEmployeeById(id);
    }
    
    // Delete Employee
    @DeleteMapping("/employees/{id}")
    @Transactional
    public String deleteEmployee(@PathVariable("id") Long id) {
    	empService.deleteEmployee(id);
    	deleteEmployeeDetail(id);
    	return "Employee "+id+" has been deleted";
    }
	
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDto employee) {
    	Employee emp = empService.updateEmployee(id, employee);
    	empService.updateEmployeeDetails(id, employee);
    	return emp;
    }
    
    
    //***empDetails crud
    
    // Get EmployeeDetl by ID
 	@GetMapping("/employeeDetail/{id}")
     public Optional<EmpDetails> getEmployeeDetailById(@PathVariable("id") Long id) {
         return empService.getEmployeeDetailById(id);
     }
    
    
 	// Delete EmployeeDetails by ID
    @DeleteMapping("/employeeDetail/{id}")
    public void deleteEmployeeDetail(@PathVariable("id") Long id) {
    	empService.deleteEmployeeDetails(id);
    }
    
    
    @PutMapping("/employeeDetail/{id}")
    public EmpDetails updateEmployeeDetails(@PathVariable Long id, @RequestBody EmployeeRequestDto employee) {
        return empService.updateEmployeeDetails(id, employee);
    }
    
    
    
    
	
}
