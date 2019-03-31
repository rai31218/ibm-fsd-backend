package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		HttpSession session= req.getSession();
	String un1=req.getParameter("uname");
	String pwd1=req.getParameter("pwd");
	
	PrintWriter out= res.getWriter();
	System.out.println("Test"+session.getAttribute("uname")+" "+ session.getAttribute("password")+ un1+ " "+ pwd1);
	
	String username=(String) session.getAttribute("uname");
	if (username.equals(un1))
	{
		System.out.println("if cond");
		//out.print("Login  successfull " + username + " un1: "+un1);
		//res.sendRedirect("Dashboard.jsp");
		//res.sendRedirect("dashboard.do");
	   RequestDispatcher rd=req.getRequestDispatcher("fetch.do");  
       rd.forward(req, res);//method may be include or forward  
	    //res.sendRedirect("form.do");


	}
	
	else
	{
		out.println("Login fails");
	}
	}
}
