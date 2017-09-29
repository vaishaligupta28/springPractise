<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REGISTRATION PAGE</title>
<style>
.error {
	color: red;
}

.fieldset {
	display: block;
	/* 	margin: 32px 0px 0px 12px; */
}
</style>

</head>
<body>
	<%
		System.out.println("register jsp page");
	%>
	<form:form id="regForm" commandName="user" action="registerProcess"
		method="post">
		<fieldset>
			<legend align="center">REGISTRATION FORM</legend>
			<div align="center" class="error">${alreadyInUseMsg}</div>
			<table align="center">
				<tr>
					<td><form:label path="username">Username</form:label></td>
					<td><form:input path="username" name="username" id="username" />
					</td>
					<td><form:errors path="username" cssClass="error"
							element="div" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:password path="password" name="password"
							id="password" /></td>
					<td><form:errors path="password" cssClass="error"
							element="div" /></td>
				</tr>
				<tr>
					<td><form:label path="firstname">FirstName</form:label></td>
					<td><form:input path="firstname" name="firstname"
							id="firstname" /></td>
					<td><form:errors path="firstname" cssClass="error"
							element="div" /></td>
				</tr>
				<tr>
					<td><form:label path="lastname">LastName</form:label></td>
					<td><form:input path="lastname" name="lastname" id="lastname" />
					<td><form:errors path="lastname" cssClass="error"
							element="div" /></td>

				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" name="email" id="email" /></td>
					<td><form:errors path="email" cssClass="error" element="div" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register" /></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="Login"
						onclick="window.location.href='/SpringMVCTestProj/'" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="Sign Up using Google+"
						onclick="window.location.href='loginG'" /></td>
				</tr>
				<tr></tr>
			</table>
		</fieldset>
	</form:form>

</body>
</html>