package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exam.bean.ResultInsertBean;
import com.exam.util.dbConnection;

public class SaveResultDao {
public void saveResult(ResultInsertBean rib) {
		
		Connection con = dbConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into tbl_results(id,name,score) values(?,?,?)");
			pstmt.setInt(1, rib.getId());
			pstmt.setString(2, rib.getFullName());
			pstmt.setInt(3, rib.getMarks());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
