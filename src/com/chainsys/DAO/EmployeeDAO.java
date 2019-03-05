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

	public void addEmployee(Employee employee) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		try {
			sql = "insert into employee values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setInt(3, employee.getDepartment().getId());
			preparedStatement.setInt(4, employee.getPosition().getId());
			preparedStatement.setDate(5,
					Date.valueOf(employee.getJoiningDate()));
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to insert employee");

		}
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public Employee FindById(int id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Employee employee =null;
			try {
				sql = "select id,name,department_id,position_id,joining_date from employee where id=? order by id";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					employee=new Employee();
					employee.setId(resultSet.getInt("id"));
					employee.setName(resultSet.getString("name"));
					Department department = new Department();
					Department department2 = new Department();
					DepartmentDAO departmentDAO = new DepartmentDAO();
					department.setId(resultSet.getInt("department_id"));
					department2 = departmentDAO.fetchName(department);
					employee.setDepartment(department2);
					Position position = new Position();
					Position position2 = new Position();
					PositionDAO positionDAO = new PositionDAO();
					position.setId(resultSet.getInt("position_id"));
					position2 = positionDAO.fetchName(position);
					employee.setPosition(position2);
					employee.setJoiningDate(resultSet.getDate("joining_date")
							.toLocalDate());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to select records by id");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return employee;
	}

	public ArrayList<Employee> selectId() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
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
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return bList;

	}

	public void deleteById(int id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement preparedStatement;
		try {
			sql = "delete from employee where id=?";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to delete records");
		}
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public ArrayList<Employee> FindAll() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Employee> bList = new ArrayList<Employee>();
		try {
			sql = "select id,name,department_id,position_id,joining_date from employee order by id";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				Department department = new Department();
				Department department2 = new Department();
				DepartmentDAO departmentDAO = new DepartmentDAO();
				department.setId(resultSet.getInt("department_id"));
				department2 = departmentDAO.fetchName(department);
				employee.setDepartment(department2);
				Position position = new Position();
				Position position2 = new Position();
				PositionDAO positionDAO = new PositionDAO();
				position.setId(resultSet.getInt("position_id"));
				position2 = positionDAO.fetchName(position);
				employee.setPosition(position2);
				employee.setJoiningDate(resultSet.getDate("joining_date")
						.toLocalDate());
				bList.add(employee);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to display records");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return bList;
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
		ConnectionUtil.close(connection, preparedStatement, null);
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
		PreparedStatement preparedStatement;
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
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return name;

	}
}
