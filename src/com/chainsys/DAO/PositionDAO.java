package com.chainsys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.chainsy.model.Position;
import com.chainsys.util.ConnectionUtil;

/**
 * @author rich2110
 *This class is used to fetch details from Position class
 */
public class PositionDAO {

	/**
	 * This method is used to fetch position id and name
	 * 
	 * @return list of Position objects
	 * @throws Exception
	 */
	public ArrayList<Position> select() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
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
			throw new Exception("unable to display position records");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return bList;
	}

}