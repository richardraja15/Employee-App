package com.chainsys.exceptioncontroller;

import java.time.LocalDate;

import com.chainsy.model.Employee;

//import bookapp_jdbc.Book;

public class EmployeeValidator {
	public boolean validateAdd(Employee employee) throws Exception {
		boolean isValid = true;
		if (employee.getId() < 0) {
			isValid = false;
			throw new InvalidIdException("invalid id");

		} else if (employee.getName() == null
				|| employee.getName().trim().length() == 0) {
			isValid = false;
			throw new InvalidNameException("Invalid Name");

		}
		else if(employee.getJoiningDate().isAfter(LocalDate.now())){
			isValid=false;
			throw new InvalidDateException("Invalid Date"); 
		}
		return isValid;
	}
	public boolean validatById(Employee employee) throws Exception {
	
		boolean isValid = true;
		if (employee.getId() < 0) {
			isValid = false;
			throw new InvalidIdException("Invalid Id");
		}
		return isValid;
		} 
		
		public boolean validatByName(Employee employee) throws Exception {
			boolean isValid = true;	
			if (employee.getName() == null
					|| employee.getName().trim().length() == 0) {
				isValid = false;
				throw new InvalidNameException("invalid name");
 

			} 
			return isValid;
			}
}
