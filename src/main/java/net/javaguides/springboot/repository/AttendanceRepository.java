package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

	@Query("select COUNT(a) from Attendance a")
	int getAttendanceCount();

}
