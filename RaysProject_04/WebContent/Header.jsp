<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%UserBean user=(UserBean)session.getAttribute("user"); %>
<%if(user!=null){ %>
<h1>hello <%=user.getFirstName() %></h1>
<h2><a href="LoginPageCtl?operation=logout">Logout</a>|<a href="UserListCtl">UserList</a></h2>

<%}else{ %>
<h1>Hiii Guest</h1>
<%} %>
<hr>
</body>
</html>