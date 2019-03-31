package com.employee.jspservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeFetch extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		HttpSession session= req.getSession();
		EmployeeServe empserve=new EmployeeServe();
		try {
			List empList=empserve.fetch();
			System.out.println(empList);
			session.setAttribute("ListEmp", empList);
			//session.getAttribute("ListEmp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
