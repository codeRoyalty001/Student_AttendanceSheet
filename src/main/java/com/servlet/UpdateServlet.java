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
import com.entity.*;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		String username=req.getParameter("username");
		String status=req.getParameter("status");

//		System.out.println(username+" "+todo+" "+status);
		
		AttendanceDAO dao=new AttendanceDAO(DBConnect.getConn());
		
		AttendanceDetails t=new AttendanceDetails();
		
		t.setId(id);
		t.setName(username);
		t.setStatus(status);
		
		boolean f=dao.updateAttendance(t);
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("sucMsg","Attendance  Update Successfully...");
			System.out.println("Data Insert Successfully...!");
			resp.sendRedirect("index.jsp");
		}else {
			
			session.setAttribute("failedMsg","Something Wrong on Server...!");
			System.out.println("Error..");
			resp.sendRedirect("index.jsp");
			
		}
		
		
		
	}

}
