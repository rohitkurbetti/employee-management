package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.EmployeeNew;

@Repository
public interface EmployeeNewRepository extends JpaRepository<EmployeeNew, Integer>{

	@Query("select COUNT(en) from EmployeeNew en")
	int getEmployeeCount();

}
