<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1 align="center" style="color:blue;">Show customers</h1>

<table align="center" border="2">

<tr>
    <th style="background-color:Orange;">Name</th>
    <th style="background-color:Orange;">Balance</th>
    <th style="background-color:Orange;">Mobile no</th>
</tr>

<a:forEach var="cust" items="${temp}">


<tr>    
<td>${cust.custName}</td>


<td>${cust.balance}</td>


<td>${cust.mobNo}</td>
</tr>

</a:forEach>
</table>
<a href = "all">Go to Main Menu</a>
</body>
</html>