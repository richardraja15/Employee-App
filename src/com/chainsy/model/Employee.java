package com.chainsy.model;

import java.time.LocalDate;

/**
 * @author rich2110
 *This class contains Employee information
 */
public class Employee {
	private int id;
	private int empId;
	private String name;
	private LocalDate joiningDate;
	private Department department;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", name=" + name
				+ ", joiningDate=" + joiningDate + ", department=" + department
				+ ", position=" + position + "]";
	}
	private Position position;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
}
