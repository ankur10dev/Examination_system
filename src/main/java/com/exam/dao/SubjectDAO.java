package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exam.bean.SubjectBean;
import com.exam.util.dbConnection;

public class SubjectDAO {
	public boolean addSubject(SubjectBean sbean) {
		Connection con = dbConnection.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("insert into tbl_subjects values(?,?)");
			pstmt.setInt(1, sbean.getSid());
			pstmt.setString(2, sbean.getSname());
			pstmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
