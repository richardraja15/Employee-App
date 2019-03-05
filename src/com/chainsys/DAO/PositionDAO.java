package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.chainsy.model.Employee;
import com.chainsy.model.Position;
import com.chainsys.controller.ConnectionUtil;

public class PositionDAO {

	public ArrayList<Position> select() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Position> bList = new ArrayList<Position>();
		try {
			String sql = "select id,name from position";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);

			while (resultSet.next()) {
				Position position = new Position();
				position.setId(resultSet.getInt("id"));
				position.setName(resultSet.getString("name"));
				bList.add(position);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to display position records");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return bList;
	}
	public Position fetchName(Position position) throws Exception{
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
	
		//ArrayList<Department> bList = new ArrayList<Department>();
		try {
			String sql = "select id,name,salary from position where id=?";
			preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,position.getId());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				//Department department = new Department();
				position.setId(resultSet.getInt("id"));
				position.setName(resultSet.getString("name"));
				position.setSalary(resultSet.getFloat("salary"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to display records");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return position;
	}
	public Position fetchId(Employee employee) throws Exception{
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		//ArrayList<Department> bList = new ArrayList<Department>();
		Position position=new Position();
		try {
			String sql = "select id from position where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,employee.getPosition().getName());
			resultSet = preparedStatement.executeQuery();
		
			while (resultSet.next()) {
				//Department department = new Department();
				
				position.setId(resultSet.getInt("id"));
				//department.setName(resultSet.getString("name"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("unable to display records");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return position;

}

}
