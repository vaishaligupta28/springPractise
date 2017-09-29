<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home Page</title>
<style type="text/css">
.error{
color:red;
}
</style>
</head>
<body>
	<%
		System.out.println("reset password jsp page");
	%>
	<div align="center">
		<form:form action="changePass" method="POST" commandName="login">
			<fieldset>
				<legend>RESET YOUR PASSWORD</legend>
				<table>
					<tr>
						<td>Password:</td>
						<td><form:password path="password"/>
							<form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Confirm-Password:</td>
						<td><form:password path = "confirmPassword" />
							<form:errors path="confirmPassword" cssClass="error" />
					</tr>
					<tr>

						<td colspan="2"><center>
								<input type="submit" value="Submit">
							</center></td>
					</tr>
					<tr>

 						<td>${tryagainMsg}</td> 
					</tr>
				</table>
			</fieldset>
		</form:form>
	</div>
</body>
</html>