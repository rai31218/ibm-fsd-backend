package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Registration extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		HttpSession session= req.getSession();
		System.out.println("Session Id: "+session.getId());
		
		String un=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		
		session.setAttribute("uname", un);
		session.setAttribute("password", pwd);
		System.out.println(un+" "+pwd);
		
		res.sendRedirect("Login.jsp");
		
	}

}
