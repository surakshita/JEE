package com.xworkz.nykaastore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class GetConnectionToCosmeticsTable {
	
	public static void main(String[] args) throws Exception {
		
	String url="jdbc:mysql//localhost:3306/nykaa";
	String user="root";
	String password="root123";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url, user, password);
		System.out.println(conn);
	}catch (SQLException e) {
		e.printStackTrace();
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
		
		
		
	}
}

 