package net.javaguides.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Attendance;
import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.model.EmployeeNew;
import net.javaguides.springboot.repository.AttendanceRepository;
import net.javaguides.springboot.repository.DepartmentRepository;
import net.javaguides.springboot.repository.EmployeeNewRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class EmployeeNewController {
	
	@Autowired
	private EmployeeNewRepository employeeNewRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private AttendanceRepository attendanceRepository;
	
	
	//Dashboard Main
	
	@GetMapping("/dashboard")
	public List<Integer> getDashboardData(){
		
		int empCount = employeeNewRepository.getEmployeeCount();
		int deptCount = departmentRepository.getDepartmentCount();
		int attendanceCount = attendanceRepository.getAttendanceCount();

		return Arrays.asList(empCount, deptCount, attendanceCount, 0);
	}	
	
	
	// create employee rest api
	@PostMapping("/employees")
	public EmployeeNew createEmployee(@RequestBody EmployeeNew employee) {
		EmployeeNew emp =  employeeNewRepository.save(employee);
		return emp;
	}
	
	@GetMapping("/employees")
	public List<EmployeeNew> getAllEmployees(){

		return employeeNewRepository.findAll();
	}	
	
	@DeleteMapping("/employees/{empId}")
	public void deleteEmployeeById(@PathVariable("empId") Integer empId){
		employeeNewRepository.deleteById(empId);
	}	
	
	
	//department
	
	@GetMapping("/departments")
	public List<Department> getDepartments(){
		return departmentRepository.findAll();
	}	
	
	
	// create employee rest api
	@PostMapping("/departments")
	public Department createDepartment(@RequestBody Department department) {
		Department empDept =  departmentRepository.save(department);
		return empDept;
	}
	
	
	@DeleteMapping("/departments/{deptId}")
	public void deleteDepartmentById(@PathVariable("deptId") Integer deptId){
		departmentRepository.deleteById(deptId);
	}	
	
	
	// create attendance rest api
	@PostMapping("/attendance")
	public Attendance createAttendance(@RequestBody Attendance attendance) {
		Attendance res = attendanceRepository.save(attendance);
		return res;
	}
	
	@GetMapping("/attendance")
	public List<Attendance> getAllAttendance(){
		return attendanceRepository.findAll();
	}	
		
	@DeleteMapping("/attendance/{attId}")
	public void deleteAttendanceById(@PathVariable("attId") Integer attId){
		attendanceRepository.deleteById(attId);
	}	

}
