package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exam.bean.FeedbackBean;
import com.exam.util.dbConnection;

public class FeedbackDAO {
	public int giveFeedback(FeedbackBean fbean) {
		Connection con = dbConnection.getConnection();
		int Res=0;
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into tbl_feedback(name,feedback) values(?,?)");
			pstmt.setString(1, fbean.getName());
			pstmt.setString(2, fbean.getFeedback());
			Res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(Res);
		return Res;
	}
}
