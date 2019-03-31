<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	 	String un1=(String) session.getAttribute("uname");
	    //String pwd1=request.getParameter("pwd");	
		out.print("Hello "+un1);
		%>
<form action="logout.do">
<button type="submit" value="Logout">LogOut</button>
</form>
</body>
</html>