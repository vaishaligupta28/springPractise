<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.practise.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WELCOME PAGE</title>
</head>
<body>
	<%
		User user = (User) session.getAttribute("user");
		System.out.println("welcome page after registration: userId= " + user.getUserId());
	%>
	<h3 align="center">Welcome page</h3>
	<table>
		<tr>
			<td>Welcome ${user.firstname}</td>
		</tr>
		<tr>
			<td><input type="button" value="Logout"
				onclick="window.location.href='logout'" /></td>

		</tr>
	</table>
</body>
</html>