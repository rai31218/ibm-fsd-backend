<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDateTime"%>

<!-- <%@include file="" %>  -->
<html>
<body>
<h2>Hello World!</h2>
<h2>Current Date and Time: <%=LocalDateTime.now() %></h2>

<%!
	List<Integer> num= Arrays.asList(9,3,6);
%>
<%=num %>

<% 
int a=9;
out.println("value of a : "+a);
out.println("\n Request: "+request.getRemoteAddr());
out.print(pageContext);
%>
</body>
</html>
