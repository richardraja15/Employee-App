package com.chainsy.model;

/**
 * @author rich2110
 *This class contains Position information
 */
public class Position {
	private int id;
	private String name;
	private float salary;
	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", salary=" + salary
				+ "]";
	}
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
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
}
