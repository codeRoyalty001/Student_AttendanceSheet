package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.*;
import com.db.DBConnect;


@WebServlet("/add_student")
public class AddServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username=req.getParameter("username");
	String status=req.getParameter("status");

//	System.out.println(username+" "+todo+" "+status);
	
	AttendanceDAO dao=new AttendanceDAO(DBConnect.getConn());
	boolean f=dao.addStudent(username,status);
	
	
	HttpSession session=req.getSession();
	
	
	if(f) {
		session.setAttribute("sucMsg","Student Added Successfully...");
		System.out.println("Data Insert Successfully...!");
		resp.sendRedirect("index.jsp");
	}else {
		
		session.setAttribute("failedMsg","Something Wrong on Server...!");
		System.out.println("Error..");
		resp.sendRedirect("index.jsp");
		
	}
	
		
	}
	
	

}
