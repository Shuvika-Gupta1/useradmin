<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.mvc.bean.RegisterBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<table border="1">
<tr>
<td>Full Name</td>
<td>Email</td>
<td>User Name</td>
<td>Password</td>
<td>Admin</td>

<td colspan="2">Change</td>
</tr>
<c:forEach var="user" items="${users}">
<tr>
	<td>
		<c:out value="${user.fullName}"></c:out>
	</td>
	<td>
		<c:out value="${user.email}"></c:out>
	</td>
	<td>
		<c:out value="${user.userName}"></c:out>
	</td>
	<td>
		<c:out value="${user.password}"></c:out>
	</td>
	<td>
		<c:out value="${user.admin}"></c:out>
	</td>
</tr>
</c:forEach>
</table> 
