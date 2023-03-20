package com.exam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.bean.LoginBean;
import com.exam.dao.LoginDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBean lbean = new LoginBean();
		lbean.setUsername(request.getParameter("uname"));
		lbean.setPassword(request.getParameter("pword"));
		
		LoginDAO ldao = new LoginDAO();
		String usertype = ldao.loginUser(lbean);
		if(usertype== null){
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("Invalid Username/Password");
		} else {
			HttpSession session = request.getSession();
			if(usertype.equals("user")) {
				session.setAttribute("username", request.getParameter("uname"));
				RequestDispatcher rd = request.getRequestDispatcher("/userdashboard.jsp");
				rd.forward(request, response);
			}else if(usertype.equals("admin")){
				session.setAttribute("username", request.getParameter("uname"));
				RequestDispatcher rd = request.getRequestDispatcher("/admindashboard.jsp");
				rd.forward(request, response);
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
