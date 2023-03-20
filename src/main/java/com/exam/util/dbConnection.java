package com.exam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
public static Connection getConnection(){
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examapplication","root","ashutosh8984");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(con);
		return con;	
	}
}
