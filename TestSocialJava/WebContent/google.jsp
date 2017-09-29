<!DOCTYPE html>
<%@page import="com.practise.GlobalCons"%>
<%@page import="com.practise.GooglePojo"%>
<html>
<head>
<title>DEMO - Login With Google using Java</title>
<link href='/css/bootstrap.min.css' rel='stylesheet' type='text/css'/>
</head>
<body>

<%GooglePojo gp = (GooglePojo)request.getAttribute(GlobalCons.AUTH); %>
<div style="width:400px;margin:auto;padding-top:30px;">
  <table class="table table-bordered">
    <tr>
      <td>User ID</td>
      <td><%=gp.getId()%></td>
    </tr>
    <tr>
      <td>Name</td>
      <td><%=gp.getName()%></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><%=gp.getEmail()%></td>
    </tr>
    
    
  </table> 
</div>

</body>
</html>