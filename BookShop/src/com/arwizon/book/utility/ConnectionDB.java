package com.arwizon.book.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	private static String url = "jdbc:mysql://localhost:3306/arwizon";
	private static String username="root";
	private static String password="root";

	public static Connection  connectDB()  {

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
