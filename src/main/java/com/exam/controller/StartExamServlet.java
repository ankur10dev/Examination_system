package com.exam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.bean.RegisterBean;
import com.exam.bean.ResultInsertBean;
import com.exam.bean.SetQuestionBean;
import com.exam.dao.GetUserDetailsDao;
import com.exam.dao.SaveResultDao;
import com.exam.dao.SetQuestionDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/startexam")
public class StartExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer i = 0;
	Integer Counter = 0;
	List<SetQuestionBean> qList1 = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String selectedsubject = request.getParameter("selectedsubject");
		Integer i = 0;
		SetQuestionDAO setdao = new SetQuestionDAO();
		List<SetQuestionBean> qList = setdao.getQuestion(selectedsubject);
		if (qList1.size() == 0) {
			System.out.println("Assigning question to temp List");
			qList1 = qList;
		}
		System.out.println(qList1.size());
		request.setAttribute("question", qList1.get(i));
		RequestDispatcher rd = request.getRequestDispatcher("exampage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		System.out.println("Inside DoPost");
		
		// Checking Answer for Results 
		System.out.println(request.getParameter("flexRadioDefault")+"Selected Option");
		System.out.println(qList1.get(i).getAnswer()+"DB Answer");
		if(request.getParameter("flexRadioDefault").equals(qList1.get(i).getAnswer())) {
			
			Counter++;
		}
		
		//Incrementing i Value and picking the next question
		// qList1.size()>i
		if(i < (qList1.size() - 1)) {
			i++;
			SetQuestionBean q = qList1.get(i);
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(q);
			System.out.println(JSONObject);
			pw.print(JSONObject);
		}
		else {
			HttpSession session = request.getSession();
			 String userName = (String) session.getAttribute("username");
			 //Getting user Id and Full Name
			 GetUserDetailsDao details = new GetUserDetailsDao();
			 RegisterBean rb = details.getDetails(userName);
			 Integer Id = rb.getId();
			 String FullName = rb.getFullname();
			 // inserting the results into DB
			 ResultInsertBean rib = new ResultInsertBean();
			 rib.setId(Id);
			 rib.setFullName(FullName);
			 rib.setMarks(Counter);
			 
			 SaveResultDao sR = new SaveResultDao();
			 sR.saveResult(rib);
			 
			 System.out.println(Counter+" "+userName);
			 i=0;
			 Counter = 0;
			 qList1.clear();
			pw.print("END");
		}
	}
}
