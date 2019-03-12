package com.chainsy.model;

/**
 * @author rich2110
 *This class contains department information
 */
public class Department {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	public void setName(String name) {
		this.name = name;
	}

}
