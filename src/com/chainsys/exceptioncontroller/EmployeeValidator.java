package com.chainsys.exceptioncontroller;

import java.time.LocalDate;

import com.chainsy.model.Employee;


/**
 * @author rich2110
 *This class is used to validate Employee class
 */
public class EmployeeValidator {
	/**
	 * This method is used to validate inputs
	 * 
	 * @param employee
	 * @return boolean
	 * @throws Exception
	 */
	public boolean validateAdd(Employee employee) throws Exception {
		boolean isValid = true;
		if (employee.getId() < 0) {
			isValid = false;
			throw new InvalidIdException("invalid id");

		} else if (employee.getName() == null) {
			isValid = false;
			throw new InvalidNameException("Invalid Name");

		} else if (LocalDate.now().isBefore(employee.getJoiningDate())) {
			isValid = false;
			throw new InvalidDateException("Invalid Date");
		}
		return isValid;
	}

	/**
	 * This method is used to validate id
	 * @param employee
	 * @return boolean
	 * @throws Exception
	 */
	public boolean validatById(Employee employee) throws Exception {

		boolean isValid = true;
		if (employee.getEmpId() < 0) {
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
