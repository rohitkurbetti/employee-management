package com.example.empmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.empmgmt.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long>{

}
