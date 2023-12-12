<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
         String fname=request.getParameter("firstName");
         String lname=request.getParameter("lastName");
         String lid=request.getParameter("loginId");
         String pass=request.getParameter("password");
   %>
	<%=fname%><br>
	<%=lname %><br>
	<%=lid %><br>
	<%=pass %>
</body>
</html>