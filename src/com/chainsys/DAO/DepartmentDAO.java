package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.chainsy.model.Department;
import com.chainsys.util.ConnectionUtil;

/**
 * @author rich2110
 *This class is used to fetch details from Department class 
 */
public class DepartmentDAO {
	/**
	 * This method is used fetch department name and id's
	 * 
	 * @return list of department objects
	 * @throws Exception
	 */
	public ArrayList<Department> select() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Department> bList = new ArrayList<Department>();
		try {
			String sql = "select id,name from department";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				Department department = new Department();
				department.setId(resultSet.getInt("id"));
				department.setName(resultSet.getString("name"));
				bList.add(department);
			}
		} catch (Exception e) {
			throw new Exception("unable to select department records");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return bList;
	}
}
