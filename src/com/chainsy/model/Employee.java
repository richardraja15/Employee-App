package com.chainsy.model;

import java.time.LocalDate;

public class Employee {
private int id;
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
private String name;

private LocalDate joiningDate;
private Department department;
private Position position;
}
