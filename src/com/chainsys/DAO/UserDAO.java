package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsy.model.Employee;
import com.chainsy.model.User;
import com.chainsys.exceptioncontroller.FailedException;
import com.chainsys.util.ConnectionUtil;

/**
 * @author rich2110
 *This class is used to impelement Operation on User
 */
public class UserDAO {
	String sql;

	/**
	 * This method is used to insert userlogin details
	 * 
	 * @param user
	 * @throws FailedException
	 */
	public void setUserName(User user) throws FailedException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			sql = "insert into userlogin values(userlogin_id_seq.nextval,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getEmployee().getId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new FailedException("unable to register");
		} finally {
			try {
				ConnectionUtil.close(connection, preparedStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is used to insert employee details into employee info table
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void setUserInfo(User user) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			sql = "insert into employee_info values(info_id_seq.nextval,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getEmployee().getId());
			preparedStatement.setString(2, user.getEmailId());
			preparedStatement.setLong(3, user.getPhoneNumber());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.getGender());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new FailedException("unable to register");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
	}

	/**
	 * This method is used to get existing userName from user login
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public boolean getUserName(String userName) throws Exception {
		boolean isValid = true;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
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
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return isValid;
	}

	/**
	 * This method is used to validate login
	 * 
	 * @param userName
	 * @param password
	 * @return boolean to validate login
	 * @throws Exception
	 */
	public boolean validateLogin(String userName, String password)
			throws Exception {
		boolean isValid = false;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
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
			throw new Exception("Authentication Failed");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return isValid;
	}

	/**
	 * This method is used to get id for specific user name
	 * 
	 * @param userName
	 * @return employee id for specific user name
	 * @throws Exception
	 */
	public int getId(String userName) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id = 0;
		try {
			sql = "select emp_id from userlogin where user_name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("emp_id");
			}
		} catch (Exception e) {
			throw new Exception("unable to get id");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return id;

	}

	/**
	 * This method is used to fetch and display specific record from employee
	 * info table
	 * 
	 * @param id
	 * @return User object of specific user details
	 * @throws Exception
	 */
	public User FindById(int id) throws Exception {
		User user = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			sql = "select ef.emp_id as id,e.name as name,ef.email_id as emailId,ef.address as address,ef.gender as gender,ef.phone_number as phoneNumber from(employee_info ef inner join employee e on ef.emp_id=e.id)where ef.emp_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				user.setEmployee(employee);
				user.setEmailId(resultSet.getString("emailId"));
				user.setPhoneNumber(resultSet.getLong("phoneNumber"));
				user.setAddress(resultSet.getString("address"));
				user.setGender(resultSet.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return user;
	}

	/**
	 * This method is used to Update employee info
	 * 
	 * @param user
	 * @throws FailedException
	 */
	public void Update(User user) throws FailedException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			sql = "update employee_info set email_id=?,phone_number=?,address=? where emp_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmailId());
			preparedStatement.setLong(2, user.getPhoneNumber());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setInt(4, user.getEmployee().getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new FailedException("unable to update user details");
		} finally {
			try {
				ConnectionUtil.close(connection, preparedStatement, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is used to fetch all employee id from user login
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean validateId(int id) throws Exception {
		boolean isValid = true;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			sql = "select emp_id from userlogin";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getInt("emp_id") == id)
					isValid = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return isValid;
	}

	/**
	 * Delete specific record from employee info using id
	 * 
	 * @param id
	 * @throws FailedException
	 */
	public void deleteInfo(int id) throws FailedException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			sql = "delete from employee_info where emp_id=?";
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
	 * This method delete user login details using id
	 * 
	 * @param id
	 * @throws FailedException
	 */
	public void deleteUserLogin(int id) throws FailedException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			sql = "delete from userlogin where emp_id=?";
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
}
