package com.xworkz.nykaastore.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.nykaastore.dao.CosmeticsDAO;
import com.xworkz.nykaastore.dto.CosmeticsDTO;

public class CosmeticsDAOImpl implements CosmeticsDAO {

	@Override
	public Connection getDBConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/nykaa";
		String user = "root";
		String password = "root123";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new SQLException();

	}

	@Override
	public boolean save(CosmeticsDTO cosmetics) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			conn = getDBConnection();
			System.out.println(conn);

			stmt = conn.createStatement();
			int id = cosmetics.getCosmeticsId();// 1
			String name = cosmetics.getName();// primer
			double price = cosmetics.getPrice();// 100
			int qnt = cosmetics.getQuantity();// 1
			String brand = cosmetics.getBrand();// Lakme

			String sqlQuery = "insert into cosmetics values(" + id + ", '" + name + "'," + price + "," + qnt + ",'"
					+ brand + "');";
			int result = stmt.executeUpdate(sqlQuery);

			conn.close();
			if (result >= 1)
				return true;
			else
				return false;
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("driver class not found");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public ArrayList<CosmeticsDTO> readAllRecords() {
		ArrayList<CosmeticsDTO> cosmeticsList = new ArrayList<CosmeticsDTO>();
		try {
			Connection conn = getDBConnection();
			Statement stmt = conn.createStatement();
			String sqlQuery = "select * from cosmetics";
			ResultSet result = stmt.executeQuery(sqlQuery);
			// ArrayList<CosmeticsDTO> cosmeticsList = new ArrayList<CosmeticsDTO>();

			while (result.next()) {
				CosmeticsDTO cosmeticsDTO = new CosmeticsDTO();

				int cosmeticsId = result.getInt("cosmeticsId");
				cosmeticsDTO.setCosmeticId(cosmeticsId);
				// System.out.println("cosmeticId is:"+cosmeticsId);

				String name = result.getString(2);
				cosmeticsDTO.setName(name);
				// System.out.println("cosmetic name:"+name);

				double price = result.getDouble(3);
				cosmeticsDTO.setPrice(price);
				// System.out.println("cosmetic price:"+price);

				int quantity = result.getInt("quantity");
				cosmeticsDTO.setQuantity(quantity);
				// System.out.println("cosmetic quantity:"+quantity);

				String brand = result.getString("brand");
				cosmeticsDTO.setBrand(brand);
				// System.out.println("cosmetic brand:"+brand);

				cosmeticsList.add(cosmeticsDTO);

			}
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return cosmeticsList;
	}

	@Override
	public boolean updateRecordBasedOnBrand(double newPriceValue, String brand) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getDBConnection();
			stmt = conn.createStatement();

			String sqlQuery = "update cosmetics set price=" + newPriceValue + "where brand='" + brand + "';";

			int noOfRowsEffected = stmt.executeUpdate(sqlQuery);
			
			System.out.println("noOfRowsEffected:" + noOfRowsEffected);
			conn.close();
			if (noOfRowsEffected >= 1)
				return true;
			else
				return false;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean deleteRecordBasedOnCosmeticsId(int cosmeticsId) {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = getDBConnection();
			stmt = conn.createStatement();

			String sqlQuery = "delete from cosmetics where cosmeticsId=" + cosmeticsId + ";";

			int noOfDeletedRow = stmt.executeUpdate(sqlQuery);

			System.out.println("deleted row:" + noOfDeletedRow);
			
			conn.close();

			if (noOfDeletedRow >= 1)
				return true;
			else
				return false;

		}catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public ArrayList<CosmeticsDTO> readingNameAndBrandFromTable() {
		ArrayList<CosmeticsDTO> cosmeticsList = new ArrayList<CosmeticsDTO>();
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = getDBConnection();
			stmt = conn.createStatement();

			String sqlQuery = "select name,brand from cosmetics;";

			ResultSet nameAndBrand = stmt.executeQuery(sqlQuery);

			System.out.println("name and brand rows:" + nameAndBrand);

			while (nameAndBrand.next()) {
				CosmeticsDTO cosmeticsDTO = new CosmeticsDTO();

				String readingName = nameAndBrand.getString("name");
				cosmeticsDTO.setName(readingName);

				String readingBrand = nameAndBrand.getString("brand");
				cosmeticsDTO.setBrand(readingBrand);

				cosmeticsList.add(cosmeticsDTO);

			}
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return cosmeticsList;
	}

	@Override
	public int totalNumberOfRecords() {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = getDBConnection();
			stmt = conn.createStatement();

			String sqlQuery = "select count(*) from cosmetics;";

			ResultSet totalList = stmt.executeQuery(sqlQuery);

			while (totalList.next()) {
				int count = totalList.getInt(1);
				System.out.println("total list of records:" + count);
			}

			conn.close();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return 0;

	}

	@Override
	public double maxPrice() {
		Connection conn = null;
		Statement stmt = null;

		try {

			conn = getDBConnection();
			stmt = conn.createStatement();

			String sqlQuery = "select max(price) from cosmetics;";

			ResultSet maxPrice = stmt.executeQuery(sqlQuery);

			while (maxPrice.next()) {
				double max = maxPrice.getDouble(1);
				System.out.println("highest price :" + max);
			}

			conn.close();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return 0;
	}

}
