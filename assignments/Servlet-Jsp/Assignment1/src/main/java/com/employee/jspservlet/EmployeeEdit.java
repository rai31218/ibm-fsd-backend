package com.employee.jspservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeEdit extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		EmployeeServe empserve=new EmployeeServe();
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			empserve.edit(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
