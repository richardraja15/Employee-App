package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.chainsy.model.Department;
import com.chainsy.model.Employee;
import com.chainsy.model.Position;
import com.chainsys.controller.ConnectionUtil;

public class EmployeeDAO {

	String sql;

	public boolean addEmployee(final Employee employee) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		boolean success = false;
		try {
			sql = "insert into employee values(employee_id_seq.nextval,?,?,?,?)";
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
			// TODO Auto-generated catch block
			throw new Exception("unable to add");

		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}

		return success;

	}

	public Employee FindById(int id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		try {
			sql = "SELECT e.id as id, e.name as name,e.joining_date as joiningdate,d.name as department,p.name as position,p.salary as salary FROM ((employee e  INNER JOIN department d  ON e.department_id = d.id)INNER JOIN position p  ON e.position_id = p.id)where e.id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
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
			// TODO Auto-generated catch block

			throw new Exception("unable to select records by id");
		}
		finally {
			ConnectionUtil.close(connection, preparedStatement,resultSet);
		}
		return employee;
	}

	public ArrayList<Employee> selectId() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Employee> bList = new ArrayList<Employee>();
		try {
			sql = "select id from employee";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				bList.add(employee);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to select ID");
		}
		finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return bList;

	}

	public void deleteById(int id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement preparedStatement = null;
		try {
			sql = "delete from employee where id=?";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to delete records");
		}
		finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}

	public void Update(Employee employee) throws Exception {

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			sql = "update employee set name=?,department_id=?,position_id=?, joining_date=? where id=?";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, employee.getName());

			preparedStatement.setInt(2, employee.getDepartment().getId());
			preparedStatement.setInt(3, employee.getPosition().getId());
			preparedStatement.setDate(4,
					Date.valueOf(employee.getJoiningDate()));
			preparedStatement.setInt(5, employee.getId());

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to update");
		}
		finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}

	public boolean getId(int id) throws Exception {

		boolean isValid = false;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			sql = "select id from employee";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);

			while (resultSet.next()) {
				if (resultSet.getInt("id") == id) {
					isValid = true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("ID not available");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return isValid;

	}

	public String getName(int id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		String name = null;
		try {
			sql = "select name from employee where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				name = resultSet.getString("name");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to get name");
		}
		finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return name;

	}

	public ArrayList<Employee> FindAll() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			sql = "SELECT e.id as id, e.name as name,e.joining_date as joiningdate,d.name as department,p.name as position,p.salary as salary FROM ((employee e  INNER JOIN department d  ON e.department_id = d.id)INNER JOIN position p  ON e.position_id = p.id)order by e.id";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			// throw new Exception("unable to select records by id");
		}
		finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

}
