<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN PAGE</title>
<style type="text/css">
.error {
	color: red;
}

#loginForm {
	margin-left: 500;
	position: fixed;
	top: 100;
	left: 0;
	width: 100%;
	margin: 0 auto;
}
</style>
</head>
<body>
	<%
		System.out.println("login jsp page");
	%>
	<form:form id="loginForm" commandName="newLogin" action="loginProcess"
		method="post">
		<fieldset>
			<legend align="center">LOGIN FORM</legend>
			<div align="center" class="error">${passChangeMsg}</div>
			<div align="center" class="error">${logoutMsg}</div>
			<table align="center">
				<tr>
					<td><form:label path="username">Username: </form:label></td>
					<td><form:input path="username" /></td>
					<td><form:errors path="username" cssClass="error"
							element="div"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error"
							element="div"></form:errors></td>
				</tr>
				<tr>
					<td></td>
					<td style="font-style: italic; color: red;">${message}</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="Register"
						onclick="window.location.href='register'" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="Forgot Password"
						onclick="window.location.href='forgotPassword'" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="Sign in using Google+"
						onclick="window.location.href='loginG'" /></td>
				</tr>
			</table>
		</fieldset>
	</form:form>
</body>
</html>