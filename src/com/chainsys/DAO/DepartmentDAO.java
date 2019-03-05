package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.chainsy.model.Department;
import com.chainsy.model.Employee;
import com.chainsys.controller.ConnectionUtil;

public class DepartmentDAO {
	public ArrayList<Department> select() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
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
			// TODO Auto-generated catch block
			throw new Exception("unable to select department records");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return bList;

	}
public Department fetchName(Department department) throws Exception{
	Connection connection = ConnectionUtil.getConnection();
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	//ArrayList<Department> bList = new ArrayList<Department>();
	try {
		String sql = "select id,name from department where id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, department.getId());
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			//Department department = new Department();
			
			department.setId(resultSet.getInt("id"));
			department.setName(resultSet.getString("name"));
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new Exception("unable to get employee name");
	}
	ConnectionUtil.close(connection, preparedStatement, resultSet);
	return department;
}
	public Department fetchId(Employee employee) throws Exception{
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		//ArrayList<Department> bList = new ArrayList<Department>();
		Department department=new  Department();
		try {
			String sql = "select id from department where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,employee.getDepartment().getName());
			resultSet = preparedStatement.executeQuery();
		
			if (resultSet.next()) {
				
				department.setId(resultSet.getInt("id"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("ID not available");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return department;

}

}
