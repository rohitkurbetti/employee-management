package com.example.empmgmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.empmgmt.entity.EmpDetails;

@Repository
public interface EmpDetailsRepository extends JpaRepository<EmpDetails, Long>{

	@Query("select ed from EmpDetails ed where ed.empId=:id")
	Optional<EmpDetails> findByEmpId(@Param("id") Long id);

	@Modifying
	@Query("delete from EmpDetails ed where ed.empId=:id")
	void deletebyEmpId(@Param("id") Long id);

}
