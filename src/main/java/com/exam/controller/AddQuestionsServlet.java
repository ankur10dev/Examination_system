package com.exam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.bean.AddQuestionBean;
import com.exam.dao.AddQuestionsDAO;
@WebServlet("/addquestions")
public class AddQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddQuestionsServlet() {
        super();
    }

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddQuestionBean addbean = new AddQuestionBean();
		addbean.setSid(request.getParameter("sid"));
		addbean.setQid(request.getParameter("qid"));
		addbean.setQuestion(request.getParameter("question"));	
		addbean.setOption1(request.getParameter("op1"));
		addbean.setOption2(request.getParameter("op2"));
		addbean.setOption3(request.getParameter("op3"));
		addbean.setOption4(request.getParameter("op4"));
		addbean.setCorrectanswer(request.getParameter("answer"));
		
		AddQuestionsDAO adddao = new AddQuestionsDAO();
		boolean success = adddao.addQuestion(addbean);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		if(success) {
			pw.println("Question Added Successfully");
		} else {
			pw.println("Invalid Operation");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
