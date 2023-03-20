package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.bean.SetQuestionBean;
import com.exam.util.dbConnection;

public class SetQuestionDAO {
	Connection con = dbConnection.getConnection();
	List<SetQuestionBean> qList = new ArrayList<>();
	
	public List<SetQuestionBean> getQuestion(String selectedsubject) {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from tbl_questions where sid=?");
			pstmt.setInt(1, Integer.parseInt(selectedsubject));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				SetQuestionBean setbean = new SetQuestionBean();
				setbean.setSid(rs.getInt(1));
				setbean.setQuestion(rs.getString(3));
				setbean.setOption1(rs.getString(4));
				setbean.setOption2(rs.getString(5));
				setbean.setOption3(rs.getString(6));
				setbean.setOption4(rs.getString(7));
				setbean.setAnswer(rs.getString(8));
				qList.add(setbean);
			}
			qList.forEach(e-> System.out.println(e));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qList;
	}
	
}
