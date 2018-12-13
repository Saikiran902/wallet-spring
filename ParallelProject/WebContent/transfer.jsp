<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="for" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="color:Blue;">Fund Transfer Form</h1>

<for:form action="dotransfer" modelAttribute="my">
<table align="center">
<tr>
<td>Enter source mobile no:</td>
<td><input type="text" name="smob" /></td>
</tr>
<tr>
<td>Enter destination mobile no:</td>
<td><input type="text" name="tmob"/></td>
</tr>
<tr>
<td>Enter amount:</td>
<td><input type="text" name="bal"/></td>
</tr>
<tr>
<td align="center"><input type="submit" value="fundtransfer"/></td>
</tr>
</table>
<a href = "all">Go to Main Menu</a>
</for:form>
</body>
</html>