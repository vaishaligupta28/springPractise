<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>User already present Page</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<%
		System.out.println("user already present jsp page");
	%>
	<div align="center">
		<form:form action="changePass" method="POST" commandName="login">
			<fieldset>
				<legend></legend>
				<div>
					<table>
						<div>
							<h3>${alreadyHaveAccMsg}</h3>
							Please enter your password to log in. If you don't remember it, <a
								href="forgotPassword">Reset Password.</a>
						</div></br>
						<div>
							<form:label path="password"></form:label>
							Enter your Password:
							<form:password path="password" />
						</div>
						<tr>
							<td>${invalidPassMsg}</td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit"></td>
						</tr>
					</table>
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>