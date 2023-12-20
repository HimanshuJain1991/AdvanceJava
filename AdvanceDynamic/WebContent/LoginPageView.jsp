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
	<%@ include file="Header.jsp"%>
	<form action="LoginPageCtl" method="post">
		<center>
			<table>


				<h2>User Login</h2>
				<%
					String msg = (String) request.getAttribute("msg");
					String uri = (String) request.getAttribute("uri");
				%>
				<h2 style="color: red">
					<%
						if (msg != null) {
					%>
					<%=msg%>
					<%
						}
					%>

				</h2>

				<tr>
					<th>Login Id:</th>
					<td><input type="text" name="loginId"></td>

				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" name="password"></td>
				</tr>


				<tr>
					<th></th>
					<td><button>Submit</button></td>
				</tr>
			</table>
			<input type="hidden" name="uri" value="<%=uri%>">
	</form>
	</center>
</body>
</html>