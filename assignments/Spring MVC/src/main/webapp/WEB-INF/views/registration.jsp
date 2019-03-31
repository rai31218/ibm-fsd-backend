<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>Registration</title>
</head>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<body>
<p> ${exception.errorMsg}</p>
<br>
<h2>Registration</h2>

<spring:url value="/" var="contextPath" htmlEscape="true" />

<form:form method="POST" modelAttribute="registration" action="${contextPath}/regsauthenticate">
   <table>
   <tr>
        <td><form:label path="name">Name:</form:label></td>
        <td><form:input path="name" /></td>
        <td><form:errors path="name" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="userName" >UserName:</form:label></td>
        <td><form:input path="userName" /></td>
        <td><form:errors path="userName" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="password">Password:</form:label></td>
        <td><form:password path="password" /></td>
        <td><form:errors path="password" cssClass="error" /></td>
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="submit" value="Register"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>