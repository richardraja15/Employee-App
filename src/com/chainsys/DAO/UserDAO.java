package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.chainsy.model.Employee;
import com.chainsy.model.User;
import com.chainsys.controller.ConnectionUtil;

public class UserDAO {

	String sql;

	public void setUserName(User user) throws Exception {
		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement preparedStatement;
		try {
			sql = "insert into userlogin values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getEmployee().getId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to register");

		}

		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public void setUserInfo(User user) throws Exception {
		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement preparedStatement = null;
		try {
			sql = "insert into employee_info values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getEmployee().getId());
			preparedStatement.setString(2, user.getEmailId());
			preparedStatement.setString(3, user.getPhoneNumber());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.getGender());

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to register");

		}

		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public boolean getUserName(String userName) throws Exception {

		boolean isValid = true;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			sql = "select user_name from userlogin";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);

			while (resultSet.next()) {
				if (resultSet.getString("user_name").contentEquals(userName)) {
					isValid = false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Duplicate userName");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return isValid;

	}

	public boolean validateLogin(String userName, String password)
			throws Exception {

		boolean isValid = false;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			sql = "select user_name,password from userlogin";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);

			while (resultSet.next()) {
				if (resultSet.getString("user_name").contentEquals(userName)
						&& resultSet.getString("password").contentEquals(
								password)) {
					isValid = true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Authentication Failed");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return isValid;

	}

	public int getId(String userName) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		int id = 0;
		try {
			sql = "select user_id from userlogin where user_name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("user_id");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to get name");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return id;

	}

	public String getName(String userName) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		int id;
		String name = null;
		try {
			sql = "select name from employee_info where id=?";
			preparedStatement = connection.prepareStatement(sql);
			UserDAO userDAO = new UserDAO();
			id = userDAO.getId(userName);
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

	public User FindById(int id) throws Exception {
		User user = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement ;
		ResultSet resultSet;
		String name;
		try {
			sql = "select id,email_id,phone_number,address,gender from employee_info where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = new User();
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				EmployeeDAO employeeDAO = new EmployeeDAO();
				name = employeeDAO.getName(id);
				employee.setName(name);
				user.setEmployee(employee);
				user.setEmailId(resultSet.getString("email_id"));
				user.setPhoneNumber(resultSet.getString("phone_number"));
				user.setAddress(resultSet.getString("address"));
				user.setGender(resultSet.getString("gender"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch bloc
			throw new Exception("unable to find records");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return user;
	}

	public void Update(User user) throws Exception {

		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement preparedStatement;
		try {
			sql = "update employee_info set email_id=?,phone_number=?,address=? where id=?";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, user.getEmailId());

			preparedStatement.setString(2, user.getPhoneNumber());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setInt(4, user.getEmployee().getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to update records");
		}
		ConnectionUtil.close(connection, preparedStatement, null);

	}
public boolean validateId(int id) throws Exception{
	boolean isValid=true;
	Connection connection = ConnectionUtil.getConnection();
	PreparedStatement preparedStatement ;
	ResultSet resultSet;
	try {
		sql = "select user_id from userlogin";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			if(resultSet.getInt("user_id")==id)
				isValid=false;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch bloc
		throw new Exception("unable to find records");
	}
	ConnectionUtil.close(connection, preparedStatement, resultSet);
	return isValid;

}
}
