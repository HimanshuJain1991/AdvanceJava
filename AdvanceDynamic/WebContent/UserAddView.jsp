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
<%@include file="Header.jsp" %>
<% UserBean bean=(UserBean)request.getAttribute("userbean");
%>
	<%String msg=(String)request.getAttribute("msg") ;%>
		<%if(msg!=null){ %>
		<h2 style="color:Blue"><%=msg %></h2>
		<%} %>

<%//<form action="UserListCtl" method ="post"> %>
<form action="UserAddCtl.do" method ="post">
<center>
<h2 style="color:red">
<%   String editmsg=(String)request.getAttribute("editmsg"); %>
<%if (editmsg!=null){ %>
<%=editmsg %>
<%} %>
</h2>

		<table>
		<h2> User Details</h2>
		<tr>
				
				<td><input type="hidden" name="id" value="<%=(bean!=null)? bean.getId():"" %>" ></td>
				

			</tr>
			<tr>
				<th>First Name:</th>
				<td><input type="text" name="firstName" value="<%=(bean!=null)? bean.getFirstName():"" %>" ></td>
				

			</tr>
			<tr> 
				<th>Last Name:</th>
				<td><input type="text" name="lastName" value="<%=(bean!=null)? bean.getLastName():"" %>"></td>

			</tr>
			<tr>
				<th>Login Id:</th>
				<td><input type="text" name="loginId" value="<%=(bean!=null)? bean.getLoginId():"" %>"></td>

			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="text" name="password" value="<%=(bean!=null)? bean.getPassword():"" %>"></td>
			</tr>
			<tr>
			<th>Date</th>
			<td> <input type="date" name="dob" value="<%=(bean!=null)? bean.getDob():"" %>"> </td>
			</tr>
			<tr>
				<th>Address:</th>
				<td><input type="text" name="address" value="<%=(bean!=null)? bean.getAddress():"" %>"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="<%=(bean!=null)? "Update":"Save" %>"><td>
			</tr>
		</table>
			</form>
	</center>
</body>
</html>