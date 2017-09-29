<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>VERIFY OTP</title>
<style type="text/css">
.error {
	color: red;
}

.OTPmsg {
	color: cyan;
}
</style>
</head>
<body>
	<%
		System.out.println("check OTP  jsp page");
	%>
	<div align="center">
		<form action="reset" method="post">
			<fieldset>
				<legend align="center">RESET YOUR PASSWORD</legend>
				<table>
					<tr>
						<td colspan="2">Enter the OTP recieved:</td>
					</tr>
					<tr>
						<td colspan="2"><input type="text" name="OTP"></td>
					</tr>
					<tr class="error" align="center">
						<td colspan="2">${invalidOTPmsg}</td>
					</tr>
					<tr>
						<td><input type="Submit" value="Reset password"></td>
						<td><input type="button" value="Resend OTP"
							onclick="window.location.href='resendOTP'" /></td>
					</tr>
					<tr class="OTPmsg" align="center">
						<td colspan="2">${OTPmsg}</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>