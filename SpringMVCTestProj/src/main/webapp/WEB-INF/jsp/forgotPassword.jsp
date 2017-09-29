<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Forgot Password Page</title>

<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<%
		System.out.println("forgot password jsp page");
	%>
	<div align="center">
		<form:form action="sendOTP" method="post" commandName="user">
			<fieldset>
				<legend align="center">FORGOT YOUR PASSWORD</legend>
				<table>
					<tr>
						<td>Enter the registered email address:</td>
					</tr>
					<tr>
						<td><form:input path="email" /></td>
						<form:errors path="email" cssClass="error" />
					</tr>
					<tr>
						<td><input type="Submit" value="Send OTP"></td>
					</tr>
					<tr class="error">
						<td>${userDoesNotExist}</td>
					</tr>
				</table>
			</fieldset>
		</form:form>
	</div>
</body>
</html>