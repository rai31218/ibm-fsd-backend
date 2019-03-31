<%@page import="java.util.Collection"%>
<%@page import="com.employee.jspservlet.Employee"%>
<%@page import="com.employee.jspservlet.EmployeeDao"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.employee.jspservlet.EmployeeServe" %>    
<%@page import="com.employee.jspservlet.EmployeeDao" %> 
<%@page import="java.sql.*" %> 
             
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2px solid">
<%
EmployeeDao dao=new EmployeeDao();
List empLists=dao.fetched();
 Employee empList=(Employee)session.getAttribute("ListEmp");
 int id=empList.getId();
%>
<tr><td><%out.println(empLists); %></td>
<td><a href="edit.jsp?id"+id>Edit</a></td>
<td><a href="delete.jsp">Delete</a></td></tr>

</table>

</body>
</html>