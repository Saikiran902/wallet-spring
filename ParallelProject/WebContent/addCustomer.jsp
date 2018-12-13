<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="for" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
</style>
<title>Insert title here</title>
</head>
<body>
<div style="position: center; center: 50%; margin-center: 50px; box-shadow:5px 5px 5px 5px red;">
<h1 align="center" style="color:red;">Add Customer Form</h1>
<for:form method="post" action="insertdata" modelAttribute="my">
<table align="center">
<%-- <tr>
<td>Employee Id</td>
<td><for:input path="empId"/></td>
</tr> --%>




<tr>
<td style="color:red;">Customer Name</td>
<td><for:input path="custName" pattern="[A-Z][a-z]+" title="name should start with capital letter"/></td>
<td><for:errors path="custName"></for:errors></td>
</tr>

<tr>
<td style="color:red;">Customer Mobile Number</td>
<td><for:input path="mobNo" pattern="[7-9]{1}[0-9]{9}" title="mobile number should start with 7,8 or 9 and should be 10 digits"/></td>
<td><for:errors path="mobNo"></for:errors>
</tr>

<tr>
<td style="color:red;">Customer balance</td>
<td><for:input path="balance" pattern="[1-9]{1}[0-9]+" title="enter valid number"/></td>
</tr>

<tr>
<td><input type="submit" value="Add Employee"></input></td>
</tr>
<tr>
<td align="center"><a href = "all">Go to Main Menu</a></td>
</tr>
</table>

</for:form>
</div>
</body>
</html>