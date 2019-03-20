package com.JDBCEmpasgnmnt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "pass@word1";

	Connection conn = null;
	Statement stmt = null;
	
	Employee emp=new Employee();

	public void required()
	{
	try {
		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	}catch (SQLException se) {
		se.printStackTrace();
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
	}
	public void inserted() throws SQLException
	{
	   required();
	   System.out.println("from dao speaking: "+emp.getName());
	   String sql="insert into employees(name, age, sal,dept) values(?,?,?,?)";
	   PreparedStatement prstmt= conn.prepareStatement(sql);
	   prstmt.setString(1, emp.getName());
	   prstmt.setInt(2,emp.getAge());
	   prstmt.setInt(3,emp.getSalary());
	   prstmt.setString(4, emp.getDept());
	   prstmt.execute();
	   //conn.commit();
	   
	}
	public void fetched() throws SQLException
	{
		required();
		
		String selquer="select * from employees";
		stmt = conn.createStatement();
        ResultSet rs;
		try {
			rs = stmt.executeQuery(selquer);
			System.out.format("\t Id  \t  Name  \t  Age  \t  Salary  \t  Department\n");
			 while(rs.next())
		        {
		        	int age=rs.getInt("age");
		        	System.out.format("\t  %d  \t  %s  \t  %d  \t  %s  \t  %s\n",rs.getInt("id"), rs.getString("name"), age,  rs.getString(4),  rs.getString(5));
		        }
		} catch (SQLException e) {
			e.printStackTrace();
		}   
	}
	
	public void fetchId(int fid) throws SQLException
	{
		required();
		stmt=conn.createStatement();
		ResultSet sel=stmt.executeQuery("select id from employees where id ="+fid);
		Statement st=conn.createStatement();
		PreparedStatement ps=conn.prepareStatement("select * from employees where id ="+fid);
		if(!sel.next())
		{
			System.out.println("Sorry,no matching id found");
		}
		else
		{
		//ps.setInt(1, fid);
		ResultSet rs=ps.executeQuery();
		System.out.format("\t Id  \t  Name  \t  Age  \t  Salary  \t  Department\n");
		while(rs.next())
		{
    	System.out.format("\t  %d  \t  %s  \t  %d  \t  %s  \t  %s\n",rs.getInt("id"), rs.getString("name"), rs.getInt("age"),  rs.getString(4),  rs.getString(5));
		}
		}
	}
	
	
	
	public void deleted(int id) throws SQLException
	{
		required();
		String delete="delete from employees where id=?";
		PreparedStatement del=conn.prepareStatement(delete);
		stmt=conn.createStatement();
		ResultSet sel=stmt.executeQuery("select id from employees where id ="+id);
		if(!sel.next())
		{
			System.out.println("Sorry,no matching id found");
		}
		else
		{
		del.setInt(1, id);
		del.execute();
		System.out.println("Employee with id "+emp.getId()+" deleted");
		}
	}
	
	public void updated(int id) throws SQLException
	{
		required();
		String update="update employees set sal =? where id =?";
		PreparedStatement up=conn.prepareStatement(update);
		stmt=conn.createStatement();
		ResultSet sel=stmt.executeQuery("select id from employees where id ="+id);
		if(!sel.next())
		{
			System.out.println("Sorry,no matching id found");
		}
		else
		{
		up.setInt(1, emp.getSalary());
		up.setInt(2,emp.getId());
		up.execute();
		System.out.println("Employee with id "+emp.getId()+" has been updated");
		}
		
	}
	
	public void stats() throws SQLException
       {
		required();
		
		String sql2="select * from employees where age>25";
		String sql3="select dept from employees group by dept having count(id)>3";
		String sql4="select name from employees where name like 's%' or 'r%'";
		try {
			
			Statement stmt4=conn.createStatement();
			ResultSet rs4 = stmt4.executeQuery(sql4);
			System.out.println("The name of the employees starting with R or S: ");
			 while(rs4.next())
		        {				
		          String name=rs4.getString("name");	
		        System.out.println(name);

		        }
				if(!rs4.next())
			{
				System.out.println("No More Result");
			}
			
			Statement stmt3=conn.createStatement();
			ResultSet rs3 = stmt3.executeQuery(sql3);
			String dept=null;
			System.out.println("The departments that have more than 3 employees: ");
			 while(rs3.next())
		        {				
		        dept=rs3.getString(1);	
		        System.out.println(dept);

		        }
				if(!rs3.next())
			{
				System.out.println("No More Result");
			}
			
			
			Statement stmt2=conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			
			System.out.println("The employees with age greater than 25: ");	
			 while(rs2.next())
		        {
				
		        	int age=rs2.getInt("age");
		        	System.out.format("%d  \t%s  \t%d\n",rs2.getInt("id"), rs2.getString("name"), age);
		        }
			
			if(!rs2.next())
			{
				System.out.println("No more Result");
			}
			 
			 String sql1="select sum(sal) from employees";
			 Statement stmt1 = conn.createStatement();
			 ResultSet rs1 = stmt1.executeQuery(sql1);
			 while(rs1.next())
		        {
				
		        	int sal=rs1.getInt(1);
		        
		        System.out.println("The total salary incurred by employees is : "+sal);
		        }
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		}
}
