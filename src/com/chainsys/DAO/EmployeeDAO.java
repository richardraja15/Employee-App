package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsy.model.Department;
import com.chainsy.model.Employee;
import com.chainsy.model.Position;
import com.chainsys.exceptioncontroller.FailedException;
import com.chainsys.util.ConnectionUtil;

/**
 * @author rich2110
 *This class is used to implement operstions on Employee
 */
public class EmployeeDAO {
	String sql;

	/**
	 * This method is used to enroll employee
	 * 
	 * @param employee
	 * @return boolean to validate addition of employees
	 * @throws FailedException
	 */
	public boolean addEmployee(final Employee employee) throws FailedException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		boolean success = false;
		try {
			sql = "insert into employee(id,emp_id,name,department_id,position_id,joining_date)values(employee_id_seq.nextval,employee_empid_seq.nextval,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setInt(2, employee.getDepartment().getId());
			preparedStatement.setInt(3, employee.getPosition().getId());
			preparedStatement.setDate(4,
					Date.valueOf(employee.getJoiningDate()));
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				success = true;
			}
		} catch (Exception e) {
			throw new FailedException("unable to add");

		} finally {
			try {
				ConnectionUtil.close(connection, preparedStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}

	/**
	 * This method is used to fetch and display specific record using id
	 * 
	 * @param id
	 * @return employee object of specific employee details
	 * @throws Exception
	 */
	public Employee FindById(int id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		try {
			sql = "SELECT e.id as id,e.emp_id as empId,e.name as name,e.joining_date as joiningdate,d.name as department,p.name as position,p.salary as salary FROM ((employee e  INNER JOIN department d  ON e.department_id = d.id)INNER JOIN position p  ON e.position_id = p.id)where e.emp_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setEmpId(resultSet.getInt("empId"));
				employee.setName(resultSet.getString("name"));
				Department department = new Department();
				department.setName(resultSet.getString("department"));
				employee.setDepartment(department);
				Position position = new Position();
				position.setName(resultSet.getString("position"));
				position.setSalary(resultSet.getFloat("salary"));
				employee.setPosition(position);

				employee.setJoiningDate(resultSet.getDate("joiningdate")
						.toLocalDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return employee;
	}

	/**
	 * This method delete specific employee record using id
	 * 
	 * @param id
	 * @throws FailedException
	 */
	public void deleteById(int id) throws FailedException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			sql = "delete from employee where emp_id=?";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new FailedException("unable to delete records");
		} finally {
			try {
				ConnectionUtil.close(connection, preparedStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is used to Update specific employee using id
	 * 
	 * @param employee
	 * @throws FailedException
	 */
	public void Update(Employee employee) throws FailedException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			sql = "update employee set name=?,department_id=?,position_id=?, joining_date=? where emp_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setInt(2, employee.getDepartment().getId());
			preparedStatement.setInt(3, employee.getPosition().getId());
			preparedStatement.setDate(4,
					Date.valueOf(employee.getJoiningDate()));
			preparedStatement.setInt(5, employee.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new FailedException("unable to update your details");
		} finally {
			try {
				ConnectionUtil.close(connection, preparedStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is used to fetch all employee id
	 * 
	 * @param id
	 * @return boolean to check id with employee id
	 * @throws Exception
	 */
	public boolean getId(int id) throws Exception {
		boolean isValid = false;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			sql = "select emp_id from employee";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				if (resultSet.getInt("emp_id") == id) {
					isValid = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return isValid;
	}

	/**
	 * This method is used to Fetch all records and display all
	 * 
	 * @return list of employee objects
	 * @throws Exception
	 */
	public ArrayList<Employee> FindAll() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			sql = "SELECT e.id as id,e.emp_id as empId, e.name as name,e.joining_date as joiningdate,d.name as department,p.name as position,p.salary as salary FROM ((employee e  INNER JOIN department d  ON e.department_id = d.id)INNER JOIN position p  ON e.position_id = p.id)order by e.id";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setEmpId(resultSet.getInt("empId"));
				employee.setName(resultSet.getString("name"));
				Department department = new Department();
				department.setName(resultSet.getString("department"));
				employee.setDepartment(department);
				Position position = new Position();
				position.setName(resultSet.getString("position"));
				position.setSalary(resultSet.getFloat("salary"));
				employee.setPosition(position);
				employee.setJoiningDate(resultSet.getDate("joiningdate")
						.toLocalDate());
				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}
}
