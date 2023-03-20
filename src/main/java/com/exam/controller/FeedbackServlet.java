package com.exam.controller;

import com.exam.bean.FeedbackBean;
import com.exam.dao.FeedbackDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FeedbackServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Hitting Feedback Servlet");
		System.out.println(request.getParameter("userName"));
		System.out.println(request.getParameter("feedbacktext"));
		FeedbackBean fbean = (FeedbackBean) new FeedbackBean();
		fbean.setName(request.getParameter("userName"));
		fbean.setFeedback(request.getParameter("feedbacktext"));

		FeedbackDAO fdao = new FeedbackDAO();
		int success = fdao.giveFeedback(fbean);
		
		RequestDispatcher rd = request.getRequestDispatcher("exampage.jsp");
	//	HttpSession session = request.getSession();
		if (success!=0) {
			//session.setAttribute("msg", "done");
			request.setAttribute("msg", "Done");
			rd.forward(request, response);
			response.sendRedirect("exampage.jsp");
		} else {
			//session.setAttribute("msg", "notDone Yet");
			//rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		System.out.println("Inside FeedBack Servlet");
	}

}
