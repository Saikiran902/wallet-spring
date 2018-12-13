<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib  prefix="pt" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center" style="color:Blue;">List of Transactions</h1>
<table align="center" border="2">

<tr>
    <th style="background-color:Orange;">Mobile No</th>
    <th style="background-color:Orange;">TranType</th>
    <th style="background-color:Orange;">Amount</th>
    <th style="background-color:Orange;">Transaction id</th>
</tr>

<pt:forEach var="cust" items="${temp}">


<tr>    
<td>${cust.mobileno}</td>


<td>${cust.trantype}</td>


<td>${cust.amount}</td>

<td>${cust.tranid}</td>
</tr>

</pt:forEach>

</table>
<a href="all">Go to Main Menu</a>
</body>
</html>