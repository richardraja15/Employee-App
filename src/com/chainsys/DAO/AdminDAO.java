package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chainsys.controller.ConnectionUtil;

public class AdminDAO {

	public boolean validateLogin(String userName, String password)
			throws Exception {

		boolean isValid = false;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
	String		sql = "select user_name,password from adminlogin";
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
			throw new Exception("Invalid Username or Password");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return isValid;

	}
}
