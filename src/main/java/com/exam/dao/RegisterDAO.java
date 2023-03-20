package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exam.bean.RegisterBean;
import com.exam.util.dbConnection;

public class RegisterDAO {

	public boolean registerUser(RegisterBean rbean) {
		
		Connection con = dbConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into tbl_login(rollno,fullname,email,phoneno,password,usertype) values(?,?,?,?,?,?)");
			pstmt.setInt(1, rbean.getRollno());
			pstmt.setString(2, rbean.getFullname());
			pstmt.setString(3, rbean.getEmail());
			pstmt.setString(4, rbean.getPhoneno());
			pstmt.setString(5, rbean.getPassword());
			pstmt.setString(6, rbean.getUsertype());
			pstmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
