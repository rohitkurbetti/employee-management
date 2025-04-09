package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	@Query("select COUNT(d) from Department d")
	int getDepartmentCount();

}
