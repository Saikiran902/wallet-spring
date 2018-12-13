<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="pt" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="color:Blue;">Transaction Form</h1>
<pt:form method="post" action="print" modelAttribute="my">
<table align="center">
<%-- <tr>
<td>Employee Id</td>
<td><for:input path="empId"/></td>
</tr> --%>




<tr>
<td>Mobile Number</td>
<td><pt:input path="mobileno" pattern="[7-9]{1}[0-9]{9}" title="mobile number should start with 7,8 or 9 and should be 10 digits"/></td>
<td><pt:errors path="mobileno"></pt:errors></td>
</tr>


<tr>
<td><input type="submit" value="print"></input></td>
</tr>
</table>
<a href = "all">Go to Main Menu</a>
</pt:form>
</body>
</html>