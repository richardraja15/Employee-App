package com.chainsy.model;

/**
 * @author rich2110
 *This class contains User information
 */
public class User {
	private String userName;
	private String emailId;
	private String address;
	private long phoneNumber;
	private String gender;
	private Employee employee;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", emailId=" + emailId
				+ ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", gender=" + gender + ", employee=" + employee
				+ ", password=" + password + "]";
	}
}
