package com.employee.jspservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Insert extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		HttpSession session= req.getSession();
		System.out.println("Session Id: "+session.getId());
		
		String name=req.getParameter("name");
		String db=req.getParameter("dob");
		LocalDate dob=LocalDate.parse(db);
		int salary=Integer.parseInt(req.getParameter("salary"));
		String department=req.getParameter("department");
		
		session.setAttribute("name", name);
		session.setAttribute("dob", dob);
		session.setAttribute("salary",salary);
		session.setAttribute("department",department);
		//System.out.prin tln(un+" "+pwd);
		
		Employee emp =new Employee(name,dob,salary,department);
		EmployeeServe empserve= new EmployeeServe();
		try {
			empserve.add();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    	res.sendRedirect("EmpFetch.jsp");
	}

}
