<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<title>Insert title here</title>
</head>
<%@ include file="Header.jsp"%>

<body>
<%
int pageNo=(int)request.getAttribute("pageNo");
List list=(List)request.getAttribute("list");
int index=((pageNo-1)*5)+1;
List nextList=(List)request.getAttribute("nextList");
Iterator it=list.iterator();%>
<form action="UserListCtl" method="post">
<table>
<tr>
     <td><input type="text" name="firstName"></td>
     <td><input type="submit" name="operation" value="search"></td>
     <td><input type="date" name="dob"></td>
     <td><input type="submit" name="operation" value="searchByDob"></td>
     <td><input type="submit" name="operation" value="delete"></td>
</tr>
</table>

<table border=1>
<tr>
              <th>Select</th>
              <th>S.No </th>
              <th>FirstName</th>
              <th>LastName</th>
              <th>Login Id</th>
              <th>Password</th>
              <th>Dob</th>
              <th>Address</th>
              <th>Edit</th>
</tr>
 <%while(it.hasNext()){ 
          UserBean bean=(UserBean)it.next();
        %>
<tr>
        <td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
        <td><%=index++%></td>
        <td><%=bean.getFirstName() %></td>
        <td><%=bean.getLastName() %></td>
        <td><%=bean.getLoginId() %></td>
        <td><%=bean.getPassword() %></td>
        <td><%=bean.getDob() %></td>
         <td><%=bean.getAddress() %></td>
        <td><a href="#">edit</a></td>
        <%} %>
           
</tr>
</table> 
<table>
<tr>
       	<td><input type="submit" name="operation" value="next"  ></td>
       	        <td><input type="submit" name="operation" value="previous" <%=(pageNo!=1)? "":"disabled" %>></td>

</tr>

</table>


<input type="text" name="pageNo" value="<%=pageNo%>">
</form>
</body>
</html>