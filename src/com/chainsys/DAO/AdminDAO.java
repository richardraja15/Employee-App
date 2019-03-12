package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.chainsys.util.ConnectionUtil;

/**
 * This class implements Admin Login
 * 
 * @author rich2110
 *This class is used to Authenticate Admin
 */
public class AdminDAO {

	/**
	 * This method is used to authenticate adminLogin
	 * 
	 * @param userName
	 * @param password
	 * @return boolean to check userName and password
	 * @throws Exception
	 */
	public boolean validateLogin(String userName, String password)
			throws Exception {
		boolean isValid = false;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String sql = "select user_name,password from adminlogin";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery(sql);
		while (resultSet.next()) {
			if (resultSet.getString("user_name").contentEquals(userName)
					&& resultSet.getString("password").contentEquals(password)) {
				isValid = true;
			}
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return isValid;
	}
}
