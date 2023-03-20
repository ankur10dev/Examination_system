package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exam.bean.AddQuestionBean;
import com.exam.util.dbConnection;

public class AddQuestionsDAO {
	public boolean addQuestion(AddQuestionBean addbean) {
		Connection con = dbConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into tbl_questions values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, addbean.getSid());
			pstmt.setInt(2, addbean.getQid());
			pstmt.setString(3, addbean.getQuestion());
			pstmt.setString(4, addbean.getOption1());
			pstmt.setString(5, addbean.getOption2());
			pstmt.setString(6, addbean.getOption3());
			pstmt.setString(7, addbean.getOption4());
			pstmt.setString(8, addbean.getCorrectanswer());
			pstmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
