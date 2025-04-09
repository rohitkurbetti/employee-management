package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "emp_attendance_seq")
	@SequenceGenerator(name = "emp_attendance_seq", sequenceName = "emp_attendance_seq", allocationSize = 1)
	private long id;
	
	@Column(name = "emp_id")
	private String empId;
	
	@Column(name = "attendance_date")
	private String attendanceDate;
	
	@Column(name = "attendance_status")
	private String attendanceStatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public Attendance() {
		
	}
	
	public Attendance(String empId, String attendanceDate, String attendanceStatus) {
		super();
		this.empId = empId;
		this.attendanceDate = attendanceDate;
		this.attendanceStatus = attendanceStatus;
	}
	
	
	
}
