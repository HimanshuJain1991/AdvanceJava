<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

  
</style>
</head>
<body>
<% 
     UserBean user=(UserBean)session.getAttribute("user");


%>
<%   
       if(user!=null){ 
%>
<h3>Hii    <%=user.getFirstName()+" "+user.getLastName() %>

</h3>
<h2><a href="LoginPageCtl?operation=logout" >Logout</a> |<a href="UserListCtl.do">User List</a>
 |<a href="UserAddView.jsp">Add User</a>
</h2>

<%
      } else{
	
%>
<h3>Hii Guest</h3>
<% }
%>
<hr>
</body>
</html>