package com.employee.jspservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServlet;

public class EmployeeServe extends HttpServlet{
	
	//PrintWriter out=response.getWriter();
	Employee emp=new Employee();
	EmployeeDao dao=new EmployeeDao();
	Valid val= new Valid();
	public EmployeeServe()
	{
		
	}

	Scanner c = new Scanner(System.in);
	Scanner in = new Scanner(System.in);
	
	
	public void add() throws SQLException {
	
	dao.inserted();
	
 } 

	 public void edit(int id) throws SQLException
	 {
		 dao.edited(id);
	 }
	
	public List fetch()throws SQLException, IOException {
//	    try {
//			return dao.fetched();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		List empLists=dao.fetched();
		System.out.println("---------------");
		Callable<Boolean> call1= new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				System.out.println("From the file");
				emp.importing();
				return true;
			}
		};
		ExecutorService ex = Executors.newFixedThreadPool(1);
		Future<Boolean> f = ex.submit(call1);
		ex.shutdown();
		return empLists;
		
	}
	
	public void delete() throws SQLException {
		System.out.println("Enter the id to be deleted: ");
		int id=in.nextInt();
		emp.setId(id);
		dao.deleted(id);
	}
	
	public void update() throws SQLException{
		System.out.println("Enter the id to be updated: ");
		int idt=in.nextInt();
		emp.setId(idt);
		System.out.println("Enter the salary: ");
		int salary=in.nextInt();
		emp.setSalary(salary);
		dao.updated(idt);
	}
	
	public void stats() throws SQLException{
		dao.stats();
	}
	
	public void fetchById() throws SQLException{
		System.out.println("Enter the id to be fetched: ");
		int fid=in.nextInt();
		emp.setId(fid);
		dao.fetchId(fid);
	}
	
}
