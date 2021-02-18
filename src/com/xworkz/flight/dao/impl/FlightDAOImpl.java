package com.xworkz.flight.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.xworkz.flight.dao.FlightDAO;
import com.xworkz.flight.dto.FlightDTO;

public class FlightDAOImpl implements FlightDAO {

	@Override
	public Connection getDBConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/flightdetails";
		String user = "root";
		String password = "root123";

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	

	@Override
	public boolean insertRecord(FlightDTO flight) {
		Connection conn = null;
		PreparedStatement prepStatement = null;

		try {
			conn = getDBConnection();

			String sqlQuery = "insert into flight values(?,?,?,?,?,?);";

			prepStatement = conn.prepareStatement(sqlQuery);

			prepStatement.setInt(1, flight.getFlightId());
			prepStatement.setString(2, flight.getName());
			prepStatement.setInt(3, flight.getFuelCapacity());
			prepStatement.setDouble(4, flight.getArrivalTime());
			prepStatement.setString(5, flight.getSource());
			prepStatement.setString(6, flight.getDestination());

			int result = prepStatement.executeUpdate();

			if (result >= 1)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepStatement != null)
					prepStatement.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public void insertListOfRecords(ArrayList<FlightDTO> flightDTO) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = getDBConnection();

			String sqlQuery = "insert into flight values(?,?,?,?,?,?);";

			preparedStatement = conn.prepareStatement(sqlQuery);
			for (FlightDTO flightDTO2 : flightDTO) {

				preparedStatement.setInt(1, flightDTO2.getFlightId());
				preparedStatement.setString(2, flightDTO2.getName());
				preparedStatement.setInt(3, flightDTO2.getFuelCapacity());
				preparedStatement.setDouble(4, flightDTO2.getArrivalTime());
				preparedStatement.setString(5, flightDTO2.getSource());
				preparedStatement.setString(6, flightDTO2.getDestination());

				preparedStatement.addBatch();

			}

			int[] result = preparedStatement.executeBatch();
			System.out.println("result:");

			for (int i : result) {

				System.out.println(i);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (preparedStatement != null)
					preparedStatement.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public void insertMultipleRecords(ArrayList<FlightDTO> flightDTOs) {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = getDBConnection();

			stmt = conn.createStatement();

			for (FlightDTO flightDTO : flightDTOs) {

				int flightId = flightDTO.getFlightId();
				String name = flightDTO.getName();
				int fuelCapacity = flightDTO.getFuelCapacity();
				double arrivalTime = flightDTO.getArrivalTime();
				String source = flightDTO.getSource();
				String destination = flightDTO.getDestination();

				String sqlQuery = "insert into flight values(" + flightId + ", '"+name + "',"+fuelCapacity + ","
						+ arrivalTime + ",'"+ source + "', '"+destination+"');";

				stmt.addBatch(sqlQuery);

			}

			int[] result1= stmt.executeBatch();
			System.out.println("result");
			for (int i : result1) {

				System.out.println(i);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					;
				conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public boolean updateDestinationByFlightId(String destination, int flightId) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = getDBConnection();
			String sqlQuery = "update flight set detination=? where flightId=?";

			preparedStatement = conn.prepareStatement(sqlQuery);

			preparedStatement.setString(2,destination);
			preparedStatement.setInt(1,flightId);

			int result = preparedStatement.executeUpdate();

			if (result >= 1)
				return true;
			else
				return false;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean deleteByFlightId(int flightId) {
		Connection conn = null;
		java.sql.PreparedStatement preparedStatement = null;

		try {
			conn = getDBConnection();

			String sqlQuery = "delete from flight where flightId=?";

			preparedStatement = conn.prepareStatement(sqlQuery);

			preparedStatement.setInt(1, flightId);

			int result = preparedStatement.executeUpdate();

			if (result >= 1)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	}
