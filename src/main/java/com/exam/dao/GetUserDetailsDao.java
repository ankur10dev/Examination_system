package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.bean.LoginBean;
import com.exam.bean.RegisterBean;
import com.exam.util.dbConnection;

public class GetUserDetailsDao {
	
	public RegisterBean getDetails(String userName) {
		//Getting connection from DBUtil Class
		Connection con = dbConnection.getConnection();
		//creating RegisterBean reference
		RegisterBean Rb = new RegisterBean();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from tbl_login where email=?");
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() != false) {
				Rb.setId(rs.getInt(1));
				Rb.setFullname(rs.getString(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Rb;
	}
}
