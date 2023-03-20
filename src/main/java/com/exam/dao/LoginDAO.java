package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.bean.LoginBean;
import com.exam.util.dbConnection;

public class LoginDAO {
	public String loginUser(LoginBean lbean) {
		Connection con = dbConnection.getConnection();
		System.out.println(con);
		String usertype = null;
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from tbl_login where email=? and password=?");
			pstmt.setString(1, lbean.getUsername());
			pstmt.setString(2, lbean.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() != false) {
				usertype = rs.getString("usertype");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usertype;
	}
}
