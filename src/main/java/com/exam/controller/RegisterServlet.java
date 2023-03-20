package com.exam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.bean.RegisterBean;
import com.exam.dao.RegisterDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterBean rbean = new RegisterBean();
		rbean.setFullname(request.getParameter("fullname"));
		rbean.setRollno(request.getParameter("rollno"));
		rbean.setEmail(request.getParameter("email"));
		rbean.setPhoneno(request.getParameter("phoneno"));
		rbean.setPassword(request.getParameter("pword"));
		rbean.setCpassword(request.getParameter("cpword"));
		rbean.setUsertype(request.getParameter("utype"));
		response.setContentType("text/html");
		RegisterDAO rdao = new RegisterDAO();
		boolean success = rdao.registerUser(rbean);
		PrintWriter pw = response.getWriter();
		if(success != false) {
			pw.println("You Are Registered");
		}
		else {
			pw.println("Invalid Entry");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
