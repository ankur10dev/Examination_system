package com.exam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.bean.SubjectBean;
import com.exam.dao.SubjectDAO;

@WebServlet("/addsubject")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubjectServlet() {
        super();
    }

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubjectBean sbean = new SubjectBean();
		sbean.setSid(request.getParameter("sid"));
		sbean.setSname(request.getParameter("sname"));
		
		SubjectDAO sdao = new SubjectDAO();
		boolean success = sdao.addSubject(sbean);
		response.setContentType("text/html");
		PrintWriter pw = null;
		if(success) {
			pw = response.getWriter();
			pw.println("Subject Added");
		}else {
			pw.println("Invalid Operation");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
