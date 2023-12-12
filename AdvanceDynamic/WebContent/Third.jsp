<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Third jsp page</title>
</head>
<body>
<form action="ThirdCtl" method ="post">
<center>
		<table>
		<h2>User Registration</h2>
			<tr>
				<th>First Name:</th>
				<td><input type="text" name="firstName"></td>
				

			</tr>
			<tr> 
				<th>Last Name:</th>
				<td><input type="text" name="lastName"></td>

			</tr>
			<tr>
				<th>Address:</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th></th>
				<td><button>Submit</button></td>
			</tr>
</body>
</html>